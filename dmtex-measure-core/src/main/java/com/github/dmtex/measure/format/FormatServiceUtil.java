package com.github.dmtex.measure.format;

import com.github.dmtex.measure.spi.MeasureFormatService;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

final class FormatServiceUtil {

  private static final ServiceLoader<MeasureFormatService> SERVICES = ServiceLoader.load(MeasureFormatService.class);

  private FormatServiceUtil() {
  }

  static NumberFormat getNumberFormat() {
    return SERVICES.stream().map(Provider::get)
        .map(MeasureFormatService::getNumberFormat)
        .findFirst()
        .orElseGet(() -> getDefaultService().getNumberFormat());
  }

  static LocaleAdapter getAdapter(Locale locale) {
    return SERVICES.stream().map(Provider::get)
        .map(s -> s.getAdapter(locale))
        .filter(Objects::nonNull)
        .findFirst()
        .orElseGet(() -> getDefaultService().getAdapter(locale));
  }

  private static MeasureFormatService getDefaultService() {
    return new MeasureFormatService() {
    };
  }
}
