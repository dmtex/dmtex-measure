package com.github.dmtex.measure.spi;

import java.util.ServiceLoader;
import javax.measure.quantity.Length;
import javax.measure.spi.FormatService;
import javax.measure.spi.FormatService.FormatType;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnitsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MeasureServiceProviderTest {

  private final ServiceProvider service = ServiceLoader.load(ServiceProvider.class).findFirst().orElse(null);

  @Test
  void testInstance() {
    assertNotNull(service);
  }

  @Test
  void testGetSystemOfUnitsService() {
    SystemOfUnitsService systemOfUnitsService = service.getSystemOfUnitsService();
    assertAll(
        () -> assertNotNull(systemOfUnitsService),
        () -> assertNotNull(systemOfUnitsService.getSystemOfUnits("SI")),
        () -> assertNull(systemOfUnitsService.getSystemOfUnits("Unknown")),
        () -> assertEquals(3, systemOfUnitsService.getAvailableSystemsOfUnits().size())
    );
  }

  @Test
  void testGetFormatService() {
    FormatService formatService = service.getFormatService();
    assertAll(
        () -> assertNotNull(formatService),
        () -> assertNotNull(formatService.getQuantityFormat()),
        () -> assertNotNull(formatService.getQuantityFormat("full")),
        () -> assertNotNull(formatService.getUnitFormat()),
        () -> assertNotNull(formatService.getUnitFormat("full")),
        () -> assertNotNull(formatService.getUnitFormat("full", "alt")),
        () -> assertNotNull(formatService.getUnitFormat("full", "")),
        () -> assertNotNull(formatService.getUnitFormat("full", null)),
        () -> assertNotNull(formatService.getUnitFormat("default"))
    );
  }

  @Test
  void testGetFormatServiceGetAvailableFormatNamesTyped() {
    assertEquals(2, service.getFormatService().getAvailableFormatNames(FormatType.UNIT_FORMAT).size());
  }

  @Test
  void testGetQuantityFactory() {
    assertNotNull(service.getQuantityFactory(Length.class));
  }
}
