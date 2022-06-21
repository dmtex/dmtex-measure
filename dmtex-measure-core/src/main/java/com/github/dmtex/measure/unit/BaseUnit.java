package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.converter.Converters;
import com.github.dmtex.measure.dimension.Dimensions;
import java.util.Map;
import java.util.Optional;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code BaseUnit} class represents base unit.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 1.0
 */
final class BaseUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

  private final transient Dimension dimension;

  BaseUnit(String name, Dimension dimension) {
    super(name);
    this.dimension = Optional.ofNullable(dimension).orElse(Dimensions.DIMENSIONLESS);
  }

  BaseUnit(String name) {
    this(name, Dimensions.DIMENSIONLESS);
  }

  @Override
  public UnitConverter getSystemConverter() {
    return Converters.IDENTITY;
  }

  @Override
  public Dimension getDimension() {
    return dimension;
  }

  @Override
  public Map<? extends Unit<?>, Integer> getBaseUnits() {
    return Map.of(this, 1);
  }

  @Override
  public boolean isSystemUnit() {
    return true;
  }

  @Override
  public AbstractUnit<Q> toSystemUnit() {
    return this;
  }
}
