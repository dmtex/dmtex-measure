package com.github.dmtex.measure.system;

import com.github.dmtex.measure.unit.SystemOfUnitsImpl;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code Si} class contains SI system of units units.
 *
 * @author Denis Murashev
 *
 * @see <a href="https://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia:
 * International System of Units</a>
 *
 * @since Measure 1.0
 */
public final class Si {

  /////////////////////// SI System of Units ///////////////////////

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = build();

  private Si() {
  }

  private static SystemOfUnits build() {
    return SystemOfUnitsImpl.builder("SI")
        .add(MetricUnits.class)
        .add(TimeUnits.class)
        .add(MeterUnits.class)
        .add(RadianUnits.class)
        .add(NamedUnits.class)
        .add(AmpereUnits.class)
        .add(MiscUnits.class)
        .add(NonSiUnits.class)
        .build();
  }
}
