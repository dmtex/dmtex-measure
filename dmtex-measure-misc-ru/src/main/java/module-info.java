module dmtex.measure.misc.ru {

  requires transitive dmtex.measure.core.ru;
  requires transitive dmtex.measure.misc;

  exports com.github.dmtex.measure.misc.ru.spi;

  uses com.github.dmtex.measure.ru.spi.RuLocaleAdapterService;
  uses com.github.dmtex.measure.spi.MeasureFormatService;
  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;

  provides com.github.dmtex.measure.ru.spi.RuLocaleAdapterService
      with com.github.dmtex.measure.misc.ru.spi.MiscRuLocaleAdapterService;
  provides com.github.dmtex.measure.spi.MeasureResourceBundleProvider
      with com.github.dmtex.measure.misc.ru.spi.MiscMeasureResourceBundleProvider;
}
