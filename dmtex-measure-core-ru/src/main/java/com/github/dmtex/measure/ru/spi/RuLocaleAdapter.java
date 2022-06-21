package com.github.dmtex.measure.ru.spi;

import com.github.dmtex.math.adapter.Adapters;
import com.github.dmtex.math.adapter.ArithmeticAware;
import com.github.dmtex.measure.format.LocaleAdapter;
import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.Set;

/**
 * {@code RuLocaleAdapter} class is {@link LocaleAdapter} implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class RuLocaleAdapter implements LocaleAdapter {

  private static final String PART = ".part";
  private static final String PLURAL = ".plural";

  private final Set<String> feminineNames = new HashSet<>();
  private final Set<String> neuterNames = new HashSet<>();

  /**
   * Initializes adapter.
   */
  public RuLocaleAdapter() {
    ServiceLoader.load(RuLocaleAdapterService.class).stream().map(Provider::get).forEach(service -> {
      feminineNames.addAll(service.getFeminineKeys());
      neuterNames.addAll(service.getNeuterKeys());
    });
  }

  @Override
  public String name(String name, Number number) {
    ArithmeticAware<?> adapter = Adapters.lookup(number);
    if (!adapter.isIntegral()) {
      return name + PART;
    }
    final long ten = 10;
    long value = number.longValue();
    long rem10 = value % ten;
    long rem100 = value % (ten * ten);
    final long eleven = 11;
    if (rem10 == 1 && rem100 != eleven) {
      return name;
    }
    final long five = 5;
    final long fifteen = 15;
    if (rem10 == 0 || rem10 >= five || rem100 >= eleven && rem100 < fifteen) {
      return name + PLURAL;
    }
    return name + PART;
  }

  @Override
  public String suffix(String suffix, String name, Number number) {
    ArithmeticAware<?> adapter = Adapters.lookup(number);
    if (!adapter.isIntegral()) {
      return suffix + PART + genderSuffix(name);
    }
    final long ten = 10;
    long value = number.longValue();
    long rem10 = value % ten;
    long rem100 = value % (ten * ten);
    final long eleven = 11;
    if (rem10 == 1 && rem100 != eleven) {
      return suffix + genderSuffix(name);
    }
    return suffix + PLURAL + genderSuffix(name);
  }

  private String genderSuffix(String name) {
    if (feminineNames.contains(name)) {
      return ".f";
    }
    if (neuterNames.contains(name)) {
      return ".n";
    }
    return "";
  }
}
