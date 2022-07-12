package com.github.dmtex.measure.misc.ru.spi;

import com.github.dmtex.measure.ru.spi.RuLocaleAdapterService;
import java.util.Set;

/**
 * {@code MiscRuLocaleAdapterService} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MiscRuLocaleAdapterService implements RuLocaleAdapterService {

  @Override
  public Set<String> getFeminineKeys() {
    return Set.of("barye",
        "bochka",
        "bottle",
        "calorie",
        "chain",
        "charka",
        "dessyatina",
        "dolya",
        "dram",
        "dyne",
        "eighth",
        "fathom",
        "league",
        "line",
        "mile",
        "ounce",
        "part",
        "pint",
        "point",
        "power",
        "quart",
        "quarter",
        "section",
        "span",
        "spoon",
        "ton",
        "verst");
  }

  @Override
  public Set<String> getNeuterKeys() {
    return Set.of("bucket",
        "link");
  }
}
