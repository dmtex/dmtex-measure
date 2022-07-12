package com.github.dmtex.measure.misc.spi;

import com.github.dmtex.measure.spi.MeasureServiceProvider;
import javax.measure.spi.FormatService;
import javax.measure.spi.SystemOfUnitsService;

/**
 * {@code MiscServiceProvider} class is service provider for Measure project with support miscellaneous units.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MiscServiceProvider extends MeasureServiceProvider {

  private static final FormatService FORMAT_SERVICE = new MiscFormatService();

  @Override
  public SystemOfUnitsService getSystemOfUnitsService() {
    return new MiscSystemOfUnitsService();
  }

  @Override
  public FormatService getFormatService() {
    return FORMAT_SERVICE;
  }
}
