package com.github.dmtex.measure.unit;

import java.util.Map;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

final class AlternateUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

  private final AbstractUnit<Q> parent;

  AlternateUnit(String name, AbstractUnit<Q> parent) {
    super(name);
    this.parent = parent instanceof AlternateUnit ? ((AlternateUnit<Q>) parent).parent : parent;
  }

  @Override
  public Dimension getDimension() {
    return parent.getDimension();
  }

  @Override
  public Map<? extends Unit<?>, Integer> getBaseUnits() {
    return parent.getBaseUnits();
  }

  @Override
  public UnitConverter getSystemConverter() {
    return parent.getSystemConverter();
  }

  @Override
  public AbstractUnit<Q> toSystemUnit() {
    return parent.toSystemUnit();
  }

  AbstractUnit<Q> getParent() {
    return parent;
  }
}
