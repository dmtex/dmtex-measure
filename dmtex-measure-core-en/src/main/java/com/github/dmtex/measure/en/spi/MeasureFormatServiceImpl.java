package com.github.dmtex.measure.en.spi;

import com.github.dmtex.measure.format.LocaleAdapter;
import com.github.dmtex.measure.spi.MeasureFormatService;
import java.util.Locale;

/**
 * {@code MeasureFormatServiceImpl} class is Locale SPI implementation for English Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MeasureFormatServiceImpl implements MeasureFormatService {

  @Override
  public LocaleAdapter getAdapter(Locale locale) {
    if ("en".equals(locale.getLanguage())) {
      return new LocaleAdapterImpl();
    }
    return null;
  }
}
