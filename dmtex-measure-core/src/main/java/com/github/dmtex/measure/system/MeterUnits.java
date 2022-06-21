package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.MetricPrefix;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Volume;
import si.uom.quantity.WaveNumber;

import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code MeterUnits} class contains SI units based on {@link MetricUnits#METER}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class MeterUnits {

  /**
   * The SI unit for area quantities (standard name m&sup2;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Square_metre">Wikipedia: Square metre</a>
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_METER = unit(METER.pow(2), Area.class);

  /**
   * The SI unit for volume quantities (standard name m&sup3;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Cubic_metre">Wikipedia: Cubic metre</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUBIC_METER = unit(METER.pow(3), Volume.class);

  /**
   * The SI unit for speed quantities (standard name {@code m/s}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Metre_per_second">Wikipedia: Metre per second</a>
   */
  @AddUnit
  public static final AbstractUnit<Speed> METER_PER_SECOND = unit(METER.divide(SECOND), Speed.class);

  /**
   * The SI unit for acceleration quantities (standard name m/s&sup2;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Metre_per_second_squared">Wikipedia: Metre per second squared</a>
   */
  @AddUnit
  public static final AbstractUnit<Acceleration> METER_PER_SECOND_SQUARED = unit(METER.divide(SECOND.pow(2)),
      Acceleration.class);

  /**
   * Reciprocal length or inverse length is a measurement used in several branches of science and mathematics.
   * As the reciprocal of length, common units used for this measurement include the reciprocal meter or inverse meter
   * (symbol: {@code m}<sup>-1</sup>).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Reciprocal_length">Wikipedia: Reciprocal length</a>
   */
  @AddUnit
  public static final AbstractUnit<WaveNumber> RECIPROCAL_METER = unit(METER.pow(-1), WaveNumber.class);

  /**
   * A unit of length expressing the number of kilometers (abbreviation {@code km}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilometre">Wikipedia: Kilometre</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> KILOMETER = unit(MetricPrefix.kilo(METER), Length.class);

  /**
   * A unit of speed expressing the number of international {@link #KILOMETER kilometres}
   * per {@link TimeUnits#HOUR hour} (abbreviation {@code km/h}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilometres_per_hour">Wikipedia: Kilometres per hour</a>
   */
  @AddUnit
  public static final AbstractUnit<Speed> KILOMETER_PER_HOUR = unit(KILOMETER.divide(TimeUnits.HOUR), Speed.class);

  /**
   * A unit of length expressing the number of centimeters (abbreviation {@code cm}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Centimetre">Wikipedia: Centimetre</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> CENTIMETER = unit(MetricPrefix.centi(METER), Length.class);

  /**
   * A unit of length expressing the number of millimeters (abbreviation {@code mm}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Millimetre">Wikipedia: Millimetre</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> MILLIMETER = unit(MetricPrefix.milli(METER), Length.class);

  private MeterUnits() {
  }
}
