package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.dimension.Dimensions;
import com.github.dmtex.measure.unit.AbstractUnit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.SolidAngle;
import si.uom.quantity.AngularAcceleration;
import si.uom.quantity.AngularSpeed;

import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code RadianUnits} class contains units based on {@link Angle}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class RadianUnits {

  /**
   * The radian is the SI unit for measuring angles, and is the standard unit of angular measure
   * used in many areas of mathematics.
   * The length of an arc of a unit circle is numerically equal to the measurement in radians of the angle
   * that it subtends.
   *
   * <p>The symbol {@code rad} can be used to represent the radian,
   * but this is often omitted, especially in mathematical writing.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Radian">Wikipedia: Radian</a>
   */
  @AddUnit
  public static final AbstractUnit<Angle> RADIAN = unit("radian", Dimensions.DIMENSIONLESS, Angle.class);

  /**
   * The steradian (symbol: {@code sr}) or square radian is the SI unit of solid angle.
   * It is used in three-dimensional geometry, and is analogous to the radian, which quantifies planar angles.
   *
   * <p>A steradian can be defined as the solid angle subtended at the center of a unit sphere
   * by a unit area on its surface.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Steradian">Wikipedia: Steradian</a>
   */
  @AddUnit
  public static final AbstractUnit<SolidAngle> STERADIAN = unit("steradian", Dimensions.DIMENSIONLESS,
      SolidAngle.class);

  /**
   * The radian per second (symbol: {@code rad}&times;{@code s}<sup>-1</sup> or {@code rad/s}) is the SI unit
   * of rotational speed (angular velocity), commonly denoted by the Greek letter &omega; (omega).
   * The radian per second is also the unit of angular frequency.
   * The radian per second is defined as the change in the orientation of an object, in radians, every second.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Radian_per_second">Wikipedia: Radian per second</a>
   */
  @AddUnit
  public static final AbstractUnit<AngularSpeed> RADIAN_PER_SECOND = unit(RADIAN.divide(SECOND), AngularSpeed.class);

  /**
   * Angular acceleration is the time rate of change of angular velocity. In three dimensions, it is a pseudovector.
   * In SI units, it is measured in radians per second squared ({@code rad/s}<sup>2</sup>),
   * and is usually denoted by the Greek letter alpha (&alpha;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Angular_acceleration">Wikipedia: Angular acceleration</a>
   */
  @AddUnit
  public static final AbstractUnit<AngularAcceleration> RADIAN_PER_SQUARE_SECOND = unit(RADIAN.divide(SECOND.pow(2)),
      AngularAcceleration.class);

  private RadianUnits() {
  }
}
