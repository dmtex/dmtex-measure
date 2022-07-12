package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Mass;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code TroyUnits} class represents Troy unit system.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class TroyUnits {

  /**
   * Grain.
   *
   * @see ImperialUnits#GRAIN
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAIN = unit(ImperialUnits.GRAIN, Mass.class);

  /**
   * A pennyweight (abbreviated {@code dwt}, {@code d} being the symbol of an old British penny)
   * is a unit of mass that is equal to 24 grains, <sup>1</sup>/<sub>20</sub> of a troy ounce,
   * <sup>1</sup>/<sub>240</sub> of a troy pound.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pennyweight">Wikipedia: Pennyweight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> PENNYWEIGHT = add("pennyweight", GRAIN, 24);

  /**
   * A troy ounce is a unit of measure used for weighing precious metals that dates back to the Middle Ages.
   * Originally used in Troyes, France, one troy ounce is equal to 31.1034768 grams, according to the U.K. Royal Mint.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Troy_weight#Troy_ounce_(oz_t)">Wikipedia: Troy ounce</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> OUNCE = add("ounce^troy", GRAIN, 480);

  /**
   * A troy pound is equal to 12 troy ounces and to 5760 grains, that is exactly 373.2417216 grams.
   * Troy weights were used in England by jewellers.
   *
   * <p>Apothecaries also used the troy pound and ounce,
   * but added the drachms and scruples unit in the Apothecaries' system of weights.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pound_(mass)#Troy_pound">Wikipedia: Troy pound</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> POUND = add("pound^troy", OUNCE, 12);

  /**
   * Mite.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Troy_weight">Wikipedia: Troy weight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> MITE = add("mite", GRAIN, new BigRational(1, 20));

  /**
   * Droit.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Troy_weight">Wikipedia: Troy weight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> DROIT = add("droit", MITE, new BigRational(1, 24));

  /**
   * Perit.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Troy_weight">Wikipedia: Troy weight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> PERIT = add("perit", DROIT, new BigRational(1, 20));

  /**
   * Blank.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Troy_weight">Wikipedia: Troy weight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> BLANK = add("blank", PERIT, new BigRational(1, 24));

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Troy").add(TroyUnits.class).build();

  private TroyUnits() {
  }

  private static AbstractUnit<Mass> add(String name, AbstractUnit<Mass> unit, Number factor) {
    return unit(name, unit, factor, Mass.class);
  }
}
