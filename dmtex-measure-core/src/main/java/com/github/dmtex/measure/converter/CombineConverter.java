package com.github.dmtex.measure.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.measure.UnitConverter;

final class CombineConverter extends AbstractConverter {

  private final UnitConverter left;
  private final UnitConverter right;

  CombineConverter(UnitConverter left, UnitConverter right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean isLinear() {
    return left.isLinear() && right.isLinear();
  }

  @Override
  public CombineConverter inverse() {
    return new CombineConverter(right.inverse(), left.inverse());
  }

  @Override
  public Number convert(Number value) {
    return left.convert(right.convert(value));
  }

  @Override
  public double convert(double value) {
    return left.convert(right.convert(value));
  }

  @Override
  public List<UnitConverter> getConversionSteps() {
    List<UnitConverter> steps = new ArrayList<>();
    steps.addAll(left.getConversionSteps());
    steps.addAll(right.getConversionSteps());
    return steps;
  }

  @Override
  public String toString() {
    return "CombineConverter(" + left + "," + right + ")";
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
    CombineConverter that = (CombineConverter) o;
    return left.equals(that.left) && right.equals(that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }
}
