package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.TimeUnits.HOUR;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code UsCustomaryUnits} class represents United States customary unit system.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class UsCustomaryUnits {

  ///////////////////////// Length US Customary Units /////////////////////////

  /**
   * Inch.
   *
   * @see ImperialUnits#INCH
   */
  @AddUnit
  public static final AbstractUnit<Length> INCH = unit(ImperialUnits.INCH, Length.class);

  /**
   * Foot.
   *
   * @see ImperialUnits#FOOT
   */
  @AddUnit
  public static final AbstractUnit<Length> FOOT = unit(ImperialUnits.FOOT, Length.class);

  /**
   * The United States survey foot is defined as exactly <sup>1200</sup>/<sub>3937</sub> meters.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Foot_(unit)#US_survey_foot">US survey foot</a>
   */
  @AddUnit
  public static final AbstractUnit<Length> FOOT_SURVEY = unit("foot_survey", METER, new Rational(1200, 3937),
      Length.class);

  /**
   * Yard.
   *
   * @see ImperialUnits#YARD
   */
  @AddUnit
  public static final AbstractUnit<Length> YARD = unit(ImperialUnits.YARD, Length.class);

  /**
   * Mile.
   *
   * @see ImperialUnits#MILE
   */
  @AddUnit
  public static final AbstractUnit<Length> MILE = unit(ImperialUnits.MILE, Length.class);

  /**
   * Nautical mile.
   *
   * @see LegacyUnits#NAUTICAL_MILE
   */
  @AddUnit
  public static final AbstractUnit<Length> NAUTICAL_MILE = LegacyUnits.NAUTICAL_MILE;

  ///////////////////////// Area US Customary Units /////////////////////////

  /**
   * Square foot.
   *
   * @see ImperialUnits#SQUARE_FOOT
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_FOOT = unit(ImperialUnits.SQUARE_FOOT, Area.class);

  /**
   * Square chain.
   *
   * @see ImperialUnits#CHAIN
   */
  @AddUnit
  public static final AbstractUnit<Area> SQUARE_CHAIN = unit(ImperialUnits.CHAIN.pow(2), Area.class);

  /**
   * Acre.
   *
   * @see ImperialUnits#ACRE
   */
  @AddUnit
  public static final AbstractUnit<Area> ACRE = unit(ImperialUnits.ACRE, Area.class);

  /**
   * In U.S. land surveying under the Public Land Survey System (PLSS),
   * a section is an area nominally one square mile (2.6 square kilometers), containing 640 acres (260 hectares)
   *
   * @see <a href="https://en.wikipedia.org/wiki/Section_(United_States_land_surveying)">Wikipedia:
   * Section (United States land surveying)</a>
   */
  @AddUnit
  public static final AbstractUnit<Area> SECTION = unit(ImperialUnits.SQUARE_MILE.alternate("section"), Area.class);

  /**
   * In U.S. land surveying under the Public Land Survey System (PLSS),
   * a section is an area nominally one square mile (2.6 square kilometers), containing 640 acres (260 hectares)
   *
   * @see <a href="https://en.wikipedia.org/wiki/Survey_township">Wikipedia: Survey township</a>
   */
  @AddUnit
  public static final AbstractUnit<Area> TOWNSHIP = unit("township", SECTION, 36, Area.class);

  ///////////////////////// Volume US Customary Units /////////////////////////

  /**
   * Cubic inch.
   *
   * @see ImperialUnits#CUBIC_INCH
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUBIC_INCH = unit(ImperialUnits.CUBIC_INCH, Volume.class);

  /**
   * Cubic foot.
   *
   * @see ImperialUnits#CUBIC_FOOT
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUBIC_FOOT = unit(ImperialUnits.CUBIC_FOOT, Volume.class);

  /**
   * Cubic yard.
   *
   * @see ImperialUnits#CUBIC_YARD
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUBIC_YARD = unit(ImperialUnits.CUBIC_YARD, Volume.class);

  /**
   * The acre-foot is a non-SI unit of volume commonly used in the United States
   * in reference to large-scale water resources, such as reservoirs, aqueducts, canals, sewer flow capacity,
   * irrigation water, and river flows.
   *
   * <p>An acre-foot equals approximately an 8 lane swimming pool, 25 meter long, 16 m wide and 3 m deep.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Acre-foot">Wikipedia: Acre-foot</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> ACRE_FOOT = unit(ACRE.multiply(FOOT), Volume.class);

  ///////////////////////// Fluid Volume US Customary Units /////////////////////////

  /**
   * The gallon is a unit of measurement for volume and fluid capacity in the US customary units
   * systems of measurement.
   *
   * <p>the US gallon defined as 231 cubic inches (exactly 3.785411784 litres),
   * which is used in the US and some Latin American and Caribbean countries.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gallon">Wikipedia: Gallon</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> GALLON = unit("gallon", CUBIC_INCH, 231, Volume.class);

  /**
   * The quart (abbreviation {@code qt.}) is an English unit of volume equal to a quarter gallon.
   * It is divided into two pints.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Quart">Wikipedia: Quart</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> QUART = unit("quart", GALLON, Rational.ONE_FOURTH, Volume.class);

  /**
   * The pint (symbol {@code pt}) is a unit of volume or capacity in the  United States customary measurement
   * systems. It is traditionally one eighth of a gallon.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pint">Wikipedia: Pint</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> PINT = unit("pint", QUART, Rational.HALF, Volume.class);

  /**
   * The cup is a cooking measure of volume, commonly associated with cooking and serving sizes.
   * It is traditionally equal to half a liquid pint in US customary units.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Cup_(unit)">Wikipedia: Cup (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> CUP = unit("cup", PINT, Rational.HALF, Volume.class);

  /**
   * The gill or teacup is a unit of measurement for volume equal to a quarter of a pint.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Gill_(unit)">Wikipedia: Gill (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> GILL = unit("gill", CUP, Rational.HALF, Volume.class);

  /**
   * A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
   * typically used for measuring liquids.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Fluid_ounce">Wikipedia: Fluid ounce</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> FLUID_OUNCE = unit("ounce^fluid", GILL, Rational.ONE_FOURTH, Volume.class);

  /**
   * A tablespoon is a large spoon used for serving.
   *
   * <p>By extension, the term is also used as a cooking measure of volume.
   * In this capacity, it is most commonly abbreviated {@code tbsp.} or {@code T.},
   * and occasionally referred to as a tablespoonful to distinguish it from the utensil.
   * The unit of measurement varies by region: a United States tablespoon is approximately 14.8 mL (0.50 US fl oz).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Tablespoon">Wikipedia: Tablespoon</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> TABLESPOON = unit("spoon^table", FLUID_OUNCE, Rational.HALF, Volume.class);

  /**
   * As a unit of culinary measure, one teaspoon in the United States is <sup>1</sup>/<sub>3</sub> tablespoon,
   * that is, exactly 4.92892159375 mL; it is exactly 1<sup>1</sup>/<sub>3</sub> US fluid drams,
   * <sup>1</sup>/<sub>6</sub> US fl oz.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Teaspoon">Wikipedia: Teaspoon</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> TEASPOON = unit("spoon^tea", TABLESPOON, Rational.ONE_THIRD, Volume.class);

  /**
   * A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
   * typically used for measuring liquids.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)#Dram_(volume)">Wikipedia: Dram (volume)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> FLUID_DRAM = unit("dram^fluid", FLUID_OUNCE, Rational.ONE_EIGHTH,
      Volume.class);

  /**
   * The minim (abbreviated {@code min}) is a unit of volume in the US customary system of measurement.
   * Specifically it is <sup>1</sup>/<sub>60</sub> of a fluid drachm or <sup>1</sup>/<sub>480</sub> of a fluid ounce.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Minim_(unit)">Wikipedia: Minim (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> MINIM = unit("minim", FLUID_DRAM, new Rational(1, 60), Volume.class);

  /**
   * Fluid barrels vary depending on what is being measured and where.
   * In the US most fluid barrels (apart from oil) are 31.5 US gallons (26 imp gal; 119 L).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Barrel_(unit)">Wikipedia: Barrel (unit)</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> BARREL = unit("barrel", GALLON, 31.5, Volume.class);

  /**
   * A hogshead (abbreviated {@code hhd}) is a large cask of liquid (or, less often, of a food commodity).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Hogshead">Wikipedia: Hogshead</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> HOGSHEAD = unit("hogshead", BARREL, 2, Volume.class);

  ///////////////////////// Dry Volume US Customary Units /////////////////////////

  /**
   * A bushel (abbreviation: {@code bsh.} or {@code bu.}) is an US customary unit of volume
   * based upon an earlier measure of dry capacity.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Bushel">Wikipedia: Bushel</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> BUSHEL = unit("bushel", CUBIC_INCH, 2150.42, Volume.class);

  /**
   * A peck is an imperial unit of dry volume, equivalent to 2 dry gallons or 8 dry quarts(8.81 liters).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Peck">Wikipedia: Peck</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> PECK = unit("peck", BUSHEL, Rational.ONE_FOURTH, Volume.class);

  /**
   * The gallon is a unit of measurement for volume and implicitly dry capacity in the US customary units
   * systems of measurement.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dry_gallon">Wikipedia: Dry gallon</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_GALLON = unit("gallon^dry", PECK, Rational.HALF, Volume.class);

  /**
   * The quart (abbreviation {@code qt.}) is an English unit of volume equal to a quarter gallon.
   * It is divided into two pints.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Quart">Wikipedia: Quart</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_QUART = unit("quart^dry", DRY_GALLON, Rational.ONE_FOURTH,
      Volume.class);

  /**
   * The pint (symbol {@code pt}) is a unit of volume or capacity in the  United States customary measurement
   * systems. It is traditionally one eighth of a gallon.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pint">Wikipedia: Pint</a>
   */
  @AddUnit
  public static final AbstractUnit<Volume> DRY_PINT = unit("pint^dry", DRY_QUART, Rational.HALF, Volume.class);

  ///////////////////////// Mass US Customary Units /////////////////////////

  /**
   * Grain.
   *
   * @see ImperialUnits#GRAIN
   */
  @AddUnit
  public static final AbstractUnit<Mass> GRAIN = unit(ImperialUnits.GRAIN, Mass.class);

  /**
   * Dram.
   *
   * @see ImperialUnits#DRAM
   */
  @AddUnit
  public static final AbstractUnit<Mass> DRAM = unit(ImperialUnits.DRAM, Mass.class);

  /**
   * Ounce.
   *
   * @see ImperialUnits#OUNCE
   */
  @AddUnit
  public static final AbstractUnit<Mass> OUNCE = unit(ImperialUnits.OUNCE, Mass.class);

  /**
   * Pound.
   *
   * @see ImperialUnits#POUND
   */
  @AddUnit
  public static final AbstractUnit<Mass> POUND = unit(ImperialUnits.POUND, Mass.class);

  /**
   * The hundredweight (abbreviation: {@code cwt}), formerly also known as the centum weight or quintal,
   * is an American unit of weight or mass of various values.
   *
   * <p>The short hundredweight or cental of 100 pounds (45.359237 kg) is used in the United States.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Hundredweight">Wikipedia: Hundredweight</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> CWT = unit("hundredweight", POUND, 100, Mass.class);

  /**
   * The short ton is a unit of measure.
   * In the United States and Canada a ton is defined to be 2,000 pounds (907 kg).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Ton">Wikipedia: Ton</a>
   */
  @AddUnit
  public static final AbstractUnit<Mass> TON = unit("ton", POUND, 2000, Mass.class);

  ///////////////////////// Speed US Customary Units /////////////////////////

  /**
   * Foot per second.
   *
   * @see ImperialUnits#FOOT_PER_SECOND
   */
  @AddUnit
  public static final AbstractUnit<Speed> FOOT_PER_SECOND = unit(ImperialUnits.FOOT_PER_SECOND, Speed.class);

  /**
   * Miles per hour ({@code mph}, {@code MPH} or {@code mi/h}) is a British imperial
   * and United States customary unit of speed expressing the number of statute miles covered in one hour.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Miles_per_hour">Wikipedia: Miles per hour</a>
   */
  @AddUnit
  public static final AbstractUnit<Speed> MILE_PER_HOUR = unit(MILE.divide(HOUR), Speed.class);

  /**
   * The knot.
   *
   * @see LegacyUnits#KNOT
   */
  @AddUnit
  public static final AbstractUnit<Speed> KNOT = LegacyUnits.KNOT;

  ///////////////////////// Temperature Units /////////////////////////

  /**
   * Degree Fahrenheit.
   *
   * @see ImperialUnits#FAHRENHEIT
   */
  @AddUnit
  public static final AbstractUnit<Temperature> FAHRENHEIT = ImperialUnits.FAHRENHEIT;

  ///////////////////////// System of US Customary Units /////////////////////////

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("US Customary")
      .add(UsCustomaryUnits.class)
      .build();

  private UsCustomaryUnits() {
  }
}
