package com.github.dmtex.measure.dimension;

import javax.measure.Dimension;

/**
 * {@code Dimensions} class collects dimensions.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class Dimensions {

  /**
   * Dimensionless.
   */
  public static final Dimension DIMENSIONLESS = new ProductDimension();

  /**
   * Length.
   */
  public static final Dimension LENGTH = BaseDimension.LENGTH;

  /**
   * Mass.
   */
  public static final Dimension MASS = BaseDimension.MASS;

  /**
   * Time.
   */
  public static final Dimension TIME = BaseDimension.TIME;

  /**
   * Electric current (I).
   */
  public static final Dimension ELECTRIC_CURRENT = BaseDimension.ELECTRIC_CURRENT;

  /**
   * Temperature dimension (&Theta;).
   */
  public static final Dimension TEMPERATURE = BaseDimension.TEMPERATURE;

  /**
   * Amount of substance (N).
   */
  public static final Dimension AMOUNT_OF_SUBSTANCE = BaseDimension.AMOUNT_OF_SUBSTANCE;

  /**
   * Luminous intensity (J).
   */
  public static final Dimension LUMINOUS_INTENSITY = BaseDimension.LUMINOUS_INTENSITY;

  private Dimensions() {
  }
}
