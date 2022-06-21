package com.github.dmtex.measure.ru.spi;

import com.github.dmtex.measure.format.LocaleAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RuLocaleAdapterTest {

  private final LocaleAdapter adapter = new RuLocaleAdapter();

  @Test
  void testName() {
    String name = "name";
    assertAll(
        () -> assertEquals(name, adapter.name(name, 1)),
        () -> assertEquals("name.part", adapter.name(name, 1.5)),
        () -> assertEquals("name.part", adapter.name(name, 2)),
        () -> assertEquals("name.part", adapter.name(name, 22)),
        () -> assertEquals("name.plural", adapter.name(name, 5)),
        () -> assertEquals("name.plural", adapter.name(name, 11)),
        () -> assertEquals("name.plural", adapter.name(name, 50))
    );
  }

  @Test
  void testSuffixSingle() {
    String suffix = "suffix";
    assertAll(
        () -> assertEquals(suffix, adapter.suffix(suffix, "name", 1)),
        () -> assertEquals("suffix.part", adapter.suffix(suffix, "name", 1.5)),
        () -> assertEquals("suffix.plural", adapter.suffix(suffix, "name", 2)),
        () -> assertEquals("suffix.plural", adapter.suffix(suffix, "name", 22)),
        () -> assertEquals("suffix.plural", adapter.suffix(suffix, "name", 5)),
        () -> assertEquals("suffix.plural", adapter.suffix(suffix, "name", 11)),
        () -> assertEquals("suffix.plural", adapter.suffix(suffix, "name", 50)),
        () -> assertEquals(suffix + ".f", adapter.suffix(suffix, "second", 1))
    );
  }
}
