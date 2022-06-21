package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import javax.measure.quantity.ElectricCapacitance;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.ElectricConductance;
import javax.measure.quantity.ElectricInductance;
import javax.measure.quantity.ElectricPotential;
import javax.measure.quantity.ElectricResistance;
import javax.measure.quantity.MagneticFlux;
import javax.measure.quantity.MagneticFluxDensity;
import si.uom.quantity.ElectricPermittivity;
import si.uom.quantity.IonizingRadiation;
import si.uom.quantity.MagneticFieldStrength;
import si.uom.quantity.MagneticPermeability;
import si.uom.quantity.MagnetomotiveForce;

import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code AmpereUnits} class contains named units derived from SI base units,
 * based on {@link MetricUnits#AMPERE} ({@code I}).
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class AmpereUnits {

  /**
   * The coulomb (symbol: {@code C}) is the International System of Units (SI) unit of electric charge.
   * It is the charge (symbol: Q or q) transported by a constant current of one ampere in one second.
   *
   * <p>It is named after the French physicist Charles Augustin de Coulomb (1736-1806).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Coulomb">Wikipedia: Coulomb</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricCharge> COULOMB
      = unit(MetricUnits.AMPERE.multiply(MetricUnits.SECOND).alternate("coulomb"), ElectricCharge.class);

  /**
   * The volt (symbol: {@code V}) is the derived unit for electric potential,
   * electric potential difference (voltage), and electromotive force.
   *
   * <p>One volt is defined as the difference in electric potential between two points of a conducting wire
   * when an electric current of one ampere dissipates one watt of power between those points.
   *
   * <p>It is named after the Italian physicist Alessandro Volta (1745-1827).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Volt">Wikipedia: Volt</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricPotential> VOLT
      = unit(NamedUnits.WATT.divide(MetricUnits.AMPERE).alternate("volt"), ElectricPotential.class);

  /**
   * The farad (symbol: {@code F}) is the SI derived unit of electrical capacitance,
   * the ability of a body to store an electrical charge.
   *
   * <p>One farad is defined as the capacitance across which, when charged with one coulomb,
   * there is a potential difference of one volt.
   * Equally, one farad can be described as the capacitance which stores a one-coulomb charge
   * across a potential difference of one volt.
   *
   * <p>It is named after the English physicist Michael Faraday.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Farad">Wikipedia: Farad</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricCapacitance> FARAD = unit(COULOMB.divide(VOLT).alternate("farad"),
      ElectricCapacitance.class);

  /**
   * The ohm (symbol: &Omega;) is the SI derived unit of electrical resistance.
   *
   * <p>The ohm is defined as an electrical resistance between two points of a conductor
   * when a constant potential difference of one volt, applied to these points,
   * produces in the conductor a current of one ampere, the conductor not being the seat of any electromotive force.
   *
   * <p>It is named after German physicist Georg Simon Ohm.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Ohm">Wikipedia: Ohm</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricResistance> OHM = unit(VOLT.divide(MetricUnits.AMPERE).alternate("ohm"),
      ElectricResistance.class);

  /**
   * The siemens (symbol: {@code S}) is the derived unit of electric conductance, electric susceptance,
   * and electric admittance in the International System of Units (SI).
   * Conductance, susceptance, and admittance are the reciprocals of resistance, reactance,
   * and impedance respectively; hence one siemens is redundantly equal to the reciprocal of one ohm,
   * and is also referred to as the mho. The 14th General Conference on Weights and Measures approved the addition
   * of the siemens as a derived unit in 1971.
   *
   * <p>The unit is named after Ernst Werner von Siemens.
   * In English, the same form siemens is used both for the singular and plural.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Siemens_(unit)">Wikipedia: Siemens (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricConductance> SIEMENS
      = unit(MetricUnits.AMPERE.divide(VOLT).alternate("siemens"), ElectricConductance.class);

  /**
   * The weber (symbol: {@code Wb}) is the SI derived unit of magnetic flux.
   * A flux density of one Wb/m2 (one weber per square metre) is one tesla.
   *
   * <p>The weber is named after the German physicist Wilhelm Eduard Weber (1804-1891).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Weber_(unit)">Wikipedia: Weber (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFlux> WEBER = unit(VOLT.multiply(MetricUnits.SECOND).alternate("weber"),
      MagneticFlux.class);

  /**
   * The tesla (symbol: {@code T}) is a derived unit of the magnetic induction (also, magnetic flux density)
   * in the International System of Units.
   *
   * <p>One tesla is equal to one weber per square meter.
   * The unit was announced during the General Conference on Weights and Measures in 1960
   * and is named in honour of Nikola Tesla.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Tesla_(unit)">Wikipedia: Tesla (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFluxDensity> TESLA
      = unit(WEBER.divide(MetricUnits.METER.pow(2)).alternate("tesla"), MagneticFluxDensity.class);

  /**
   * The henry (symbol: {@code H}) is the SI derived unit of electrical inductance.
   * If a current of 1 ampere flowing through the coil produces flux linkage of 1 weber turn,
   * the coil has a self inductance of 1 henry.
   *
   * <p>The unit is named after Joseph Henry (1797-1878),
   * the American scientist who discovered electromagnetic induction independently of
   * and at about the same time as Michael Faraday (1791-1867) in England.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Henry_(unit)">Wikipedia: Henry (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricInductance> HENRY = unit(WEBER.divide(MetricUnits.AMPERE).alternate("henry"),
      ElectricInductance.class);

  /**
   * The SI unit for magnetic field strength quantities (standard name {@code A/m}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Magnetic_field">Wikipedia: Magnetic field</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFieldStrength> AMPERE_PER_METER
      = unit(MetricUnits.AMPERE.divide(MetricUnits.METER), MagneticFieldStrength.class);

  /**
   * The SI unit for electric permittivity (standard name &epsilon;, {@code F/m}
   * or {@code F}&bull;{@code m}<sup>-1</sup>).
   * In electromagnetism, absolute permittivity is the measure of resistance that is encountered
   * when forming an electric field in a medium.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Permittivity">Wikipedia: Permittivity</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricPermittivity> FARAD_PER_METRE = unit(FARAD.divide(MetricUnits.METER),
      ElectricPermittivity.class);

  /**
   * The SI unit for magnetic permeability quantities (standard name {@code N/A}<sup>2</sup>).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Permeability_(electromagnetism)">Wikipedia: Permeability</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticPermeability> NEWTON_PER_SQUARE_AMPERE
      = unit(NamedUnits.NEWTON.divide(MetricUnits.AMPERE.pow(2)), MagneticPermeability.class);

  /**
   * The SI unit for ionizing radiation quantities (standard name {@code C/kg}).
   */
  @AddUnit
  public static final AbstractUnit<IonizingRadiation> COULOMB_PER_KILOGRAM = unit(COULOMB.divide(MetricUnits.KILOGRAM),
      IonizingRadiation.class);

  /**
   * The ampere-turn ({@code At}) is the MKS (Metres, Kilograms, Seconds) unit of magnetomotive force (MMF),
   * represented by a direct current of one ampere flowing in a single-turn loop in a vacuum.
   * "Turns" refers to the winding number of an electrical conductor composing an inductor.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Ampere-turn">Wikipedia: Ampere-turn</a>
   */
  @AddUnit
  public static final AbstractUnit<MagnetomotiveForce> AMPERE_TURN = unit(MetricUnits.AMPERE.alternate("ampere_turn"),
      MagnetomotiveForce.class);

  private AmpereUnits() {
  }
}
