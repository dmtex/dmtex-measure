package com.github.dmtex.measure.misc.spi;

import java.util.ServiceLoader;
import javax.measure.spi.FormatService.FormatType;
import javax.measure.spi.ServiceProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MiscServiceProviderTest {

  private final ServiceProvider service = ServiceLoader.load(ServiceProvider.class).findFirst().orElseThrow();

  @Test
  void testInstance() {
    assertNotNull(service);
  }

  @Test
  void testGetSystemOfUnitsService() {
    assertNotNull(service.getSystemOfUnitsService());
  }

  @Test
  void testGetSystemOfUnitsDefault() {
    assertNotNull(service.getSystemOfUnitsService().getSystemOfUnits("SI"));
  }

  @Test
  void testGetSystemOfUnitsNull() {
    assertNull(service.getSystemOfUnitsService().getSystemOfUnits(null));
  }

  @Test
  void testGetUnitFormatFull() {
    assertNotNull(service.getFormatService().getUnitFormat("full"));
  }

  @Test
  void testGetUnitFormatAlt() {
    assertNotNull(service.getFormatService().getUnitFormat("alt"));
  }

  @Test
  void testGetUnitFormatDefault() {
    assertNotNull(service.getFormatService().getUnitFormat(""));
  }

  @Test
  void testGetAvailableFormatNames() {
    assertNotNull(service.getFormatService().getAvailableFormatNames(FormatType.QUANTITY_FORMAT));
  }
}
