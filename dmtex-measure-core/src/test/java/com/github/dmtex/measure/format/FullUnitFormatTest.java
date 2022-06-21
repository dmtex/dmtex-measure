package com.github.dmtex.measure.format;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND_SQUARED;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static com.github.dmtex.measure.unit.MetricPrefix.kilo;
import static com.github.dmtex.measure.unit.MetricPrefix.milli;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FullUnitFormatTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormatMeter() {
    assertEquals("meter", new FullUnitFormat().format(METER));
  }

  @Test
  void testFormatKilometer() {
    assertEquals("kilometer", new FullUnitFormat().format(kilo(METER)));
  }

  @Test
  void testFormatMeterPerSecond() {
    assertEquals("meter\u202Fper\u202Fsecond", new FullUnitFormat().format(METER_PER_SECOND));
  }

  @Test
  void testFormatMeterPerSecondSquared() {
    assertEquals("meter\u202Fper\u202Fsecond\u202Fsquared", new FullUnitFormat().format(METER_PER_SECOND_SQUARED));
  }

  @Test
  void testFormatMeterPerMilliSecond() {
    assertEquals("meter\u202Fper\u202Fmillisecond", new FullUnitFormat().format(METER.divide(milli(SECOND))));
  }

  @Test
  void testFormatUnknown() {
    assertEquals("[unit.unknown]", new FullUnitFormat().format(METER.alternate("unknown")));
  }

  @Test
  void testFormatUnknownPrefix() {
    assertEquals("[prefix.unknown]meter", new FullUnitFormat().format(METER.alternate("unknown:meter")));
  }

  @Test
  void testFormatProduct() {
    assertEquals("meter\u2011meter", new FullUnitFormat().format(METER.multiply(METER)));
  }

  @Test
  void testFormatFraction() {
    assertEquals("?/?", new FullUnitFormat().format(METER.divide(METER).divide(METER)));
  }
}
