package com.github.dmtex.measure.unit;

import java.util.Map;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code TransformedUnit} class represents unit created by transformation of another unit.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 1.0
 */
final class TransformedUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

  private final AbstractUnit<Q> parent;
  private final UnitConverter converter;

  TransformedUnit(AbstractUnit<Q> parent, UnitConverter converter) {
    super(null);
    this.parent = parent;
    this.converter = converter;
  }

  @Override
  public Dimension getDimension() {
    return parent.getDimension();
  }

  @Override
  public UnitConverter getSystemConverter() {
    return parent.getSystemConverter().concatenate(converter);
  }

  @Override
  public AbstractUnit<Q> toSystemUnit() {
    return parent.getSystemUnit();
  }

  @Override
  public Map<? extends Unit<?>, Integer> getBaseUnits() {
    return parent.getBaseUnits();
  }

  /**
   * Provides converter used.
   *
   * @return converter
   */
  public UnitConverter getConverter() {
    return converter;
  }
}
