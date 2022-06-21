module dmtex.measure.core.ru {

  requires dmtex.math.adapter;
  requires transitive dmtex.measure.core;
  requires org.apache.logging.log4j;

  exports com.github.dmtex.measure.ru.spi;

  uses com.github.dmtex.measure.ru.spi.RuLocaleAdapterService;
  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
  uses com.github.dmtex.measure.spi.MeasureFormatService;

  provides com.github.dmtex.measure.ru.spi.RuLocaleAdapterService
      with com.github.dmtex.measure.ru.spi.DefaultRuLocaleAdapterService;
  provides com.github.dmtex.measure.spi.MeasureResourceBundleProvider
      with com.github.dmtex.measure.ru.spi.MeasureResourceBundleProviderImpl;
  provides com.github.dmtex.measure.spi.MeasureFormatService
      with com.github.dmtex.measure.ru.spi.MeasureFormatServiceImpl;
}
