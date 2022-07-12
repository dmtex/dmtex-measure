package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.system.MeterUnits;
import com.github.dmtex.measure.system.MetricUnits;
import com.github.dmtex.measure.system.NamedUnits;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Force;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.spi.SystemOfUnits;
import si.uom.quantity.Density;
import si.uom.quantity.DynamicViscosity;
import si.uom.quantity.KinematicViscosity;

import static com.github.dmtex.measure.system.NamedUnits.JOULE;
import static com.github.dmtex.measure.system.NamedUnits.NEWTON;
import static com.github.dmtex.measure.system.NamedUnits.PASCAL;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code CgsUnits} class contains units of CGS system of units.
 *
 * @author Denis Murashev
 *
 * @see <a href="https://en.wikipedia.org/wiki/Centimetre%E2%80%93gram%E2%80%93second_system_of_units">
 *     Centimetre-gram-second system of units</a>
 *
 * @since Measure 1.0
 */
public final class CgsUnits {

  /**
   * Centimeter.
   *
   * @see MeterUnits#CENTIMETER
   */
  @AddUnit
  public static final AbstractUnit<Length> CENTIMETER = MeterUnits.CENTIMETER;

  /**
   * Gram.
   *
   * @see NamedUnits#GRAM
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAM = NamedUnits.GRAM;

  /**
   * Second.
   *
   * @see MetricUnits#SECOND
   */
  @AddUnit
  public static final AbstractUnit<Time> SECOND = MetricUnits.SECOND;

  /**
   * A unit of velocity (cgs unit, standard name {@code cm/s}.
   */
  @AddUnit
  public static final AbstractUnit<Speed> CENTIMETER_PER_SECOND = unit(CENTIMETER.divide(SECOND), Speed.class);

  /**
   * The gal (symbol: {@code Gal}), sometimes called galileo after Galileo Galilei,
   * is a unit of acceleration used extensively in the science of gravimetry.
   * The gal is defined as 1 centimeter per second squared (1 {@code cm/s}<sup>2</sup>).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gal_(unit)">Wikipedia: Gal (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Acceleration> GAL = unit(CENTIMETER.divide(SECOND.pow(2)).alternate("gal"),
      Acceleration.class);

  /**
   * The dyne (symbol {@code dyn}, from Greek dynamis, meaning power, force) is a derived unit of force
   * specified in the centimeter-gram-second (CGS) system of units.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dyne">Wikipedia: Dyne</a>
   */
  @AddUnit
  public static final AbstractUnit<Force> DYNE = unit("dyne", NEWTON, new Rational(1, 100_000), Force.class);

  /**
   * The erg is a unit of energy equal to 10<sup>-7</sup> joules.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Erg">Wikipedia: Erg</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> ERG = unit("erg", JOULE, new Rational(10_000_000), Energy.class);

  /**
   * A unit of power (cgs unit, standard name {@code erg/s} ).
   */
  @AddUnit
  public static final AbstractUnit<Power> ERG_PER_SECOND = unit(ERG.divide(SECOND), Power.class);

  /**
   * The barye (symbol: {@code Ba}), or sometimes barad, barrie, bary, baryd, baryed, or barie,
   * is the centimeter-gram-second (CGS) unit of pressure. It is equal to 1 dyne per square centimeter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Barye">Wikipedia: Barye</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> BARYE = unit("barye", PASCAL, new Rational(1, 10), Pressure.class);

  /**
   * The poise (symbol {@code P}) is the unit of dynamic viscosity (absolute viscosity)
   * in the centimeter-gram-second system of units. It is named after Jean L&eacute;onard Marie Poiseuille.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Poise_(unit)">Wikipedia: Poise (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<DynamicViscosity> POISE = unit(GRAM.divide(CENTIMETER.multiply(SECOND))
      .alternate("poise"), DynamicViscosity.class);

  /**
   * The CGS unit for kinematic viscosity is the stokes ({@code St}), named after Sir George Gabriel Stokes.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Viscosity#Units">Wikipedia: Viscosity Units</a>
   */
  @AddUnit
  public static final AbstractUnit<KinematicViscosity> STOKES = unit(CENTIMETER.pow(2).divide(SECOND)
      .alternate("stokes"), KinematicViscosity.class);

  /**
   * In CGS reciprocal centimeters {@code cm}<sup>-1</sup>, the wavenumber was, formerly called the kayser,
   * after Heinrich Kayser.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Wavenumber">Wikipedia: Wavenumber</a>
   */
  @AddUnit
  public static final AbstractUnit<KinematicViscosity> KAYSER = unit(CENTIMETER.pow(-1).alternate("kayser"),
      KinematicViscosity.class);

  /**
   * Gram per cubic centimeter.
   */
  @AddUnit
  public static final AbstractUnit<Density> GRAM_PER_CUBIC_CENTIMETER = unit(GRAM.divide(CENTIMETER.pow(3)),
      Density.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("CGS")
      .add(CgsUnits.class)
      .add(CgsNamedUnits.class)
      .build();

  private CgsUnits() {
  }
}
