package com.github.dmtex.measure.en.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.system.MeterUnits;
import com.github.dmtex.measure.system.MetricUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MeasureResourceBundleProviderImplTest {

  private final MeasureUnitFormat format = new FullUnitFormat();

  @Test
  void testEnLocale() {
    Locale.setDefault(Locale.US);
    assertAll(
        () -> assertEquals("meter", format.format(MetricUnits.METER)),
        () -> assertEquals("kilometer", format.format(MetricPrefix.kilo(MetricUnits.METER))),
        () -> assertEquals("kilogram", format.format(MetricUnits.KILOGRAM)),
        () -> assertEquals("square\u202Fmeter", format.format(MeterUnits.SQUARE_METER)),
        () -> assertEquals("meter\u202Fper\u202Fsecond", format.format(MeterUnits.METER_PER_SECOND))
    );
  }

  @Test
  void testEnGbLocale() {
    Locale.setDefault(Locale.UK);
    assertAll(
        () -> assertEquals("metre", format.format(MetricUnits.METER)),
        () -> assertEquals("kilometre", format.format(MetricPrefix.kilo(MetricUnits.METER))),
        () -> assertEquals("kilogram", format.format(MetricUnits.KILOGRAM)),
        () -> assertEquals("square\u202Fmetre", format.format(MeterUnits.SQUARE_METER)),
        () -> assertEquals("metre\u202Fper\u202Fsecond", format.format(MeterUnits.METER_PER_SECOND))
    );
  }
}
