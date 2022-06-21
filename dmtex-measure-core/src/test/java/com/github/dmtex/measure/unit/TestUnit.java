package com.github.dmtex.measure.unit;

import java.util.Map;
import javax.measure.Dimension;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

public class TestUnit<Q extends Quantity<Q>> implements Unit<Q> {

  @Override
  public String getSymbol() {
    return "test";
  }

  @Override
  public String getName() {
    return "test";
  }

  @Override
  public Dimension getDimension() {
    return null;
  }

  @Override
  public Unit<Q> getSystemUnit() {
    return null;
  }

  @Override
  public Map<? extends Unit<?>, Integer> getBaseUnits() {
    return null;
  }

  @Override
  public boolean isCompatible(Unit<?> that) {
    return false;
  }

  @Override
  public boolean isEquivalentTo(Unit<Q> unit) {
    return false;
  }

  @Override
  public <T extends Quantity<T>> Unit<T> asType(Class<T> type) {
    return null;
  }

  @Override
  public UnitConverter getConverterTo(Unit<Q> that) {
    return null;
  }

  @Override
  public UnitConverter getConverterToAny(Unit<?> that) {
    return null;
  }

  @Override
  public Unit<Q> alternate(String symbol) {
    return null;
  }

  @Override
  public Unit<Q> shift(Number offset) {
    return null;
  }

  @Override
  public Unit<Q> shift(double offset) {
    return null;
  }

  @Override
  public Unit<Q> multiply(Number multiplier) {
    return null;
  }

  @Override
  public Unit<Q> multiply(double multiplier) {
    return null;
  }

  @Override
  public Unit<?> multiply(Unit<?> multiplier) {
    return null;
  }

  @Override
  public Unit<?> inverse() {
    return null;
  }

  @Override
  public Unit<Q> divide(Number divisor) {
    return null;
  }

  @Override
  public Unit<Q> divide(double divisor) {
    return null;
  }

  @Override
  public Unit<?> divide(Unit<?> divisor) {
    return null;
  }

  @Override
  public Unit<?> root(int n) {
    return null;
  }

  @Override
  public Unit<?> pow(int n) {
    return null;
  }

  @Override
  public Unit<Q> transform(UnitConverter operation) {
    return null;
  }

  @Override
  public Unit<Q> prefix(Prefix prefix) {
    return null;
  }
}
