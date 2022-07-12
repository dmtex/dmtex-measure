package com.github.dmtex.measure.misc;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.MetricPrefix;
import java.math.BigDecimal;
import javax.measure.quantity.Pressure;

import static com.github.dmtex.measure.misc.CgsUnits.CENTIMETER;
import static com.github.dmtex.measure.misc.CgsUnits.GRAM_PER_CUBIC_CENTIMETER;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.NamedUnits.PASCAL;
import static com.github.dmtex.measure.system.PhysicalConstants.STANDARD_GRAVITY;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code LegacyPressureUnits} class contains legacy pressure units including obsolete ones.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class LegacyPressureUnits {

  /**
   * The bar is a metric unit of pressure, but is not approved as part of the International System of Units (SI).
   * It is defined as exactly equal to 100,000 Pa (100 kPa), which is slightly less than
   * the current average atmospheric pressure on Earth at sea level (approximately 1.013 bar).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Bar_(unit)">Wikipedia: Bar (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> BAR = unit("bar", PASCAL, 100_000, Pressure.class);

  /**
   * Kiligram-forse per centimeter squared, aka technical atmosphere.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Atmosphere_(unit)">Wikipedia: Atmosphere (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> KGF_PER_CM2 = unit(LegacyUnits.KILOGRAM_FORCE.divide(CENTIMETER.pow(2)),
      Pressure.class);

  /**
   * Meters, water gauge, also known as a meter of water or meters water column and abbreviated to mwg,
   * mH2O or mwc, respectively, is a less commonly used unit of pressure.
   * It may be defined as the pressure exerted by a column of water of 1 m in height at 4&deg;C
   * (temperature of maximum density) at the standard acceleration of gravity, so that 1 mH2O (4&deg;C)
   * = 999.9720 kg/m<sup>3</sup> &times; 9.80665 m/s<sup>2</sup> &times; 1 m = 9806.3754138 Pa,
   * but conventionally a nominal maximum water density of 1000 kg/m<sup>3</sup> is used, giving 9806.65 Pa.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Millimeters,_water_gauge">Wikipedia: Millimeters, water gauge</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> METER_OF_WATER = unit(METER.multiply(GRAM_PER_CUBIC_CENTIMETER)
      .multiply(STANDARD_GRAVITY).alternate("meter^water"), Pressure.class);

  /**
   * Millimeters, water gauge, also known as a millimeter of water or millimeters water column
   * and abbreviated to mmwg, mmH2O or mmwc, respectively, is a less commonly used unit of pressure.
   * It may be defined as the pressure exerted by a column of water of 1 mm in height at 4&deg;C
   * (temperature of maximum density) at the standard acceleration of gravity, so that 1 mmH2O (4&deg;C)
   * = 999.9720 kg/m<sup>3</sup> &times; 9.80665 m/s<sup>2</sup> &times; 1 mm = 9.8063754138 Pa,
   * but conventionally a nominal maximum water density of 1000 kg/m<sup>3</sup> is used, giving 9.80665 Pa.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Millimeters,_water_gauge">Wikipedia: Millimeters, water gauge</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> MM_OF_WATER = MetricPrefix.milli(METER_OF_WATER);

  /**
   * The standard atmosphere (symbol: {@code atm}) is a unit of pressure defined as 101325 Pa (1.01325 bar).
   * It is sometimes used as a reference or standard pressure.
   * It is approximately equal to the atmospheric pressure at sea level.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Atmosphere_(unit)">Wikipedia: Atmosphere (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> ATMOSPHERE = unit("atmoshere", PASCAL, 101_325, Pressure.class);

  /**
   * Meter of mercury.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Millimetre_of_mercury">Wikipedia: Millimetre of mercury</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> METER_OF_HG = unit("meter^mercury", PASCAL,
      new BigDecimal("133322.387415"), Pressure.class);

  /**
   * A millimetre of mercury is a manometric unit of pressure,
   * formerly defined as the extra pressure generated by a column of mercury one millimetre high,
   * and currently defined as exactly 133.322387415 pascals. It is denoted mmHg or mm Hg.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Millimetre_of_mercury">Wikipedia: Millimetre of mercury</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> MM_OF_HG = MetricPrefix.milli(METER_OF_HG);

  private LegacyPressureUnits() {
  }
}
