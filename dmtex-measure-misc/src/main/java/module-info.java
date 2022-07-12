module dmtex.measure.misc {

  requires dmtex.math.rational;
  requires transitive dmtex.measure.core;
  requires si.uom.quantity;
  requires systems.uom.quantity;

  exports com.github.dmtex.measure.misc;
  exports com.github.dmtex.measure.misc.spi;

  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
  uses javax.measure.spi.ServiceProvider;

  provides com.github.dmtex.measure.spi.MeasureResourceBundleProvider
      with com.github.dmtex.measure.misc.spi.MiscMeasureResourceBundleProvider;
  provides javax.measure.spi.ServiceProvider
      with com.github.dmtex.measure.misc.spi.MiscServiceProvider;
}
