package com.github.dmtex.measure.unit;

import com.github.dmtex.math.rational.BigRational;
import javax.measure.Prefix;
import javax.measure.Quantity;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;

/**
 * {@code MetricPrefix} enumeration contains metric prefixes.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public enum MetricPrefix implements Prefix {

  /**
   * Yotta.
   */
  YOTTA("yotta", 24),

  /**
   * Zetta.
   */
  ZETTA("zetta", 21),

  /**
   * Exa.
   */
  EXA("exa", 18),

  /**
   * Peta.
   */
  PETA("peta", 15),

  /**
   * Tera.
   */
  TERA("tera", 12),

  /**
   * Giga.
   */
  GIGA("giga", 9),

  /**
   * Mega.
   */
  MEGA("mega", 6),

  /**
   * Kilo.
   */
  KILO("kilo", 3),

  /**
   * Hecto.
   */
  HECTO("hecto", 2),

  /**
   * Deka.
   */
  DECA("deca", 1),

  /**
   * Deci.
   */
  DECI("deci", -1),

  /**
   * Centi.
   */
  CENTI("centi", -2),

  /**
   * Milli.
   */
  MILLI("milli", -3),

  /**
   * Micro.
   */
  MICRO("micro", -6),

  /**
   * Nano.
   */
  NANO("nano", -9),

  /**
   * Pico.
   */
  PICO("pico", -12),

  /**
   * Femto.
   */
  FEMTO("femto", -15),

  /**
   * Atto.
   */
  ATTO("atto", -18),

  /**
   * Zepto.
   */
  ZEPTO("zepto", -21),

  /**
   * Yocto.
   */
  YOCTO("yocto", -24);

  private final String prefix;
  private final int exponent;
  private final BigRational value;

  MetricPrefix(String prefix, int exponent) {
    this.prefix = prefix;
    this.exponent = exponent;
    value = exponent > 0 ? new BigRational(TEN.pow(exponent)) : new BigRational(ONE, TEN.pow(-exponent));
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>24</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e24)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> yotta(AbstractUnit<Q> unit) {
    return unit.prefix(YOTTA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>21</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e21)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> zetta(AbstractUnit<Q> unit) {
    return unit.prefix(ZETTA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>18</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e18)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> exa(AbstractUnit<Q> unit) {
    return unit.prefix(EXA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>15</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e15)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> peta(AbstractUnit<Q> unit) {
    return unit.prefix(PETA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>12</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e12)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> tera(AbstractUnit<Q> unit) {
    return unit.prefix(TERA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>9</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e9)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> giga(AbstractUnit<Q> unit) {
    return unit.prefix(GIGA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>6</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e6)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> mega(AbstractUnit<Q> unit) {
    return unit.prefix(MEGA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>3</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e3)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> kilo(AbstractUnit<Q> unit) {
    return unit.prefix(KILO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>2</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e2)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> hecto(AbstractUnit<Q> unit) {
    return unit.prefix(HECTO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>1</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e1)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> deca(AbstractUnit<Q> unit) {
    return unit.prefix(DECA);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-1</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-1)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> deci(AbstractUnit<Q> unit) {
    return unit.prefix(DECI);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-2</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-2)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> centi(AbstractUnit<Q> unit) {
    return unit.prefix(CENTI);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-3</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-3)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> milli(AbstractUnit<Q> unit) {
    return unit.prefix(MILLI);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-6</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-6)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> micro(AbstractUnit<Q> unit) {
    return unit.prefix(MICRO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-9</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-9)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> nano(AbstractUnit<Q> unit) {
    return unit.prefix(NANO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-12</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-12)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> pico(AbstractUnit<Q> unit) {
    return unit.prefix(PICO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-15</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-15)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> femto(AbstractUnit<Q> unit) {
    return unit.prefix(FEMTO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-18</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-18)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> atto(AbstractUnit<Q> unit) {
    return unit.prefix(ATTO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-21</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-21)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> zepto(AbstractUnit<Q> unit) {
    return unit.prefix(ZEPTO);
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-24</sup></code>.
   *
   * @param <Q>  The type of the quantity measured by the unit.
   * @param unit any unit.
   * @return {@code unit.times(1e-24)}
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> yocto(AbstractUnit<Q> unit) {
    return unit.prefix(YOCTO);
  }

  @Override
  public String getName() {
    return prefix;
  }

  @Override
  public String getSymbol() {
    throw new UnsupportedOperationException("Is not implemented yet");
  }

  @Override
  public Number getValue() {
    return value;
  }

  @Override
  public int getExponent() {
    return exponent;
  }
}
