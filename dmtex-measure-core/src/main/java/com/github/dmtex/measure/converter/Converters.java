package com.github.dmtex.measure.converter;

import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;

/**
 * {@code Converters} class provides utility methods for getting converters.
 *
 * @author Denis Murashev
 *
 * @since Measure Core 1.0
 */
public final class Converters {

  /**
   * Identity converter.
   */
  public static final UnitConverter IDENTITY = new IdentityConverter();

  private Converters() {
  }

  /**
   * Provides converter for given offset.
   *
   * @param offset offset
   * @return unit converter
   */
  public static UnitConverter fromOffset(Number offset) {
    if (offset == null) {
      throw new IllegalArgumentException("Offset cannot be null");
    }
    if (offset.doubleValue() == 0) {
      return IDENTITY;
    }
    return new AddConverter(offset);
  }

  /**
   * Provides converter for given factor.
   *
   * @param factor factor
   * @return unit converter
   */
  public static UnitConverter fromFactor(Number factor) {
    if (factor == null || factor.doubleValue() == 0) {
      throw new IllegalArgumentException("Factor cannot be null or zero");
    }
    if (factor.doubleValue() == 1) {
      return IDENTITY;
    }
    return new MultiplyConverter(factor);
  }

  private static class IdentityConverter implements UnitConverter {

    @Override
    public boolean isIdentity() {
      return true;
    }

    @Override
    public boolean isLinear() {
      return true;
    }

    @Override
    public UnitConverter inverse() {
      return this;
    }

    @Override
    public Number convert(Number value) {
      return value;
    }

    @Override
    public double convert(double value) {
      return value;
    }

    @Override
    public UnitConverter concatenate(UnitConverter converter) {
      return converter;
    }

    @Override
    public List<? extends UnitConverter> getConversionSteps() {
      return Collections.singletonList(this);
    }
  }
}
