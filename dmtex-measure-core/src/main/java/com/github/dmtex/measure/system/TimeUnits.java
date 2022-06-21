package com.github.dmtex.measure.system;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import java.math.BigDecimal;
import javax.measure.quantity.Time;

import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code TimeUnits} class contains {@link Time} units.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class TimeUnits {

  /**
   * A time unit accepted for use with SI units (standard name {@code min}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Minute">Wikipedia: Minute</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> MINUTE = unit("minute", SECOND, 60, Time.class);

  /**
   * A time unit accepted for use with SI units (standard name {@code h}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Hour">Wikipedia: Hour</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> HOUR = unit("hour", SECOND, 3600, Time.class);

  /**
   * A time unit accepted for use with SI units (standard name {@code d}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Day">Wikipedia: Day</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> DAY = unit("day", HOUR, 24, Time.class);

  /**
   * A unit of duration equal to 7 {@link #DAY} (standard name {@code week}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Week">Wikipedia: Week</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> WEEK = unit("week", DAY, 7, Time.class);

  /**
   * A time unit accepted for use with SI units (standard name {@code y}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Year">Wikipedia: Year</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> YEAR = unit("year", DAY, new BigDecimal("365.2425"), Time.class);

  /**
   * In astronomy, a Julian year (symbol: {@code a}) is a unit of measurement of time defined as exactly 365.25 days
   * of 86400 SI seconds each.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Julian_year_(astronomy)">Wikipedia: Julian year (astronomy)</a>
   */
  @AddUnit
  public static final AbstractUnit<Time> JULIAN_YEAR = unit("year_julian", SECOND, 31_557_600, Time.class);

  private TimeUnits() {
  }
}
