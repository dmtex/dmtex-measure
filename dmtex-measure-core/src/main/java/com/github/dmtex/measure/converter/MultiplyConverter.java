package com.github.dmtex.measure.converter;

import com.github.dmtex.math.adapter.Adapters;
import com.github.dmtex.math.rational.BigRational;
import java.util.Objects;
import javax.measure.UnitConverter;

final class MultiplyConverter extends AbstractConverter {

  private final BigRational factor;

  MultiplyConverter(Number factor) {
    this.factor = BigRational.ONE.multiply(factor);
  }

  @Override
  public boolean isLinear() {
    return true;
  }

  @Override
  public UnitConverter inverse() {
    return new MultiplyConverter(factor.reciprocal());
  }

  @Override
  public Number convert(Number value) {
    return Adapters.lookup(value).multiply(factor);
  }

  @Override
  public double convert(double value) {
    return value * factor.doubleValue();
  }

  @Override
  public UnitConverter concatenate(UnitConverter converter) {
    if (converter instanceof MultiplyConverter) {
      MultiplyConverter c = (MultiplyConverter) converter;
      Number f = factor.multiply(c.factor);
      return f.doubleValue() == 1 ? Converters.IDENTITY : new MultiplyConverter(f);
    }
    return super.concatenate(converter);
  }

  @Override
  public String toString() {
    return "MultiplyConverter(" + factor + ")";
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
    MultiplyConverter that = (MultiplyConverter) o;
    return factor.equals(that.factor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factor);
  }
}
