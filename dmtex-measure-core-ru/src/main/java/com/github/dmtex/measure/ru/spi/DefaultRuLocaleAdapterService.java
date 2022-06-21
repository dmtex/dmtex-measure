package com.github.dmtex.measure.ru.spi;

import java.util.Set;

/**
 * {@code DefaultRuLocaleAdapterService} class is default implementation of {@link RuLocaleAdapterService}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class DefaultRuLocaleAdapterService implements RuLocaleAdapterService {

  @Override
  public Set<String> getFeminineKeys() {
    return Set.of("candela",
        "minute",
        "minute_angle",
        "second",
        "second_angle",
        "tonne",
        "unit",
        "week");
  }

  @Override
  public Set<String> getNeuterKeys() {
    return Set.of();
  }
}
