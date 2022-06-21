package com.github.dmtex.measure.format;

import com.github.dmtex.measure.unit.MetricPrefix;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.ATTO;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitNameHelperTest {

  @Test
  void testPrefix() {
    assertAll(
        () -> assertEquals("atto:meter", UnitNameHelper.prefix(ATTO, METER)),
        () -> assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, MetricPrefix.atto(METER))),
        () -> assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, METER_PER_SECOND)),
        () -> assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, METER.multiply(METER)))
    );
  }

  @Test
  void testMultiply() {
    assertAll(
        () -> assertEquals("meter*meter", UnitNameHelper.multiply(METER, METER)),
        () -> assertEquals("meter*meter/second", UnitNameHelper.multiply(METER_PER_SECOND, METER)),
        () -> assertEquals("meter*meter/second*second", UnitNameHelper.multiply(METER_PER_SECOND, METER_PER_SECOND))
    );
  }

  @Test
  void testDivide() {
    assertAll(
        () -> assertEquals("meter/meter", UnitNameHelper.divide(METER, METER)),
        () -> assertEquals("meter/second*meter", UnitNameHelper.divide(METER_PER_SECOND, METER)),
        () -> assertEquals("meter*second/meter", UnitNameHelper.divide(METER, METER_PER_SECOND)),
        () -> assertEquals("meter*second/second*meter", UnitNameHelper.divide(METER_PER_SECOND, METER_PER_SECOND))
    );
  }

  @Test
  void testPow() {
    assertAll(
        () -> assertEquals("meter^2", UnitNameHelper.pow(METER, 2)),
        () -> assertEquals("meter^2*meter^2", UnitNameHelper.pow(METER.multiply(METER), 2)),
        () -> assertEquals("meter^2/second^2", UnitNameHelper.pow(METER_PER_SECOND, 2)),
        () -> assertEquals("meter^4", UnitNameHelper.pow(SQUARE_METER, 2)),
        () -> assertThrows(MeasurementException.class, () -> UnitNameHelper.pow(METER.alternate("m^m"), 2))
    );
  }
}
