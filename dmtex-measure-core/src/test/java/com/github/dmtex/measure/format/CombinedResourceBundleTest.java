package com.github.dmtex.measure.format;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CombinedResourceBundleTest {

  private final CombinedResourceBundle combinedResourceBundle  = new CombinedResourceBundle(List.of(
      ResourceBundle.getBundle("MeasureUnitFormat_unit"),
      ResourceBundle.getBundle("FullUnitFormat_unit")
  ));

  @Test
  void testHandleGet() {
    assertAll(
        () -> assertFalse(combinedResourceBundle.containsKey("x")),
        () -> assertEquals("m", combinedResourceBundle.getString("unit.meter"))
    );
  }

  @Test
  void testKeys() {
    Enumeration<String> keys = combinedResourceBundle.getKeys();
    List<String> actual = new ArrayList<>();
    keys.asIterator().forEachRemaining(actual::add);
    assertEquals(166, actual.size());
  }
}
