import com.github.dmtex.measure.en.spi.MeasureFormatServiceImpl;
import com.github.dmtex.measure.spi.MeasureFormatService;

module dmtex.measure.core.en {

  requires transitive dmtex.measure.core;

  exports com.github.dmtex.measure.en.spi;

  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
  uses MeasureFormatService;

  provides com.github.dmtex.measure.spi.MeasureResourceBundleProvider
      with com.github.dmtex.measure.en.spi.MeasureResourceBundleProviderImpl;
  provides MeasureFormatService
      with MeasureFormatServiceImpl;
}
