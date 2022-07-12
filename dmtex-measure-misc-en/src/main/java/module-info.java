module dmtex.measure.misc.en {

  requires transitive dmtex.measure.core.en;
  requires transitive dmtex.measure.misc;

  exports com.github.dmtex.measure.misc.en.spi;

  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;

  provides com.github.dmtex.measure.spi.MeasureResourceBundleProvider
      with com.github.dmtex.measure.misc.en.spi.MiscMeasureResourceBundleProvider;
}
