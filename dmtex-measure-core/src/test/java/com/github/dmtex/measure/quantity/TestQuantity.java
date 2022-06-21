package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.TestUnit;
import javax.measure.Quantity;
import javax.measure.Unit;

public class TestQuantity<Q extends Quantity<Q>> implements Quantity<Q> {

  @Override
  public Quantity<Q> add(Quantity<Q> addend) {
    return null;
  }

  @Override
  public Quantity<Q> subtract(Quantity<Q> subtrahend) {
    return null;
  }

  @Override
  public Quantity<?> divide(Quantity<?> divisor) {
    return null;
  }

  @Override
  public Quantity<Q> divide(Number divisor) {
    return null;
  }

  @Override
  public Quantity<?> multiply(Quantity<?> multiplicand) {
    return null;
  }

  @Override
  public Quantity<Q> multiply(Number multiplicand) {
    return null;
  }

  @Override
  public Quantity<Q> to(Unit<Q> unit) {
    return null;
  }

  @Override
  public Quantity<?> inverse() {
    return null;
  }

  @Override
  public Quantity<Q> negate() {
    return null;
  }

  @Override
  public <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
    return null;
  }

  @Override
  public Number getValue() {
    return 1;
  }

  @Override
  public Unit<Q> getUnit() {
    return new TestUnit<>();
  }

  @Override
  public Scale getScale() {
    return null;
  }

  @Override
  public boolean isEquivalentTo(Quantity<Q> that) {
    return false;
  }
}
