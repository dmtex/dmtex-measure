module dmtex.measure.core {

  requires dmtex.math.adapter;
  requires dmtex.math.format;
  requires dmtex.math.rational;
  requires transitive java.measure;
  requires si.uom.quantity;

  exports com.github.dmtex.measure.annotation;
  exports com.github.dmtex.measure.converter;
  exports com.github.dmtex.measure.dimension;
  exports com.github.dmtex.measure.format;
  exports com.github.dmtex.measure.quantity;
  exports com.github.dmtex.measure.spi;
  exports com.github.dmtex.measure.system;
  exports com.github.dmtex.measure.unit;

  uses com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
  uses com.github.dmtex.measure.format.spi.FullUnitFormatProvider;
  uses com.github.dmtex.measure.format.spi.MeasureUnitFormatProvider;
  uses com.github.dmtex.measure.spi.MeasureFormatService;
  uses javax.measure.spi.ServiceProvider;

  provides com.github.dmtex.measure.format.spi.FullUnitFormatProvider
      with com.github.dmtex.measure.format.spi.FullUnitFormatResourceBundleProvider;
  provides com.github.dmtex.measure.format.spi.MeasureUnitFormatProvider
      with com.github.dmtex.measure.format.spi.MeasureUnitFormatResourceBundleProvider;
  provides javax.measure.spi.ServiceProvider
      with com.github.dmtex.measure.spi.MeasureServiceProvider;
}
