package com.github.dmtex.measure.misc.spi;

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
    MeasureUnitFormat format = new MeasureUnitFormat();

    assertAll(
        () -> assertEquals("in", format.format(ImperialUnits.INCH)),
        () -> assertEquals("in", format.format(RussianUnits.INCH)),
        () -> assertEquals("in", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("lb\u202Ft", format.format(TroyUnits.POUND)),
        () -> assertEquals("gr", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("m", format.format(MetricUnits.METER)),
        () -> assertEquals("kg", format.format(MetricUnits.KILOGRAM))
    );
  }

  @Test
  void testFullFormat() {
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
  void testAltFormat() {
    Locale.setDefault(new Locale("en", "US", "alt"));
    MeasureUnitFormat format = new MeasureUnitFormat();

    assertAll(
        () -> assertEquals("\u2033", format.format(ImperialUnits.INCH)),
        () -> assertEquals("\u2033", format.format(RussianUnits.INCH)),
        () -> assertEquals("\u2033", format.format(UsCustomaryUnits.INCH)),
        () -> assertEquals("lb\u202Ft", format.format(TroyUnits.POUND)),
        () -> assertEquals("gr", format.format(ApothecariesUnits.GRAIN)),
        () -> assertEquals("m", format.format(MetricUnits.METER)),
        () -> assertEquals("kg", format.format(MetricUnits.KILOGRAM))
    );
  }
}
