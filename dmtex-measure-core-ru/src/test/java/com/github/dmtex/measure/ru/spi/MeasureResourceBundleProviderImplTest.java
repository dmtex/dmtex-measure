package com.github.dmtex.measure.ru.spi;

import com.github.dmtex.measure.format.FullQuantityFormat;
import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureQuantityFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.quantity.Quantities;
import com.github.dmtex.measure.system.MeterUnits;
import com.github.dmtex.measure.system.MetricUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.AMPERE;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MeasureResourceBundleProviderImplTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(new Locale("ru", "RU"));
  }

  @Test
  void testFormat() {
    MeasureUnitFormat format = new MeasureUnitFormat();
    assertAll(
        () -> assertEquals("\u043C", format.format(METER)),
        () -> assertEquals("\u043A\u043C", format.format(MetricPrefix.kilo(METER))),
        () -> assertEquals("\u043A\u0433", format.format(KILOGRAM)),
        () -> assertEquals("\u043C\u00B2", format.format(SQUARE_METER)),
        () -> assertEquals("\u043C\u2044\u0441", format.format(METER_PER_SECOND))
    );
  }

  @Test
  void testFullFormat() {
    MeasureUnitFormat format = new FullUnitFormat();
    assertAll(
        () -> assertEquals("\u043C\u0435\u0442\u0440", format.format(METER)),
        () -> assertEquals("\u043A\u0438\u043B\u043E\u043C\u0435\u0442\u0440",
            format.format(MetricPrefix.kilo(METER))),
        () -> assertEquals("\u043A\u0438\u043B\u043E\u0433\u0440\u0430\u043C\u043C",
            format.format(KILOGRAM)),
        () -> assertEquals("\u043A\u0432\u0430\u0434\u0440\u0430\u0442\u043D\u044B\u0439\u202F\u043C\u0435\u0442\u0440",
            format.format(SQUARE_METER)),
        () -> assertEquals("\u043C\u0435\u0442\u0440\u202F\u0432\u202F\u0441\u0435\u043A\u0443\u043D\u0434\u0443",
            format.format(METER_PER_SECOND))
    );
  }

  @Test
  void testQuantityFormat() {
    MeasureQuantityFormat format = new FullQuantityFormat();
    assertAll(
        () -> assertEquals("1\u202F\u0430\u043C\u043F\u0435\u0440", format.format(Quantities.of(1, AMPERE))),
        () -> assertEquals("2\u202F\u0430\u043C\u043F\u0435\u0440\u0430", format.format(Quantities.of(2, AMPERE))),
        () -> assertEquals("5\u202F\u0430\u043C\u043F\u0435\u0440", format.format(Quantities.of(5, AMPERE)))
    );
  }
}
