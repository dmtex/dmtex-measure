package com.github.dmtex.measure.unit;

import com.github.dmtex.math.adapter.Adapters;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.format.UnitNameHelper;
import javax.measure.IncommensurableException;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import static com.github.dmtex.measure.converter.Converters.IDENTITY;
import static com.github.dmtex.measure.converter.Converters.fromFactor;
import static com.github.dmtex.measure.converter.Converters.fromOffset;

/**
 * {@code AbstractUnit} class represents base general {@link Unit} implementation.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 1.0
 */
public abstract class AbstractUnit<Q extends Quantity<Q>> implements Unit<Q> {

  private static final String ERROR_NOT_COMPATIBLE = "Units are not compatible";

  private final String name;

  /**
   * Initializes unit with given name.
   *
   * @param name unit's name code
   */
  protected AbstractUnit(String name) {
    this.name = name;
  }

  @Override
  public String getSymbol() {
    return new MeasureUnitFormat().format(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public final AbstractUnit<Q> getSystemUnit() {
    return toSystemUnit();
  }

  @Override
  public boolean isCompatible(Unit<?> that) {
    if (equals(that)) {
      return true;
    }
    if (that instanceof AbstractUnit) {
      if (getDimension().equals(that.getDimension())) {
        return true;
      }
      return getDimension().getBaseDimensions().equals(that.getDimension().getBaseDimensions());
    }
    return false;
  }

  @Override
  public boolean isEquivalentTo(Unit<Q> unit) {
    return getConverterTo(unit).isIdentity();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Quantity<T>> AbstractUnit<T> asType(Class<T> type) {
    // TODO Check dimension
    return (AbstractUnit<T>) this;
  }

  @Override
  public UnitConverter getConverterTo(Unit<Q> that) {
    if (equals(that)) {
      return IDENTITY;
    }
    if (getSystemUnit().equals(that.getSystemUnit())) {
      UnitConverter thisToSystem = getSystemConverter();
      UnitConverter thatToSystem = that.getConverterTo(that.getSystemUnit());
      return thatToSystem.inverse().concatenate(thisToSystem);
    }
    try {
      return getConverterToAny(that);
    } catch (IncommensurableException e) {
      throw new UnconvertibleException(e);
    }
  }

  @Override
  public UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException {
    if (!isCompatible(that)) {
      throw new IncommensurableException(this + " is not compatible with " + that);
    }
    UnitConverter thisConverter = getConverter(this);
    UnitConverter thatConverter = getConverter((AbstractUnit<?>) that);
    return thatConverter.inverse().concatenate(thisConverter);
  }

  private static UnitConverter getConverter(AbstractUnit<?> unit) {
    return IDENTITY.concatenate(unit.getSystemConverter());
  }

  @Override
  public AbstractUnit<Q> alternate(String symbol) {
    return new AlternateUnit<>(symbol, this);
  }

  @Override
  public AbstractUnit<Q> shift(Number offset) {
    return transform(fromOffset(offset));
  }

  @Override
  public AbstractUnit<Q> shift(double offset) {
    return transform(fromOffset(offset));
  }

  @Override
  public AbstractUnit<Q> multiply(Number multiplier) {
    return transform(fromFactor(multiplier));
  }

  @Override
  public AbstractUnit<Q> multiply(double multiplier) {
    return transform(fromFactor(multiplier));
  }

  @Override
  public AbstractUnit<?> multiply(Unit<?> multiplier) {
    if (multiplier instanceof AbstractUnit) {
      String unitName = UnitNameHelper.multiply(this, multiplier);
      return ProductUnit.getProductInstance(this, (AbstractUnit<?>) multiplier).alternate(unitName);
    }
    throw new UnsupportedOperationException(ERROR_NOT_COMPATIBLE);
  }

  @Override
  public AbstractUnit<?> inverse() {
    return ProductUnit.getQuotientInstance(new ProductUnit<>(), this);
  }

  @Override
  public AbstractUnit<Q> divide(Number divisor) {
    return transform(fromFactor(Adapters.lookup(divisor).reciprocal()));
  }

  @Override
  public AbstractUnit<Q> divide(double divisor) {
    return transform(fromFactor(1.0 / divisor));
  }

  @Override
  public AbstractUnit<?> divide(Unit<?> divisor) {
    if (divisor instanceof AbstractUnit) {
      String unitName = UnitNameHelper.divide(this, divisor);
      return ProductUnit.getQuotientInstance(this, (AbstractUnit<?>) divisor).alternate(unitName);
    }
    throw new UnsupportedOperationException(ERROR_NOT_COMPATIBLE);
  }

  @Override
  public AbstractUnit<?> root(int n) {
    if (n > 0) {
      return ProductUnit.getRootInstance(this, n);
    }
    if (n == 0) {
      throw new ArithmeticException("Root's order of zero");
    }
    return new ProductUnit<>().divide(root(-n));
  }

  @Override
  public AbstractUnit<?> pow(int n) {
    if (n > 0) {
      return ProductUnit.getPowInstance(this, n).alternate(UnitNameHelper.pow(this, n));
    }
    if (n == 0) {
      return new ProductUnit<>();
    }
    return new ProductUnit<>().divide(pow(-n)).alternate(UnitNameHelper.pow(this, n));
  }

  @Override
  public AbstractUnit<Q> transform(UnitConverter operation) {
    AbstractUnit<Q> systemUnit = getSystemUnit();
    UnitConverter converter = isSystemUnit() ? getSystemConverter().concatenate(operation) : operation;
    if (IDENTITY.equals(converter)) {
      return systemUnit;
    }
    return new TransformedUnit<>(this, converter);
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public AbstractUnit<Q> prefix(Prefix prefix) {
    return transform(fromFactor(prefix.getValue())).alternate(UnitNameHelper.prefix(prefix, this));
  }

  /**
   * Provides converter to system unit.
   *
   * @return converter to system unit
   */
  public abstract UnitConverter getSystemConverter();

  /**
   * Checks if current unit is system.
   * The implementation can be changed only for base units.
   *
   * @return checks if unit is system
   */
  public boolean isSystemUnit() {
    return equals(toSystemUnit());
  }

  /**
   * Provides system unit.
   *
   * @return system unit
   */
  protected abstract AbstractUnit<Q> toSystemUnit();
}
