package com.github.dmtex.measure.ru.spi;

import java.util.Set;

/**
 * {@code RuLocaleAdapterService} interface is SPI for data needed for Locale Adapters.
 * implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public interface RuLocaleAdapterService {

  /**
   * Provides keys of feminines.
   *
   * @return keys
   */
  Set<String> getFeminineKeys();

  /**
   * Provides keys of neuters.
   *
   * @return keys
   */
  Set<String> getNeuterKeys();
}
