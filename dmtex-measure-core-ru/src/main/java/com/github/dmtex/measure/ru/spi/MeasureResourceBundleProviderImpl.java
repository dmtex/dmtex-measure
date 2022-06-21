package com.github.dmtex.measure.ru.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.spi.AbstractResourceBundleProvider;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureResourceBundleProviderImpl} class is SPI implementation of {@link MeasureResourceBundleProvider}
 * for Russian locales.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MeasureResourceBundleProviderImpl extends AbstractResourceBundleProvider
    implements MeasureResourceBundleProvider {

  private static final Set<Class<? extends MeasureUnitFormat>> SUPPORTED_CLASSES = Set.of(MeasureUnitFormat.class,
      FullUnitFormat.class);

  @Override
  public ResourceBundle getBundle(Class<? extends UnitFormat> formatClass, Locale locale) {
    if (SUPPORTED_CLASSES.contains(formatClass) && "ru".equals(locale.getLanguage())) {
      return super.getBundle(formatClass.getSimpleName() + "_unit", locale);
    }
    return null;
  }
}
