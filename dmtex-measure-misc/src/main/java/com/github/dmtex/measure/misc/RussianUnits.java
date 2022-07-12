package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import java.math.BigDecimal;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.misc.ImperialUnits.CUBIC_INCH;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code RussianUnits} class represents old Russian unit system.
 *
 * @author Denis Murashev
 *
 * @see <a href="https://en.wikipedia.org/wiki/Obsolete_Russian_units_of_measurement">Obsolete Russian units of
 * measurement</a>
 *
 * @since Measure 1.0
 */
public final class RussianUnits {

  ///////////////////////// Length obsolete Russian Units /////////////////////////

  /**
   * Tochka (point). <sup>1</sup>/<sub>100</sub> inch.
   */
  @AddUnit
  public static final AbstractUnit<Length> POINT = unit("point", ImperialUnits.INCH, new BigRational(1, 100),
      Length.class);

  /**
   * Line. <sup>1</sup>/<sub>10</sub> inch.
   */
  @AddUnit
  public static final AbstractUnit<Length> LINE = unit("line", ImperialUnits.INCH, new Rational(1, 10), Length.class);

  /**
   * Inch.
   *
   * @see ImperialUnits#INCH
   */
  @AddUnit
  public static final AbstractUnit<Length> INCH = unit(ImperialUnits.INCH, Length.class);

  /**
   * Vershok (tip, top). 1<sup>3</sup>/<sub>4</sub> inches.
   */
  @AddUnit
  public static final AbstractUnit<Length> VERSHOK = unit("vershok", INCH, new Rational(7, 4), Length.class);

  /**
   * Pyad (Span, quarter). 7 inches.
   */
  @AddUnit
  public static final AbstractUnit<Length> SPAN = unit("span", INCH, 7, Length.class);

  /**
   * Foot.
   *
   * @see ImperialUnits#FOOT
   */
  @AddUnit
  public static final AbstractUnit<Length> FOOT = unit(ImperialUnits.FOOT, Length.class);

  /**
   * Arshin. 28 inches.
   */
  @AddUnit
  public static final AbstractUnit<Length> ARSHIN = unit("arshin", INCH, 28, Length.class);

  /**
   * Sazhen (fathom). 7 feet.
   */
  @AddUnit
  public static final AbstractUnit<Length> FATHOM = unit("fathom", FOOT, 7, Length.class);

  /**
   * Verst (turn of a plough). 3,500 feet.
   */
  @AddUnit
  public static final AbstractUnit<Length> VERST = unit("verst", FATHOM, 500, Length.class);

  /**
   * Mile. 24,500 feet.
   */
  @AddUnit
  public static final AbstractUnit<Length> MILE = unit("mile", VERST, 7, Length.class);

  ///////////////////////// Area obsolete Russian Units /////////////////////////

  /**
   * Square line.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_LINE = unit(LINE.pow(2), Area.class);

  /**
   * Square inch.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_INCH = unit(INCH.pow(2), Area.class);

  /**
   * Square vershok.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_VERSHOK = unit(VERSHOK.pow(2), Area.class);

  /**
   * Square foot.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_FOOT = unit(FOOT.pow(2), Area.class);

  /**
   * Square arshin.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_ARSHIN = unit(ARSHIN.pow(2), Area.class);

  /**
   * Square fathom.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_FATHOM = unit(FATHOM.pow(2), Area.class);

  /**
   * Dessyatina.
   */
  @AddUnit
  public static final AbstractUnit<Area> DESSYATINA = unit("dessyatina", SQUARE_FATHOM, 2400, Area.class);

