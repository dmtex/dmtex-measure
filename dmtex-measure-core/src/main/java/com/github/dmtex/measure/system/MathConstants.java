package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.dimension.Dimensions;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Dimensionless;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code MathConstants} class contains natural physical unit constants.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class MathConstants {

  /**
   * Just simple dimensionless unit.
   */
  @AddUnit
  public static final AbstractUnit<Dimensionless> UNIT = unit("unit", Dimensions.DIMENSIONLESS, Dimensionless.class);

  /**
   * The number &pi; is a mathematical constant.
   * Originally defined as the ratio of a circle's circumference to its diameter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pi">Wikipedia: Pi</a>
   */
  @AddUnit
  public static final AbstractUnit<Dimensionless> PI = unit("pi", UNIT, Math.PI, Dimensionless.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Math Constants")
      .add(MathConstants.class)
      .build();

  private MathConstants() {
  }
}
