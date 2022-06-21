package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.converter.Converters;
import com.github.dmtex.measure.dimension.Dimensions;
import java.util.HashMap;
import java.util.Map;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code ProductUnit} class represents product unit.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 1.0
 */
final class ProductUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

  private final Element[] elements;

  ProductUnit() {
    this(new Element[0]);
  }

  private ProductUnit(Element[] elements) {
    super("");
    this.elements = elements.clone();
  }

  static AbstractUnit<?> getProductInstance(AbstractUnit<?> left, AbstractUnit<?> right) {
    return getUnitInstance(extract(left), extract(right));
  }

  static AbstractUnit<?> getQuotientInstance(AbstractUnit<?> left, AbstractUnit<?> right) {
    Element[] leftElems = extract(left);
    Element[] elems = extract(right);
    Element[] rightElems = new Element[elems.length];
    int index = 0;
    for (Element e : elems) {
      rightElems[index] = new Element(e.unit, -e.pow, e.root);
      index++;
    }
    return getUnitInstance(leftElems, rightElems);
  }

  static AbstractUnit<?> getRootInstance(AbstractUnit<?> unit, int n) {
    Element[] elems = extract(unit);
    Element[] unitElems = new Element[elems.length];
    int index = 0;
    for (Element e : elems) {
      int gcd = gcd(Math.abs(e.pow), e.root * n);
      unitElems[index] = new Element(e.unit, e.pow / gcd, e.root * n / gcd);
      index++;
    }
    return getUnitInstance(unitElems, new Element[0]);
  }

  static AbstractUnit<?> getPowInstance(AbstractUnit<?> unit, int n) {
    Element[] elems = extract(unit);
    Element[] unitElems = new Element[elems.length];
    for (int i = 0; i < elems.length; i++) {
      int gcd = gcd(Math.abs(elems[i].pow * n), elems[i].root);
      unitElems[i] = new Element(elems[i].unit, elems[i].pow * n / gcd, elems[i].root / gcd);
    }
    return getUnitInstance(unitElems, new Element[0]);
  }

  @Override
  public Map<Unit<?>, Integer> getBaseUnits() {
    Map<Unit<?>, Integer> units = new HashMap<>();
    for (Element e : elements) {
      units.put(e.unit, e.pow);
    }
    return units;
  }

  @Override
  public AbstractUnit<?> multiply(Unit<?> multiplier) {
    if (elements.length == 0 && multiplier instanceof AbstractUnit) {
      return (AbstractUnit<?>) multiplier;
    }
    return super.multiply(multiplier);
  }

  @SuppressWarnings("unchecked")
  @Override
  public AbstractUnit<Q> toSystemUnit() {
    Unit<?> systemUnit = new ProductUnit<>();
    for (Element element : elements) {
      Unit<?> unit = element.unit.getSystemUnit();
      unit = unit.pow(element.pow);
      unit = unit.root(element.root);
      systemUnit = systemUnit.multiply(unit);
    }
    return (AbstractUnit<Q>) systemUnit;
  }

  @Override
  public UnitConverter getSystemConverter() {
    UnitConverter converter = Converters.IDENTITY;
    for (Element e : elements) {
      UnitConverter c = e.unit.getSystemConverter();
      if (!c.isLinear()) {
        throw new UnsupportedOperationException(e.unit + " is non-linear, cannot convert");
      }
      if (e.root != 1) {
        throw new UnsupportedOperationException(e.unit + " holds a base unit with fractional exponent");
      }
      int pow = e.pow;
      // Negative power.
      if (pow < 0) {
        pow = -pow;
        c = c.inverse();
      }
      for (int j = 0; j < pow; j++) {
        converter = converter.concatenate(c);
      }
    }
    return converter;
  }

  @Override
  public Dimension getDimension() {
    Dimension dimension = Dimensions.DIMENSIONLESS;
    for (Element e : elements) {
      Unit<?> unit = e.unit;
      if (unit.getDimension() != null) {
        Dimension d = unit.getDimension().pow(e.pow).root(e.root);
        dimension = dimension.multiply(d);
      }
    }
    return dimension;
  }

  private static AbstractUnit<?> getUnitInstance(Element[] leftElems, Element[] rightElems) {
    // Merges left elements with right elements.
    Element[] result = new Element[leftElems.length + rightElems.length];
    int resultIndex = processLeft(leftElems, rightElems, result);

    // Appends remaining right elements not merged.
    for (Element rightElem : rightElems) {
      Unit<?> unit = rightElem.unit;
      boolean hasBeenMerged = false;
      for (Element leftElem : leftElems) {
        if (unit.equals(leftElem.unit)) {
          hasBeenMerged = true;
          break;
        }
      }
      if (!hasBeenMerged) {
        result[resultIndex++] = rightElem;
      }
    }

    // Returns or creates instance.
    if (resultIndex == 0) {
      return new ProductUnit<>();
    }
    if (resultIndex == 1 && result[0].pow == result[0].root) {
      return result[0].unit;
    }
    Element[] elems = new Element[resultIndex];
    System.arraycopy(result, 0, elems, 0, resultIndex);
    return new ProductUnit<>(elems);
  }

  private static int processLeft(Element[] leftElems, Element[] rightElems, Element[] result) {
    int resultIndex = 0;
    for (Element leftElem : leftElems) {
      AbstractUnit<?> unit = leftElem.unit;
      int p1 = leftElem.pow;
      int r1 = leftElem.root;
      int p2 = 0;
      int r2 = 1;
      for (Element rightElem : rightElems) {
        if (unit.equals(rightElem.unit)) {
          p2 = rightElem.pow;
          r2 = rightElem.root;
          // No duplicate.
          break;
        }
      }
      int pow = p1 * r2 + p2 * r1;
      int root = r1 * r2;
      if (pow != 0) {
        int gcd = gcd(Math.abs(pow), root);
        result[resultIndex++] = new Element(unit, pow / gcd, root / gcd);
      }
    }
    return resultIndex;
  }

  private static int gcd(int m, int n) {
    return n == 0 ? m : gcd(n, m % n);
  }

  private static Element[] extract(AbstractUnit<?> unit) {
    if (unit instanceof ProductUnit) {
      return ((ProductUnit<?>) unit).elements;
    }
    if (unit instanceof AlternateUnit) {
      return extract(((AlternateUnit<?>) unit).getParent());
    }
    return new Element[] {new Element(unit, 1, 1)};
  }

  private static final class Element {

    private final AbstractUnit<?> unit;
    private final int pow;
    private final int root;

    private Element(AbstractUnit<?> unit, int pow, int root) {
      this.unit = unit;
      this.pow = pow;
      this.root = root;
    }
  }
}
