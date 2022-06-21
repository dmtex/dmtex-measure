package com.github.dmtex.measure.dimension;

import java.util.HashMap;
import java.util.Map;
import javax.measure.Dimension;

enum BaseDimension implements Dimension {

  /**
   * Length (L).
   */
  LENGTH,

  /**
   * Mass (M).
   */
  MASS,

  /**
   * Time (T).
   */
  TIME,

  /**
   * Electric current (I).
   */
  ELECTRIC_CURRENT,

  /**
   * Temperature dimension (\Theta \u0398).
   */
  TEMPERATURE,

  /**
   * Amount of substance (N).
   */
  AMOUNT_OF_SUBSTANCE,

  /**
   * Luminous intensity (J).
   */
  LUMINOUS_INTENSITY;

  private final Map<Dimension, Integer> base = new HashMap<>();

  BaseDimension() {
    base.put(this, 1);
  }

  @Override
  public Map<? extends Dimension, Integer> getBaseDimensions() {
    return base;
  }

  @Override
  public Dimension multiply(Dimension dimension) {
    return new ProductDimension().multiply(this).multiply(dimension);
  }

  @Override
  public Dimension divide(Dimension dimension) {
    return new ProductDimension().multiply(this).divide(dimension);
  }

  @Override
  public Dimension pow(int n) {
    return new ProductDimension().multiply(this).pow(n);
  }

  @Override
  public Dimension root(int n) {
    throw new ArithmeticException("Unsupported operation");
  }
}
