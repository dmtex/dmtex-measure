package com.github.dmtex.measure.format;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.ATTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.dmtex.measure.unit.MetricPrefix;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.Test;

class UnitNameHelperTest {

  @Test
  void testPrefix() {
    String name = UnitNameHelper.prefix(ATTO, METER);
    assertEquals("atto:meter", name);
  }

  @Test
  void testPrefixFailureCase1() {
    assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, MetricPrefix.atto(METER)));
  }

  @Test
  void testPrefixFailureCase2() {
    assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, METER_PER_SECOND));
  }

  @Test
  void testPrefixFailureCase3() {
    assertThrows(MeasurementException.class, () -> UnitNameHelper.prefix(ATTO, METER.multiply(METER)));
  }

  @Test
  void testMultiplyCase1() {
    String name = UnitNameHelper.multiply(METER, METER);
    assertEquals("meter*meter", name);
  }

  @Test
  void testMultiplyCase2() {
    String name = UnitNameHelper.multiply(METER_PER_SECOND, METER);
    assertEquals("meter*meter/second", name);
  }

  @Test
  void testMultiplyCase3() {
    String name = UnitNameHelper.multiply(METER_PER_SECOND, METER_PER_SECOND);
    assertEquals("meter*meter/second*second", name);
  }

  @Test
  void testDivideCase1() {
    String name = UnitNameHelper.divide(METER, METER);
    assertEquals("meter/meter", name);
  }

  @Test
  void testDivideCase2() {
    String name = UnitNameHelper.divide(METER_PER_SECOND, METER);
    assertEquals("meter/second*meter", name);
  }

  @Test
  void testDivideCase3() {
    String name = UnitNameHelper.divide(METER, METER_PER_SECOND);
    assertEquals("meter*second/meter", name);
  }

  @Test
  void testDivideCase4() {
    String name = UnitNameHelper.divide(METER_PER_SECOND, METER_PER_SECOND);
    assertEquals("meter*second/second*meter", name);
  }

  @Test
  void testPowCase1() {
    String name = UnitNameHelper.pow(METER, 2);
    assertEquals("meter^2", name);
  }

  @Test
  void testPowCase2() {
    String name = UnitNameHelper.pow(METER.multiply(METER), 2);
    assertEquals("meter^2*meter^2", name);
  }

  @Test
  void testPowCase3() {
    String name = UnitNameHelper.pow(METER_PER_SECOND, 2);
    assertEquals("meter^2/second^2", name);
  }

  @Test
  void testPowCase4() {
    String name = UnitNameHelper.pow(SQUARE_METER, 2);
    assertEquals("meter^4", name);
  }

  @Test
  void testPowCaseFailure() {
    assertThrows(MeasurementException.class, () -> UnitNameHelper.pow(METER.alternate("m^m"), 2));
  }
}
