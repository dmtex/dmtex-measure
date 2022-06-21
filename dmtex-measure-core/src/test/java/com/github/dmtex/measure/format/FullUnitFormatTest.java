package com.github.dmtex.measure.format;

import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND_SQUARED;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.MetricPrefix.kilo;
import static com.github.dmtex.measure.unit.MetricPrefix.milli;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FullUnitFormatTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormat() {
    FullUnitFormat fullUnitFormat = new FullUnitFormat();
    assertAll(
        () -> assertEquals("meter", fullUnitFormat.format(METER)),
        () -> assertEquals("kilometer", fullUnitFormat.format(kilo(METER))),
        () -> assertEquals("meter\u202Fper\u202Fsecond", fullUnitFormat.format(METER_PER_SECOND)),
        () -> assertEquals("meter\u202Fper\u202Fsecond\u202Fsquared",
            fullUnitFormat.format(METER_PER_SECOND_SQUARED)),
        () -> assertEquals("meter\u202Fper\u202Fmillisecond", fullUnitFormat.format(METER.divide(milli(SECOND)))),
        () -> assertEquals("[unit.unknown]", fullUnitFormat.format(METER.alternate("unknown"))),
        () -> assertEquals("[prefix.unknown]meter", fullUnitFormat.format(METER.alternate("unknown:meter"))),
        () -> assertEquals("meter\u2011meter", fullUnitFormat.format(METER.multiply(METER))),
        () -> assertEquals("?/?", new FullUnitFormat().format(METER.divide(METER).divide(METER)))
    );
  }
}
