package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.quantity.OpticalPower;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.MetricPrefix;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import java.math.BigDecimal;
import javax.measure.quantity.Area;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Force;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Speed;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.misc.CgsUnits.GRAM;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.NamedUnits.JOULE;
import static com.github.dmtex.measure.system.NamedUnits.WATT;
import static com.github.dmtex.measure.system.NonSiUnits.ASTRONOMICAL_UNIT;
import static com.github.dmtex.measure.system.NonSiUnits.TONNE;
import static com.github.dmtex.measure.system.PhysicalConstants.SPEED_OF_LIGHT;
import static com.github.dmtex.measure.system.PhysicalConstants.STANDARD_GRAVITY;
import static com.github.dmtex.measure.system.TimeUnits.HOUR;
import static com.github.dmtex.measure.system.TimeUnits.JULIAN_YEAR;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code LegacyUnits} class contains legacy non-SI units including obsolete ones.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class LegacyUnits {

  /**
   * The angstrom or &aring;ngstr&ouml;m is a unit of length equal to 10<sup>-10</sup> m; that is,
   * one ten-billionth of a meter, 0.1 nanometer, or 100 picometers.
   * Its symbol is &Aring;, a letter of the Swedish alphabet.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Angstrom">Wikipedia: Angstrom</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> ANGSTROM = unit("angstrom", METER, new BigDecimal("1E-10"), Length.class);

  /**
   * A nautical mile is a unit of measurement used in both air and marine navigation,
   * and for the definition of territorial waters. Historically, it was defined as one minute
   * (<sup>1</sup>/<sub>60</sub> of a degree) of latitude along any line of longitude.
   * Today the international nautical mile is defined as exactly 1852 metres.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Nautical_mile">Wikipedia: Nautical mile</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> NAUTICAL_MILE = unit("mile^nautical", METER, 1852, Length.class);

  /**
   * The light-year is a unit of length used to express astronomical distances
   * and measures about 9.46 trillion kilometres (9.46&times;10<sup>12</sup> km)
   * or 5.88 trillion miles (5.88&times;10<sup>12</sup> mi).
   * As defined by the International Astronomical Union (IAU), a light-year is the distance
   * that light travels in vacuum in one Julian year (365.25 days).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Light-year">Wikipedia: Light-year</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> LIGHT_YEAR = unit(SPEED_OF_LIGHT.multiply(JULIAN_YEAR)
      .alternate("year^light"), Length.class);

  /**
   * The parsec (symbol: {@code pc}) is a unit of length used to measure the large distances to astronomical objects
   * outside the Solar System.
   * A parsec is obtained by the use of parallax and trigonometry,
   * and is defined as the distance at which one astronomical unit subtends an angle of one arcsecond,
   * ie. 1/3600th of a degree.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Parsec">Wikipedia: Parsec</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> PARSEC = unit("parsec", ASTRONOMICAL_UNIT, 648_000 / Math.PI,
      Length.class);

  /**
   * A barn (symbol: {@code b}) is a unit of area equal to 10<sup>-28</sup> m<sup>2</sup> (or 100 fm<sup>2</sup>).
   * Originally used in nuclear physics for expressing the cross sectional area of nuclei and nuclear reactions,
   * today it is also used in all fields of high-energy physics to express the cross sections
   * of any scattering process,
   * and is best understood as a measure of the probability of interaction between small particles.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Barn_(unit)">Wikipedia: Barn (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Area> BARN = unit("barn", SQUARE_METER, new BigDecimal("1E-28"), Area.class);

  /**
   * A unit of area equal to {@code 100 m}<sup>2</sup> (abbreviation {@code a}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Hectare#Are">Wikipedia: Are</a>
   */
  @AddUnit
  public static final AbstractUnit<Area> ARE = unit("are", SQUARE_METER, 100, Area.class);

  /**
   * The knot is a unit of speed equal to one nautical mile per hour, exactly 1.852 km/h
   * (approximately 1.15078 mph or 0.514 m/s).
   *
   * <p>The ISO standard symbol for the knot is {@code kn}.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Knot_(unit)">Wikipedia: Knot (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Speed> KNOT = unit(NAUTICAL_MILE.divide(HOUR).alternate("knot"), Speed.class);

  /**
   * The carat ({@code ct}) , is a unit of mass equal to 200 mg (0.00705 oz) or 0.00643 troy oz,
   * and is used for measuring gemstones and pearls.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Carat_(mass)">Wikipedia: Carat (mass)</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> CARAT = unit("carat", GRAM, Rational.ONE_FIFTH, Mass.class);

  /**
   * The quintal or centner is a historical unit of mass which is usually defined as 100 base units of kilograms.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Quintal">Wikipedia: Quintal</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> CENTNER = unit("centner", KILOGRAM, 100, Mass.class);

  /**
   * The gram-force ({@code gf}) is a gravitational metric unit of force.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilogram-force">Wikipedia: Kilogram-force</a>
   */
  @AddUnit
  public static final AbstractUnit<Force> GRAM_FORCE = unit(GRAM.multiply(STANDARD_GRAVITY).alternate("gram^force"),
      Force.class);

  /**
   * The kilogram-force ({@code kgf}), or kilopond (kp, from Latin pondus meaning weight),
   * is a gravitational metric unit of force.
   * It is equal to the magnitude of the force exerted on one kilogram of mass in a 9.80665 m/s2 gravitational field
   * (standard gravity, a conventional value approximating the average magnitude of gravity on Earth).
   * Therefore, one kilogram-force is by definition equal to 9.80665 N.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilogram-force">Wikipedia: Kilogram-force</a>
   */
  @AddUnit
  public static final AbstractUnit<Force> KILOGRAM_FORCE = unit(KILOGRAM.multiply(STANDARD_GRAVITY)
      .alternate("kilogram^force"), Force.class);

  /**
   * The tonne-force ({@code tf}) is a gravitational metric unit of force.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Ton-force#Tonne-force">Wikipedia: Tonne-force</a>
   */
  @AddUnit
  public static final AbstractUnit<Force> TONNE_FORCE = unit(TONNE.multiply(STANDARD_GRAVITY)
      .alternate("tonne^force"), Force.class);

  /**
   * The kilowatt hour (symbol: kW&bull;h or kW h) is a unit of energy equal to 3.6 megajoules.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilowatt_hour">Wikipedia: Kilowatt hour</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> KILOWATT_HOUR = unit(MetricPrefix.kilo(WATT).multiply(HOUR), Energy.class);

  /**
   * International calorie.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Calorie">Wikipedia: Calorie</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> CALORIE = unit("calorie", JOULE, new BigDecimal("4.1868"), Energy.class);

  /**
   * Thermochemical calorie.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Calorie">Wikipedia: Calorie</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> CALORIE_THERMOCHEMICAL = unit("calorie^thermochemical", JOULE,
      new BigDecimal("4.1840"), Energy.class);

  /**
   * 15&deg;C calorie.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Calorie">Wikipedia: Calorie</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> CALORIE_15 = unit("calorie^degree15", JOULE, new BigDecimal("4.1855"),
      Energy.class);

  /**
   * Horsepower ({@code hp}) is a unit of measurement of power, or the rate at which work is done.
   * There are many different standards and types of horsepower.
   * Two common definitions being used today are the mechanical horsepower (or imperial horsepower),
   * which is about 745.7 watts, and the metric horsepower, which is approximately 735.5 watts.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Horsepower">Wikipedia: Horsepower</a>
   */
  @AddUnit
  public static final AbstractUnit<Power> HORSEPOWER = unit("power^horse", WATT, new BigDecimal("735.49875"),
      Power.class);

  /**
   * A diopter is a unit of measurement of the optical power of a lens or curved mirror,
   * which is equal to the reciprocal of the focal length measured in metres. (1 dioptre = 1 m<sup>-1</sup>)
   * It is thus a unit of reciprocal length.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dioptre">Wikipedia: Dioptre</a>
   */
  @AddUnit
  public static final AbstractUnit<OpticalPower> DIOPTER = unit(METER.pow(-1).alternate("diopter"),
      OpticalPower.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Legacy")
      .add(LegacyUnits.class)
      .add(LegacyAngleUnits.class)
      .add(LegacyPressureUnits.class)
      .add(RadiationUnits.class)
      .build();

  private LegacyUnits() {
  }
}
