package com.github.dmtex.measure.format;

import java.util.Locale;
import java.util.spi.ResourceBundleProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class UnitFormatResourceBundleProviderTest {

  private final ResourceBundleProvider provider = new UnitFormatResourceBundleProvider<>(MeasureUnitFormat.class,
      Locale.ROOT::equals);

  @Test
  void testGetBundle() {
    assertAll(
        () -> assertNull(provider.getBundle("MeasureUnitFormat", Locale.US)),
        () -> assertNull(provider.getBundle(MeasureUnitFormat.class.getName(), Locale.US)),
        () -> assertNull(provider.getBundle("MeasureUnitFormat", Locale.ROOT)),
        () -> assertNotNull(provider.getBundle(MeasureUnitFormat.class.getName(), Locale.ROOT))
    );
  }
}
