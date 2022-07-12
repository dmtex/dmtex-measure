package com.github.dmtex.measure.misc.ru.spi;

import com.github.dmtex.measure.spi.MeasureFormatService;
import java.util.Locale;
import java.util.ServiceLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MiscRuLocaleAdapterServiceTest {

  private final MeasureFormatService service = ServiceLoader.load(MeasureFormatService.class).findFirst().orElseThrow();

  @Test
  void testInstance() {
    assertAll(
        () -> assertNotNull(service),
        () -> assertNotNull(service.getAdapter(new Locale("ru", "RU"))),
        () -> assertNull(service.getAdapter(Locale.US))
    );
  }
}
