package com.github.dmtex.measure.misc;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import java.math.BigDecimal;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.Illuminance;
import javax.measure.quantity.MagneticFlux;
import javax.measure.quantity.MagneticFluxDensity;
import si.uom.quantity.Luminance;
import si.uom.quantity.MagneticFieldStrength;
import si.uom.quantity.MagnetomotiveForce;

import static com.github.dmtex.measure.system.AmpereUnits.AMPERE_PER_METER;
import static com.github.dmtex.measure.system.AmpereUnits.AMPERE_TURN;
import static com.github.dmtex.measure.system.AmpereUnits.COULOMB;
import static com.github.dmtex.measure.system.AmpereUnits.TESLA;
import static com.github.dmtex.measure.system.AmpereUnits.WEBER;
import static com.github.dmtex.measure.system.MetricUnits.CANDELA;
import static com.github.dmtex.measure.system.MiscUnits.LUX;
import static com.github.dmtex.measure.system.PhysicalConstants.SPEED_OF_LIGHT;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code CgsNamedUnits} class contains legacy non-SI units including obsolete ones with special names.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class CgsNamedUnits {

  /**
   * The statcoulomb ({@code statC}) or franklin ({@code Fr}) or electrostatic unit of charge ({@code esu})
   * is the physical unit for electrical charge used in the esu-cgs (centimetre-gram-second system of units)
   * and Gaussian units.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Statcoulomb">Wikipedia: Statcoulomb</a>
   */
  @AddUnit
  public static final AbstractUnit<ElectricCharge> FRANKLIN = unit(COULOMB.divide(SPEED_OF_LIGHT)
      .divide(BigDecimal.TEN).alternate("franklin"), ElectricCharge.class);

  /**
   * The gilbert (Symbol: {@code Gb}) is an obsolete unit used in practical cgs and emu cgs systems
   * to measure magnetization.
   * The unit is named for English physicist William Gilbert.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gilbert_(unit)">Wikipedia: Gilbert (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<MagnetomotiveForce> GILBERT = unit("gilbert", AMPERE_TURN, 10.0 / 4 / Math.PI,
      MagnetomotiveForce.class);

  /**
   * The stilb ({@code sb}) is the CGS unit of luminance for objects that are not self-luminous.
   * It is equal to one candela per square centimeter or 10<sup>4</sup> nits (candelas per square meter).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Stilb_(unit)">Wikipedia: Stilb (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Luminance> STILB
      = unit(CANDELA.divide(CgsUnits.CENTIMETER).pow(2).alternate("stilb"), Luminance.class);

  /**
   * The lambert (symbol {@code L}) is a non-SI unit of luminance named for Johann Heinrich Lambert (1728-1777),
   * a Swiss mathematician, physicist and astronomer.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Lambert_(unit)">Wikipedia: Lambert (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Luminance> LAMBERT = unit("lambert", STILB, 1 / Math.PI, Luminance.class);

  /**
   * A phot ({@code ph}) is a photometric unit of illuminance, or luminous flux through an area.
   * It is not an SI unit, but rather is associated with the older centimetre-gram-second system of units.
   * The name was coined by Andr&eacute; Blondel in 1921.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Phot">Wikipedia: Phot</a>
   */
  @AddUnit
  public static final AbstractUnit<Illuminance> PHOT = unit("phot", LUX, 10_000, Illuminance.class);

  /**
   * The maxwell (symbol: {@code Mx}) is the CGS (centimetre-gram-second) unit of magnetic flux (&Phi;).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Maxwell_(unit)">Wikipedia: Maxwell (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFlux> MAXWELL = unit("maxwell", WEBER, new BigDecimal("1E-8"),
      MagneticFlux.class);

  /**
   * The gauss, symbol {@code G}, is the cgs unit of measurement of magnetic flux density (or "magnetic induction").
   * It was named after German mathematician and physicist Carl Friedrich Gauss in 1936.
   * One gauss is defined as one maxwell per square centimeter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gauss_(unit)">Wikipedia: Gauss_(unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFluxDensity> GAUSS = unit("gauss", TESLA, new BigDecimal("1E-4"),
      MagneticFluxDensity.class);

  /**
   * The oersted (symbol {@code Oe}) is the unit of the auxiliary magnetic field
   * in the centimetre-gram-second system of units (CGS).
   * It is equivalent to 1 dyne per maxwell.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Oersted">Wikipedia: Oersted</a>
   */
  @AddUnit
  public static final AbstractUnit<MagneticFieldStrength> OERSTED = unit("oersted", AMPERE_PER_METER, 250 / Math.PI,
      MagneticFieldStrength.class);

  private CgsNamedUnits() {
  }
}
