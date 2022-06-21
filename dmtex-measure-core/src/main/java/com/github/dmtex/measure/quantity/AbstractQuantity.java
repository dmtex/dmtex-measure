package com.github.dmtex.measure.quantity;

import com.github.dmtex.math.adapter.Adapters;
import com.github.dmtex.math.adapter.ArithmeticAware;
import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.Objects;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code AbstractQuantity} class represents generic {@link Quantity} implementation.
 *
 * @author Denis Murashev
 *
 * @param <Q> quantity type
 *
 * @since Measure 1.0
 */
public abstract class AbstractQuantity<Q extends Quantity<Q>> implements Quantity<Q>, Comparable<Quantity<Q>> {

  private final Number value;
  private final AbstractUnit<Q> unit;
  private final ArithmeticAware<?> adapter;
  private final Scale scale;

  /**
   * Initializes instance with value, unit and scale.
   *
   * @param value value
   * @param unit  unit
   * @param scale scale
   */
  protected AbstractQuantity(Number value, AbstractUnit<Q> unit, Scale scale) {
    this.value = value;
    this.unit = unit;
    adapter = Adapters.lookup(value);
    this.scale = scale;
  }

  /**
   * Initializes instance with value and unit.
   *
   * @param value value
   * @param unit  unit
   */
  protected AbstractQuantity(Number value, AbstractUnit<Q> unit) {
    this(value, unit, Scale.ABSOLUTE);
  }

  @Override
  public Q add(Quantity<Q> augend) {
    return factory().apply(adapter.plus(augend.to(unit).getValue()), unit);
  }

  @Override
  public Q subtract(Quantity<Q> subtrahend) {
    return factory().apply(adapter.minus(subtrahend.to(unit).getValue()), unit);
  }

  @Override
  public Quantity<?> divide(Quantity<?> divisor) {
    return new QuantityImpl<>(adapter.div(divisor.getValue()), unit.divide(divisor.getUnit()));
  }

  @Override
  public Q divide(Number divisor) {
    return factory().apply(adapter.div(divisor), unit);
  }

  @Override
  public Quantity<?> multiply(Quantity<?> multiplier) {
    return new QuantityImpl<>(adapter.multiply(multiplier.getValue()), unit.multiply(multiplier.getUnit()));
  }

  @Override
  public Q multiply(Number multiplier) {
    return factory().apply(adapter.multiply(multiplier), unit);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Q to(Unit<Q> unit) {
    if (unit.equals(getUnit())) {
      return (Q) this;
    }
    if (unit instanceof AbstractUnit) {
      return factory().apply(adjust(unit), (AbstractUnit<Q>) unit);
    }
    throw new UnsupportedOperationException("Unit class is not supported: " + unit.getClass());
  }

  @Override
  public Quantity<?> inverse() {
    return new QuantityImpl<>(adapter.reciprocal(), unit.inverse());
  }

  @Override
  public Q negate() {
    return factory().apply(adapter.negate(), unit);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Quantity<T>> T asType(Class<T> type) {
    // TODO Check dimension
    return (T) this;
  }

  @Override
  public Number getValue() {
    return value;
  }

  @Override
  public Unit<Q> getUnit() {
    return unit;
  }

  @Override
  public Scale getScale() {
    return scale;
  }

  @Override
  public boolean isEquivalentTo(Quantity<Q> quantity) {
    return compareTo(quantity) == 0;
  }

  @Override
  public int compareTo(Quantity<Q> o) {
    Quantity<Q> other = unit.equals(o.getUnit()) ? o : o.to(unit);
    return Double.compare(value.doubleValue(), other.getValue().doubleValue());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    Quantity<?> quantity = (Quantity<?>) o;
    return value.equals(quantity.getValue())
        && unit.equals(quantity.getUnit())
        && scale.equals(quantity.getScale());
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit, scale);
  }

  @Override
  public String toString() {
    return String.format("%s%s", value, unit);
  }

  /**
   * Provides factory.
   *
   * @return quantity factory
   */
  protected abstract BiFunction<Number, AbstractUnit<Q>, Q> factory();

  private Number adjust(Unit<Q> unit) {
    UnitConverter converter = getUnit().getConverterTo(unit);
    return converter.convert(getValue());
  }
}
