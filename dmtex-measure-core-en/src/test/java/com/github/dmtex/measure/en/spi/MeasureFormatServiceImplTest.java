package com.github.dmtex.measure.en.spi;

import java.util.Locale;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MeasureFormatServiceImplTest {

  @Test
  void testGetAdapter() {
    assertAll(
        () -> assertNotNull(new MeasureFormatServiceImpl().getAdapter(Locale.US)),
        () -> assertNull(new MeasureFormatServiceImpl().getAdapter(Locale.ROOT))
    );
  }
}