  /**
   * Square verst.
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_VERST = unit(VERST.pow(2), Area.class);

  ///////////////////////// Liquid Volume obsolete Russian Units /////////////////////////

  /**
   * Shkalik (shot, measure). 3<sup>3</sup>/<sub>4</sub> cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> SHKALIK = unit("shkalik", CUBIC_INCH, new Rational(3, 3, 4), Volume.class);

  /**
   * Charka (wine glass). 7<sup>1</sup>/<sub>2</sub> cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> CHARKA = unit("charka", CUBIC_INCH, new Rational(7, 1, 2), Volume.class);

  /**
   * Stakan (cup, glass). 15<sup>5</sup>/<sub>8</sub> cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUP = unit("cup", CUBIC_INCH, new Rational(15, 5, 8), Volume.class);

  /**
   * Vodka bottle. 37<sup>1</sup>/<sub>2</sub> cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> VODKA_BOTTLE = unit("bottle^vodka", CUBIC_INCH, new Rational(37, 1, 2),
      Volume.class);

  /**
   * Wine bottle. 46<sup>7</sup>/<sub>8</sub> cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> WINE_BOTTLE = unit("bottle^wine", CUBIC_INCH, new Rational(46, 7, 8),
      Volume.class);

  /**
   * Stof (mug, flagon). 75 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> STOF = unit("stof", CUBIC_INCH, 75, Volume.class);

  /**
   * Chetvert' (quarter of bucket). 187.5 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> QUARTER = unit("quarter", CUBIC_INCH, 187.5, Volume.class);

  /**
   * Vedro (bucket). 750 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> BUCKET = unit("bucket", CUBIC_INCH, 750, Volume.class);

  /**
   * Bochka (barrel). 30,000 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> BARREL = unit("bochka", CUBIC_INCH, 30_000, Volume.class);

  ///////////////////////// Dry Volume obsolete Russian Units /////////////////////////

  /**
   * Dry part. Dry measure.
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_PART = unit("part^dry", CUBIC_INCH, new Rational(20, 3), Volume.class);

  /**
   * Glass. Dry measure.
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_GLASS = unit("cup^dry", CUBIC_INCH, new Rational(50, 3), Volume.class);

  /**
   * Garnets (pot). 200 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> GARNETS = unit("pot", CUBIC_INCH, 200, Volume.class);

  /**
   * Vedro (dry bucket). 800 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_BUCKET = unit("bucket^dry", CUBIC_INCH, 800, Volume.class);

  /**
   * Chetverik (quarter of one eighth). 1,600 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> CHETVERIK = unit("chetverik", CUBIC_INCH, 1600, Volume.class);

  /**
   * Osmina (dry one eighth). 6,400 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> EIGHTH = unit("eighth", CUBIC_INCH, 6400, Volume.class);

  /**
   * Chetvert' (dry quarter). 12,800 cu in.
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_QUARTER = unit("quarter^dry", CUBIC_INCH, 12_800, Volume.class);

  ///////////////////////// Mass obsolete Russian Units /////////////////////////

  /**
   * Russian pood.
   */
  @AddUnit
  public static final AbstractUnit<Mass> POOD = unit("pood", KILOGRAM, new BigDecimal("16.3804964"), Mass.class);

  /**
   * Russian pound.
   */
  @AddUnit
  public static final AbstractUnit<Mass> POUND = unit("pound", POOD, new BigRational(1, 40), Mass.class);

  /**
   * Russian lot.
   */
  @AddUnit
  public static final AbstractUnit<Mass> LOT = unit("lot", POUND, new BigRational(1, 32), Mass.class);

  /**
   * Zolotnick.
   */
  @AddUnit
  public static final AbstractUnit<Mass> ZOLOTNICK = unit("zolotnik", POUND, new BigRational(1, 96), Mass.class);

  /**
   * Dolya.
   */
  @AddUnit
  public static final AbstractUnit<Mass> DOLYA = unit("dolya", ZOLOTNICK, new BigRational(1, 96), Mass.class);

  /**
   * Berkovets.
   */
  @AddUnit
  public static final AbstractUnit<Mass> BERKOVETS = unit("berkovets", POOD, 10, Mass.class);

  ///////////////////////// Mass Apothecaries' obsolete Russian Units /////////////////////////

  /**
   * Russian apothecaries' pound.
   */
  @AddUnit
  public static final AbstractUnit<Mass> POUND_AP = unit("pound^apothecary", ZOLOTNICK, 84, Mass.class);

  /**
   * Russian apothecaries' ounce.
   */
  @AddUnit
  public static final AbstractUnit<Mass> OUNCE_AP = unit("ounce^apothecary", POUND_AP, new Rational(1, 12),
      Mass.class);

  /**
   * Russian apothecaries' dram.
   */
  @AddUnit
  public static final AbstractUnit<Mass> DRAM_AP = unit("dram^apothecary", OUNCE_AP, Rational.ONE_EIGHTH, Mass.class);

  /**
   * Russian apothecaries' scruple.
   */
  @AddUnit
  public static final AbstractUnit<Mass> SCRUPLE_AP = unit("scruple^apothecary", DRAM_AP, Rational.ONE_THIRD,
      Mass.class);

  /**
   * Russian apothecaries' grain.
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAIN_AP = unit("grain^apothecary", SCRUPLE_AP, new Rational(1, 20),
      Mass.class);

  ///////////////////////// System of obsolete Russian Units /////////////////////////

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Russian obsolete")
      .add(RussianUnits.class)
      .build();

  private RussianUnits() {
  }
}
