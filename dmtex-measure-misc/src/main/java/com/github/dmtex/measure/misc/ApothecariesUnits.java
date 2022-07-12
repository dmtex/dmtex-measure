package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code ApothecariesUnits} class represents Apothecaries' unit system.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class ApothecariesUnits {

  /**
   * Grain.
   *
   * @see ImperialUnits#GRAIN
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAIN = unit(ImperialUnits.GRAIN, Mass.class);

  /**
   * Apothecaries' scruple.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Apothecaries%27_system">Wikipedia: Apothecaries' system</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> SCRUPLE = unit("scruple", GRAIN, 20, Mass.class);

  /**
   * Apothecaries' dram.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Apothecaries%27_system">Wikipedia: Apothecaries' system</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> DRAM = unit("dram^apothecary", GRAIN, 60, Mass.class);

  /**
   * Apothecaries' ounce (equal to Troy ounce).
   *
   * @see TroyUnits#OUNCE
   */
  @AddUnit
  public static final AbstractUnit<Mass> OUNCE = unit(TroyUnits.OUNCE.alternate("ounce^apothecary"), Mass.class);

  /**
   * Apothecaries' pound (equal to Troy pound).
   *
   * @see TroyUnits#POUND
   */
  @AddUnit
  public static final AbstractUnit<Mass> POUND = unit(TroyUnits.POUND.alternate("pound^apothecary"), Mass.class);

  /**
   * A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
   * typically used for measuring liquids.
   *
   * @see ImperialUnits#FLUID_OUNCE
   */
  @AddUnit
  public static final AbstractUnit<Volume> FLUID_OUNCE = unit(ImperialUnits.FLUID_OUNCE, Volume.class);

  /**
   * The fluid dram (or fluid drachm in British spelling) is defined as <sup>1</sup>/<sub>8</sub> of a fluid ounce.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)#Dram_(volume)">Wikipedia: Dram (volume)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> FLUID_DRAM = unit("dram^fluid", FLUID_OUNCE, Rational.ONE_EIGHTH,
      Volume.class);

  /**
   * Fluid scruple.
   */
  @AddUnit
  public static final AbstractUnit<Volume> FLUID_SCRUPLE = unit("scruple^fluid", FLUID_DRAM, Rational.ONE_THIRD,
      Volume.class);

  /**
   * The minim (abbreviated {@code min}) is a unit of volume in the imperial system of measurement.
   * Specifically it is <sup>1</sup>/<sub>60</sub> of a fluid drachm or <sup>1</sup>/<sub>480</sub> of a fluid ounce.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Minim_(unit)">Wikipedia: Minim (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> MINIM = unit("minim", FLUID_SCRUPLE, new Rational(1, 20), Volume.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Apothecaries")
      .add(ApothecariesUnits.class)
      .build();

  private ApothecariesUnits() {
  }
}
