package com.github.dmtex.measure.ru.spi;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.system.MeterUnits;
import com.github.dmtex.measure.system.MetricUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class MeasureResourceBundleProviderImplTest {

  @Test
  void testFormat() {
    Locale.setDefault(new Locale("ru", "RU"));
    MeasureUnitFormat format = new MeasureUnitFormat();
    assertAll(
        () -> assertEquals("\u043C", format.format(MetricUnits.METER)),
        () -> assertEquals("\u043A\u043C", format.format(MetricPrefix.kilo(MetricUnits.METER))),
        () -> assertEquals("\u043A\u0433", format.format(MetricUnits.KILOGRAM)),
        () -> assertEquals("\u043C\u00B2", format.format(MeterUnits.SQUARE_METER)),
        () -> assertEquals("\u043C\u2044\u0441", format.format(MeterUnits.METER_PER_SECOND))
    );
  }

  @Test
  void testFullFormat() {
    Locale.setDefault(new Locale("ru", "RU"));
    MeasureUnitFormat format = new FullUnitFormat();
    assertAll(
        () -> assertEquals("\u043C\u0435\u0442\u0440", format.format(MetricUnits.METER)),
        () -> assertEquals("\u043A\u0438\u043B\u043E\u043C\u0435\u0442\u0440",
            format.format(MetricPrefix.kilo(MetricUnits.METER))),
        () -> assertEquals("\u043A\u0438\u043B\u043E\u0433\u0440\u0430\u043C\u043C",
            format.format(MetricUnits.KILOGRAM)),
        () -> assertEquals("\u043A\u0432\u0430\u0434\u0440\u0430\u0442\u043D\u044B\u0439\u202F\u043C\u0435\u0442\u0440",
            format.format(MeterUnits.SQUARE_METER)),
        () -> assertEquals("\u043C\u0435\u0442\u0440\u202F\u0432\u202F\u0441\u0435\u043A\u0443\u043D\u0434\u0443",
            format.format(MeterUnits.METER_PER_SECOND))
    );
  }
}
