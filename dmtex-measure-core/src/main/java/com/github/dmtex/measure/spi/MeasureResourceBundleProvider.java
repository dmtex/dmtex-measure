package com.github.dmtex.measure.spi;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureResourceBundleProvider} interface is SPI for Resource Bundle mechanism extension.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public interface MeasureResourceBundleProvider {

  /**
   * Provides {@link ResourceBundle} for given format calss and locale.
   *
   * @param formatClass formatClass
   * @param locale      locale
   * @return ResourceBundle if appropriate one exists
   */
  ResourceBundle getBundle(Class<? extends UnitFormat> formatClass, Locale locale);
}
