package com.github.dmtex.measure.misc.en.spi;

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
    Locale.setDefault(Locale.US);
    MeasureUnitFormat format = new FullUnitFormat();

    assertAll(
        () -> assertEquals("inch", format.format(ImperialUnits.INCH)),
        () -> assertEquals("inch", format.format(RussianUnits.INCH)),
        () -> assertEquals("inch", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("troy\u202Fpound", format.format(TroyUnits.POUND)),
        () -> assertEquals("grain", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("meter", format.format(MetricUnits.METER)),
        () -> assertEquals("kilogram", format.format(MetricUnits.KILOGRAM))
    );
  }

  @Test
  void testEnGbFormat() {
    Locale.setDefault(Locale.UK);
    MeasureUnitFormat format = new FullUnitFormat();

    assertAll(
        () -> assertEquals("inch", format.format(ImperialUnits.INCH)),
        () -> assertEquals("inch", format.format(RussianUnits.INCH)),
        () -> assertEquals("inch", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("troy\u202Fpound", format.format(TroyUnits.POUND)),
        () -> assertEquals("grain", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("metre", format.format(MetricUnits.METER)),
        () -> assertEquals("kilogram", format.format(MetricUnits.KILOGRAM))
    );
  }
}
