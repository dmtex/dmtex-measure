package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.quantity.Entropy;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import java.math.BigDecimal;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.Speed;
import javax.measure.spi.SystemOfUnits;
import si.uom.quantity.Action;

import static com.github.dmtex.measure.system.AmpereUnits.COULOMB;
import static com.github.dmtex.measure.system.MathConstants.UNIT;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND_SQUARED;
import static com.github.dmtex.measure.system.NamedUnits.JOULE_PER_KELVIN;
import static com.github.dmtex.measure.system.NamedUnits.JOULE_SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code PhysicalConstants} class contains natural physical unit constants.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class PhysicalConstants {

  /**
   * The speed of light in vacuum, commonly denoted {@code c}, is a universal physical constant important
   * in many areas of physics. Its exact value is 299792458 meters per second (approximately 300000 {@code km/s}
   * (186000 {@code mi/s})).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Speed_of_light">Wikipedia: Speed of light</a>
   */
  @AddUnit
  public static final AbstractUnit<Speed> SPEED_OF_LIGHT = METER_PER_SECOND.multiply(new BigDecimal("299792458"))
      .alternate("speed_of_light");

  /**
   * Standard gravity at earth surface.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gravitational_acceleration">Wikipedia: Gravitational acceleration</a>
   */
  @AddUnit
  public static final AbstractUnit<Acceleration> STANDARD_GRAVITY = METER_PER_SECOND_SQUARED
      .multiply(new BigDecimal("9.80665")).alternate("gravity");

  /**
   * The Avogadro number, sometimes denoted N, or N<sub>0</sub>, or N<sub>A</sub>,
   * is the number of constituent particles (usually molecules, atoms or ions)
   * that are contained in one {@link MetricUnits#MOLE},
   * the international (SI) unit of amount of substance: by definition, exactly 6.02214076&times;10<sup>23</sup>,
   * and it is dimensionless. It is named after the scientist Amedeo Avogadro (1776-1856).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Avogadro_constant">Wikipedia: Avogadro constant</a>
   */
  @AddUnit
  public static final AbstractUnit<Dimensionless> AVOGADRO_CONSTANT = unit("avogadro", UNIT,
      new BigDecimal("6.02214076E23"), Dimensionless.class);

  /**
   * The Boltzmann constant (k<sub>B</sub> or k), named after its discoverer, Ludwig Boltzmann,
   * is a physical constant that relates the average relative kinetic energy of particles in a gas
   * with the temperature of the gas.
   * It occurs in the definitions of the kelvin and the gas constant,
   * and in Planck's law of black-body radiation and Boltzmann's entropy formula.
   * The Boltzmann constant has the dimension energy divided by temperature, the same as entropy.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Boltzmann_constant">Wikipedia: Boltzmann constant</a>
   */
  @AddUnit
  public static final AbstractUnit<Entropy> BOLTZMANN_CONSTANT = JOULE_PER_KELVIN
      .multiply(new BigDecimal("1.380649E-23")).alternate("boltzmann");

  /**
   * The elementary charge, usually denoted by e or sometimes q<sub>e</sub>,
   * is the electric charge carried by a single proton or, equivalently,
   * the magnitude of the electric charge carried by a single electron, which has charge -1 e.
   * This elementary charge is a fundamental physical constant.
   * To avoid confusion over its sign, e is sometimes called the elementary positive charge.
   *
   * <p>From the 2019 redefinition of SI base units, that took effect on 20 May 2019,
   * its value is exactly 1.602176634&times;10<sup>-19</sup>C by definition of the coulomb.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Elementary_charge">Wikipedia: Elementary charge</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricCharge> ELEMENTARY_CHARGE = COULOMB
      .multiply(new BigDecimal("1.602176634E-19")).alternate("electron");

  /**
   * The Planck constant, or Planck's constant, denoted h, is a physical constant
   * that is the quantum of electromagnetic action, which relates the energy carried by a photon to its frequency.
   * A photon's energy is equal to its frequency multiplied by the Planck constant.
   * The Planck constant is of fundamental importance in quantum mechanics, and in metrology
   * it is the basis for the definition of the kilogram.
   *
   * <p>The Planck constant is defined to have the exact value h = 6.62607015&times;10<sup>-34</sup> J&bull;s.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Planck_constant">Wikipedia: Planck constant</a>
   */
  @AddUnit
  public static final AbstractUnit<Action> PLANCK_CONSTANT = JOULE_SECOND.multiply(new BigDecimal("6.62607015E-34"))
      .alternate("planck");

  /**
   * The Faraday constant, denoted by the symbol F, is named after Michael Faraday.
   * In physics and chemistry, this constant represents the magnitude of electric charge per mole of electrons.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Faraday_constant">Wikipedia: Faraday constant</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricCharge> FARADAY = unit(ELEMENTARY_CHARGE.multiply(AVOGADRO_CONSTANT)
      .alternate("faraday"), ElectricCharge.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Natural Constants")
      .add(PhysicalConstants.class)
      .build();

  private PhysicalConstants() {
  }
}
