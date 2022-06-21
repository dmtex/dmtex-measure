package com.github.dmtex.measure.en.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.spi.AbstractResourceBundleProvider;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureResourceBundleProviderImpl} class is SPI implementation of {@link MeasureResourceBundleProvider}
 * for English locales.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MeasureResourceBundleProviderImpl extends AbstractResourceBundleProvider
    implements MeasureResourceBundleProvider {

  @Override
  public ResourceBundle getBundle(Class<? extends UnitFormat> formatClass, Locale locale) {
    if (FullUnitFormat.class.equals(formatClass) && "en".equals(locale.getLanguage())) {
      return super.getBundle(formatClass.getSimpleName() + "_unit", locale);
    }
    return null;
  }
}
