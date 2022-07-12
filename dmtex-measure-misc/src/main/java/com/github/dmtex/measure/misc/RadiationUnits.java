package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import java.math.BigDecimal;
import javax.measure.quantity.RadiationDoseAbsorbed;
import javax.measure.quantity.RadiationDoseEffective;
import javax.measure.quantity.Radioactivity;
import si.uom.quantity.IonizingRadiation;

import static com.github.dmtex.measure.system.AmpereUnits.COULOMB;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.system.MiscUnits.BECQUEREL;
import static com.github.dmtex.measure.system.MiscUnits.GRAY;
import static com.github.dmtex.measure.system.MiscUnits.SIEVERT;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code RadiationUnits} class contains legacy non-SI units related to radioactivity.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class RadiationUnits {

  /**
   * The rad is a unit of absorbed radiation dose, defined as 1 rad = 0.01 Gy = 0.01 J/kg.
   * It was originally defined in CGS units in 1953 as the dose causing 100 ergs of energy
   * to be absorbed by one gram of matter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Rad_(unit)">Wikipedia: Rad (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<RadiationDoseAbsorbed> RAD = unit("rad", GRAY, new Rational(1, 100),
      RadiationDoseAbsorbed.class);

  /**
   * The roentgen equivalent man (or {@code rem}) is an older, CGS unit of equivalent dose, effective dose,
   * and committed dose which are measures of the health effect of low levels of ionizing radiation on the human body.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Roentgen_equivalent_man">Wikipedia: Roentgen equivalent man</a>
   */
  @AddUnit
  public static final AbstractUnit<RadiationDoseEffective> REM = unit("rem", SIEVERT, new Rational(1, 100),
      RadiationDoseEffective.class);

  /**
   * The curie (symbol {@code Ci}) is a non-SI unit of radioactivity originally defined in 1910.
   * According to a notice in Nature at the time, it was named in honour of Pierre Curie,
   * but was considered at least by some to be in honour of Marie Curie as well.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Curie">Wikipedia: Curie</a>
   */
  @AddUnit
  public static final AbstractUnit<Radioactivity> CURIE = unit("curie", BECQUEREL, 37_000_000_000L,
      Radioactivity.class);

  /**
   * The rutherford (symbol {@code Rd}) is a non-SI unit of radioactive decay.
   * It is defined as the activity of a quantity of radioactive material in which one million nuclei decay per second.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Rutherford_(unit)">Wikipedia: Rutherford (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Radioactivity> RUTHERFORD = unit("rutherford", BECQUEREL, 1_000_000,
      Radioactivity.class);

  /**
   * The roentgen or r&ouml;ntgen (symbol {@code R}) is a legacy unit of measurement for the exposure of X-rays
   * and gamma rays, and is defined as the electric charge freed by such radiation in a specified volume of air
   * divided by the mass of that air (coulomb per kilogram).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Roentgen_(unit)"> Wikipedia: Roentgen</a>
   */
  @AddUnit
  public static final AbstractUnit<IonizingRadiation> ROENTGEN = unit(COULOMB.divide(KILOGRAM)
      .multiply(new BigDecimal("2.58E-4")).alternate("roentgen"), IonizingRadiation.class);

  private RadiationUnits() {
  }
}
