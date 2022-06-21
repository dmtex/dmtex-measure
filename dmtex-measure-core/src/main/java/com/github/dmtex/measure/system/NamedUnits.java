package com.github.dmtex.measure.system;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.quantity.Entropy;
import com.github.dmtex.measure.unit.AbstractUnit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Force;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Pressure;
import si.uom.quantity.Action;
import si.uom.quantity.Density;
import si.uom.quantity.DynamicViscosity;
import si.uom.quantity.Intensity;
import si.uom.quantity.KinematicViscosity;
import si.uom.quantity.Radiance;
import si.uom.quantity.RadiantIntensity;

import static com.github.dmtex.measure.system.MetricUnits.KELVIN;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code NamedUnits} class contains named SI units based on {@link MetricUnits#METER} ({@code L}),
 * {@link MetricUnits#KILOGRAM}  ({@code M}) and {@link MetricUnits#SECOND} ({@code T}).
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class NamedUnits {

  /**
   * The hertz (symbol: {@code Hz}) is the derived unit of frequency in the International System of Units (SI)
   * and is defined as cycles per one second.
   *
   * <p>It is named after Heinrich Rudolf Hertz,
   * the first person to provide conclusive proof of the existence of electromagnetic waves.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Hertz">Wikipedia: Hertz</a>
   */
  @AddUnit
  public static final AbstractUnit<Frequency> HERTZ = unit(SECOND.inverse().alternate("hertz"), Frequency.class);

  /**
   * The newton (symbol: {@code N}) is the International System of Units (SI) derived unit of force.
   * It is named after Isaac Newton in recognition of his work on classical mechanics,
   * specifically Newton's second law of motion.
   *
   * <p>One newton is the force needed to accelerate one kilogram of mass at the rate of one meter per second squared
   * in the direction of the applied force.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Newton_(unit)">Wikipedia: Newton (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Force> NEWTON = unit(METER.multiply(KILOGRAM).divide(SECOND.pow(2))
      .alternate("newton"), Force.class);

  /**
   * The pascal (symbol: {@code Pa}) is the SI derived unit of pressure used to quantify internal pressure, stress,
   * Young's modulus and ultimate tensile strength.
   * The unit, named after Blaise Pascal, is defined as one newton per square metre.
   *
   * <p>One pascal is the pressure exerted by a force of magnitude one newton perpendicularly
   * upon an area of one square meter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pascal_(unit)">Wikipedia: Pascal (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Pressure> PASCAL = unit(NEWTON.divide(METER.pow(2)).alternate("pascal"),
      Pressure.class);

  /**
   * The joule (symbol: {@code J}) is a derived unit of energy in the International System of Units.
   * It is equal to the energy transferred to (or work done on) an object
   * when a force of one newton acts on that object in the direction of the force's motion
   * through a distance of one meter (1 newton meter or N&bull;m).
   * It is also the energy dissipated as heat when an electric current of one ampere passes
   * through a resistance of one ohm for one second.
   *
   * <p>It is named after the English physicist James Prescott Joule (1818-1889).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Joule">Wikipedia: Joule</a>
   */
  @AddUnit
  public static final AbstractUnit<Energy> JOULE = unit(NEWTON.multiply(METER).alternate("joule"), Energy.class);

  /**
   * The watt (symbol: {@code W}) is a unit of power.
   * In the International System of Units (SI) it is defined as a derived unit of 1 joule per second,
   * and is used to quantify the rate of energy transfer
   *
   * <p>It is named after the British scientist James Watt (1736-1819).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Watt">Wikipedia: Watt</a>
   */
  @AddUnit
  public static final AbstractUnit<Power> WATT = unit(JOULE.divide(SECOND).alternate("watt"), Power.class);

  /**
   * The SI unit for density quantities (standard name kg/m&sup3;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Kilogram_per_cubic_metre">Wikipedia: Kilogram per cubic metre</a>
   */
  @AddUnit
  public static final AbstractUnit<Density> KILOGRAM_PER_CUBIC_METER = unit(KILOGRAM.divide(MeterUnits.CUBIC_METER),
      Density.class);

  /**
   * The viscosity of a fluid is a measure of its resistance to deformation at a given rate.
   * For liquids, it corresponds to the informal concept of "thickness":
   * for example, syrup has a higher viscosity than water.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Viscosity#Dynamic_viscosity">Wikipedia: Viscosity</a>
   */
  @AddUnit
  public static final AbstractUnit<DynamicViscosity> PASCAL_SECOND = unit(PASCAL.multiply(SECOND),
      DynamicViscosity.class);

  /**
   * The SI unit for kinematic viscosity quantities (standard name {@code m}<sup>2</sup>{@code s}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Viscosity">Wikipedia: Viscosity</a>
   */
  @AddUnit
  public static final AbstractUnit<KinematicViscosity> SQUARE_METRE_PER_SECOND = unit(METER.pow(2).divide(SECOND),
      KinematicViscosity.class);

  /**
   * The SI unit for intensity (standard name {@code W/m}<sup>2</sup>).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Angular_acceleration">Wikipedia: Angular acceleration</a>
   */
  @AddUnit
  public static final AbstractUnit<Intensity> WATT_PER_SQUARE_METRE = unit(WATT.divide(METER.pow(2)),
      Intensity.class);

  /**
   * The SI unit for radiant intensity (standard name {@code W/sr}).
   */
  @AddUnit
  public static final AbstractUnit<RadiantIntensity> WATT_PER_STERADIAN = unit(WATT.divide(RadianUnits.STERADIAN),
      RadiantIntensity.class);

  /**
   * The SI unit for radiance (standard name {@code W/sr/m}<sup>2</sup>).
   */
  @AddUnit
  public static final AbstractUnit<Radiance> WATT_PER_STERADIAN_PER_SQUARE_METRE
      = unit(WATT.divide(RadianUnits.STERADIAN).divide(METER.pow(2)), Radiance.class);

  /**
   * The SI derived unit for mass quantities (standard name {@code g}).
   * The base unit for mass quantity is {@link MetricUnits#KILOGRAM}.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gram">Wikipedia: Gram</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAM = unit("gram", KILOGRAM, new Rational(1, 1000), Mass.class);

  /**
   * The joule-second ({@code J s}, or {@code J}&bull;{@code s}) is the mathematical product of an SI Derived Unit,
   * the joule ({@code J}), and an SI Base Unit, the second ({@code s}).
   * The joule-second describes the amount of action occurring in a physical system
   * through a summation of energy (or heat, or work) over time.
   * In mathematical terms, this summation of energy means that the quantity of energy becomes integrated over time.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Joule-second">Wikipedia: Joule-second</a>
   */
  @AddUnit
  public static final AbstractUnit<Action> JOULE_SECOND = unit(JOULE.multiply(SECOND), Action.class);

  /**
   * Entropy is a property of thermodynamical systems.
   * The term entropy was introduced by Rudolf Clausius who named it from the Greek word &tau;&rho;&omicron;&pi;&eta;,
   * "transformation".
   * He considered transfers of energy as heat and work between bodies of matter, taking temperature into account.
   * Bodies of radiation are also covered by the same kind of reasoning.
   *
   * @see <a href="http://en.wikipedia.org/wiki/Entropy_(classical_thermodynamics)">Wikipedia: Entropy
   * (classical thermodynamics)</a>
   */
  @AddUnit
  public static final AbstractUnit<Entropy> JOULE_PER_KELVIN = unit(JOULE.divide(KELVIN), Entropy.class);

  private NamedUnits() {
  }
}
