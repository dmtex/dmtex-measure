package com.github.dmtex.measure.ru.spi;

import com.github.dmtex.measure.format.LocaleAdapter;
import com.github.dmtex.measure.spi.MeasureFormatService;
import java.util.Locale;

/**
 * {@code MeasureFormatServiceImpl} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class MeasureFormatServiceImpl implements MeasureFormatService {

  @Override
  public LocaleAdapter getAdapter(Locale locale) {
    if ("ru".equals(locale.getLanguage())) {
      return new RuLocaleAdapter();
    }
    return null;
  }
}
