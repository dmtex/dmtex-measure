package com.github.dmtex.measure.en.spi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.dmtex.measure.format.LocaleAdapter;
import org.junit.jupiter.api.Test;

class LocaleAdapterImplTest {

  private final LocaleAdapter adapter = new LocaleAdapterImpl();

  @Test
  void testNameHalf() {
    assertEquals("name", adapter.name("name", 0.5));
  }

  @Test
  void testNameSingle() {
    assertEquals("name", adapter.name("name", 1));
  }

  @Test
  void testNamePlural() {
    assertEquals("name.plural", adapter.name("name", 2));
  }

  @Test
  void testSuffixHalf() {
    assertEquals("suffix", adapter.suffix("suffix", "name", 0.5));
  }

  @Test
  void testSuffixSingle() {
    assertEquals("suffix", adapter.suffix("suffix", "name", 1));
  }

  @Test
  void testSuffixPlural() {
    assertEquals("suffix", adapter.suffix("suffix", "name", 2));
  }
}
