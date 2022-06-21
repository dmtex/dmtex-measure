package com.github.dmtex.measure.converter;

import com.github.dmtex.math.adapter.Adapters;
import com.github.dmtex.math.adapter.ArithmeticAware;
import java.util.Objects;
import javax.measure.UnitConverter;

final class AddConverter extends AbstractConverter {

  private final Number offset;
  private final ArithmeticAware<?> adapter;

  AddConverter(Number offset) {
    this.offset = offset;
    adapter = Adapters.lookup(offset);
  }

  @Override
  public boolean isLinear() {
    return false;
  }

  @Override
  public AddConverter inverse() {
    return new AddConverter(adapter.negate());
  }

  @Override
  public Number convert(Number value) {
    return Adapters.lookup(value).plus(offset);
  }

  @Override
  public double convert(double value) {
    return value + offset.doubleValue();
  }

  @Override
  public UnitConverter concatenate(UnitConverter converter) {
    if (converter instanceof AddConverter) {
      Number o = adapter.plus(((AddConverter) converter).offset);
      return o.doubleValue() == 0 ? Converters.IDENTITY : new AddConverter(o);
    }
    return super.concatenate(converter);
  }

  @Override
  public String toString() {
    return "AddConverter(" + offset + ")";
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
    AddConverter that = (AddConverter) o;
    return offset.equals(that.offset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset);
  }
}
