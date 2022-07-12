package com.github.dmtex.measure.misc;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import java.math.BigDecimal;
import javax.measure.quantity.Temperature;
import javax.measure.spi.SystemOfUnits;

import static com.github.dmtex.measure.system.MetricUnits.KELVIN;
import static com.github.dmtex.measure.system.MiscUnits.CELSIUS;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code TemperatureUnits} class provides temperature units.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class TemperatureUnits {

  /**
   * The Rankine scale is an absolute scale of thermodynamic temperature named after
   * the Glasgow University engineer and physicist William John Macquorn Rankine, who proposed it in 1859.
   * A unit of temperature equal to <sup>5</sup>/<sub>9</sub> {@code K} (standard name &deg;{@code R}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Rankine_scale">Wikipedia: Rankine scale</a>
   */
  @AddUnit
  public static final AbstractUnit<Temperature> RANKINE = unit("rankine", KELVIN, new Rational(5, 9),
      Temperature.class);

  /**
   * The Fahrenheit scale is a temperature scale based on one proposed in 1724
   * by German physicist Daniel Gabriel Fahrenheit (1686-1736).
   * It uses the degree Fahrenheit (symbol: &deg;{@code F}) as the unit.
   *
   * <p>On the Fahrenheit scale, the freezing point of water is 32 &deg;{@code F}
   * and the boiling point is 212 &deg;{@code F} (at standard atmospheric pressure).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Wikipedia: Fahrenheit</a>
   */
  @AddUnit
  public static final AbstractUnit<Temperature> FAHRENHEIT = unit(RANKINE.shift(new BigDecimal("459.67"))
      .alternate("fahrenheit"), Temperature.class);

  /**
   * The R&eacute;aumur scale (&deg;R&eacute;, &deg;Re, &deg;r), also known as the "octogesimal division",
   * is a temperature scale for which the freezing and boiling points of water are defined
   * as 0 and 80 degrees respectively.
   * The scale is named for Ren&eacute; Antoine Ferchault de R&eacute;aumur,
   * who first proposed a similar scale in 1730.
   *
   * @see <a href="https://en.wikipedia.org/wiki/R%C3%A9aumur_scale">Wikipedia: R&eacute;aumur scale</a>
   */
  @AddUnit
  public static final AbstractUnit<Temperature> REAUMUR = unit("reaumur", CELSIUS, new Rational(4, 5),
      Temperature.class);

  ///////////////////////// System of British Imperial Units /////////////////////////

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Temperature")
      .add(TemperatureUnits.class)
      .build();

  private TemperatureUnits() {
  }
}
