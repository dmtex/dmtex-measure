package com.github.dmtex.measure.misc.ru.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.spi.AbstractResourceBundleProvider;
import javax.measure.format.UnitFormat;

/**
 * {@code MiscMeasureResourceBundleProvider} class is SPI implementation of {@link MeasureResourceBundleProvider}
 * for Russian locales.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MiscMeasureResourceBundleProvider extends AbstractResourceBundleProvider
    implements MeasureResourceBundleProvider {

  /**
   * Provides {@link ResourceBundle} for given format calss and locale.
   *
   * @param formatClass formatClass
   * @param locale      locale
   * @return ResourceBundle if appropriate one exists
   */
  @Override
  public ResourceBundle getBundle(Class<? extends UnitFormat> formatClass, Locale locale) {
    if ("ru".equals(locale.getLanguage())) {
      if (MeasureUnitFormat.class.equals(formatClass)) {
        return super.getBundle("MiscUnitFormat_unit", locale);
      }
      if (FullUnitFormat.class.equals(formatClass)) {
        return super.getBundle("MiscFullUnitFormat_unit", locale);
      }
    }
    return null;
  }
}
