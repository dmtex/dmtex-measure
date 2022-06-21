package com.github.dmtex.measure.spi;

import com.github.dmtex.measure.quantity.Quantities;
import javax.measure.Quantity;
import javax.measure.spi.FormatService;
import javax.measure.spi.QuantityFactory;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnitsService;

/**
 * {@code MeasureServiceProvider} class is default service provider for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MeasureServiceProvider extends ServiceProvider {

  private static final SystemOfUnitsService SYSTEM_OF_UNIT_SERVICE = new DefaultSystemOfUnitsService();

  private static final FormatService FORMAT_SERVICE = new DefaultFormatService();

  @Override
  public SystemOfUnitsService getSystemOfUnitsService() {
    return SYSTEM_OF_UNIT_SERVICE;
  }

  @Override
  public FormatService getFormatService() {
    return FORMAT_SERVICE;
  }

  @Override
  public <Q extends Quantity<Q>> QuantityFactory<Q> getQuantityFactory(Class<Q> quantity) {
    return Quantities.getFactory(quantity);
  }
}
