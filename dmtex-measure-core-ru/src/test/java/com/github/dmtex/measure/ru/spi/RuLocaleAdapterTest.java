package com.github.dmtex.measure.ru.spi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.dmtex.measure.format.LocaleAdapter;
import org.junit.jupiter.api.Test;

class RuLocaleAdapterTest {

  private final LocaleAdapter adapter = new RuLocaleAdapter();

  @Test
  void testNameSingle() {
    String name = "name";
    assertEquals(name, adapter.name(name, 1));
  }

  @Test
  void testNamePart() {
    assertEquals("name.part", adapter.name("name",1.5));
  }

  @Test
  void testNamePlural() {
    assertEquals("name.part", adapter.name("name",2));
  }

  @Test
  void testNamePlural22() {
    assertEquals("name.part", adapter.name("name",22));
  }

  @Test
  void testNamePlural5() {
    assertEquals("name.plural", adapter.name("name",5));
  }

  @Test
  void testNamePlural11() {
    assertEquals("name.plural", adapter.name("name",11));
  }

  @Test
  void testNamePlural50() {
    assertEquals("name.plural", adapter.name("name",50));
  }

  @Test
  void testSuffixSingle() {
    String name = "suffix";
    assertEquals(name, adapter.suffix(name, "name", 1));
  }

  @Test
  void testSuffixPart() {
    assertEquals("suffix.part", adapter.suffix("suffix","name", 1.5));
  }

  @Test
  void testSuffixPlural() {
    assertEquals("suffix.plural", adapter.suffix("suffix","name", 2));
  }

  @Test
  void testSuffixPlural22() {
    assertEquals("suffix.plural", adapter.suffix("suffix","name", 22));
  }

  @Test
  void testSuffixPlural5() {
    assertEquals("suffix.plural", adapter.suffix("suffix","name", 5));
  }

  @Test
  void testSuffixPlural11() {
    assertEquals("suffix.plural", adapter.suffix("suffix","name", 11));
  }

  @Test
  void testSuffixPlural50() {
    assertEquals("suffix.plural", adapter.suffix("suffix","name", 50));
  }

  @Test
  void testSuffixFeminineGender() {
    String name = "suffix";
    assertEquals(name + ".f", adapter.suffix(name, "second", 1));
  }
}
