package com.github.dmtex.measure.spi;

import com.github.dmtex.math.format.CompactFormat;
import com.github.dmtex.measure.format.LocaleAdapter;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * {@code MeasureFormatService} interface is SPI for formatting and Locale support service for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public interface MeasureFormatService {

  /**
   * Provides default number format.
   *
   * @return NumberFormat instance
   */
  default NumberFormat getNumberFormat() {
    final int digits = 4;
    return new CompactFormat(digits);
  }

  /**
   * Provides adapter for given locale.
   *
   * @param locale locale
   * @return the adapter
   */
  default LocaleAdapter getAdapter(Locale locale) {
    return new DefaultLocaleAdapter();
  }

  /**
   * Default locale adapter class.
   */
  class DefaultLocaleAdapter implements LocaleAdapter {
  }
}
