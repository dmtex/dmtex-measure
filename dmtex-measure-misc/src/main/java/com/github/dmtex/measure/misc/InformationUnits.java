package com.github.dmtex.measure.misc;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.unit.AbstractUnit;
import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.spi.SystemOfUnits;
import systems.uom.quantity.Information;
import systems.uom.quantity.InformationRate;

import static com.github.dmtex.measure.dimension.Dimensions.DIMENSIONLESS;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.Units.unit;

/**
 * {@code InformationUnits} class contains {@link Information} units.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class InformationUnits {

  /**
   * The bit is a basic unit of information in information theory, computing, and digital communications.
   * The name is a portmanteau of <b>b</b>inary dig<b>it</b>.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Bit">Wikipedia: Bit</a>
   */
  @AddUnit
  public static final AbstractUnit<Information> BIT = unit("bit", DIMENSIONLESS, Information.class);

  /**
   * The byte is a unit of digital information that most commonly consists of eight bits.
   * Historically, the byte was the number of bits used to encode a single character of text in a computer
   * and for this reason it is the smallest addressable unit of memory in many computer architectures.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Byte">Wikipedia: Byte</a>
   */
  @AddUnit
  public static final AbstractUnit<Information> BYTE = unit("byte", BIT, 8, Information.class);

  /**
   * The bit rate is quantified using the bits per second unit (symbol: {@code bit/s}).
   *
   * @see <a href="https://en.wikipedia.org/wiki/Bit_rate">Wikipedia: Bit rate</a>
   */
  @AddUnit
  public static final AbstractUnit<InformationRate> BIT_PER_SECOND = unit(BIT.divide(SECOND), InformationRate.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Information")
      .add(InformationUnits.class)
      .build();

  private InformationUnits() {
  }
}
