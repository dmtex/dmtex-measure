package com.github.dmtex.measure.en.spi;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class MeasureFormatServiceImplTest {

  @Test
  void testGetAdapter() {
    assertAll(
        () -> assertNotNull(new MeasureFormatServiceImpl().getAdapter(Locale.US)),
        () -> assertNull(new MeasureFormatServiceImpl().getAdapter(Locale.ROOT))
    );
  }
}
