package com.github.dmtex.measure.misc.ru.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.misc.ApothecariesUnits;
import com.github.dmtex.measure.misc.ImperialUnits;
import com.github.dmtex.measure.misc.RussianUnits;
import com.github.dmtex.measure.misc.TroyUnits;
import com.github.dmtex.measure.misc.UsCustomaryUnits;
import com.github.dmtex.measure.system.MetricUnits;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MiscMeasureResourceBundleProviderTest {

  @Test
  void testFormat() {
    Locale.setDefault(new Locale("ru", "RU"));
    MeasureUnitFormat format = new MeasureUnitFormat();

    assertAll(
        () -> assertEquals("\u0434\u043C", format.format(ImperialUnits.INCH)),
        () -> assertEquals("\u0434\u043C", format.format(RussianUnits.INCH)),
        () -> assertEquals("\u0434\u043C", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("\u0442\u0440.\u0444\u043D", format.format(TroyUnits.POUND)),
        () -> assertEquals("\u0433\u0440.", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("\u043C", format.format(MetricUnits.METER)),
        () -> assertEquals("\u043A\u0433", format.format(MetricUnits.KILOGRAM))
    );
  }

  @Test
  void testFullFormat() {
    Locale.setDefault(new Locale("ru", "RU"));
    MeasureUnitFormat format = new FullUnitFormat();

    assertAll(
        () -> assertEquals("\u0434\u044E\u0439\u043C", format.format(ImperialUnits.INCH)),
        () -> assertEquals("\u0434\u044E\u0439\u043C", format.format(RussianUnits.INCH)),
        () -> assertEquals("\u0434\u044E\u0439\u043C", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("\u0442\u0440\u043E\u0439\u0441\u043A\u0438\u0439\u202F\u0444\u0443\u043D\u0442",
            format.format(TroyUnits.POUND)),
        () -> assertEquals("\u0433\u0440\u0430\u043D", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("\u0432\u0435\u0434\u0440\u043E", format.format(RussianUnits.DRY_BUCKET)),
        () -> assertEquals("\u043C\u0435\u0442\u0440", format.format(MetricUnits.METER)),
        () -> assertEquals("\u043A\u0438\u043B\u043E\u0433\u0440\u0430\u043C\u043C",
            format.format(MetricUnits.KILOGRAM))
    );
  }
}
