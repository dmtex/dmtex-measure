package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.system.MetricUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MetricPrefixTest {

  @Test
  void testGetSymbol() {
    assertThrows(UnsupportedOperationException.class, MetricPrefix.YOTTA::getSymbol);
  }

  @Test
  void testGetExponent() {
    assertEquals(24, MetricPrefix.YOTTA.getExponent());
  }

  @Test
  void testYotta() {
    assertEquals("yotta:meter", MetricPrefix.yotta(MetricUnits.METER).getName());
  }

  @Test
  void testZetta() {
    assertEquals("zetta:meter", MetricPrefix.zetta(MetricUnits.METER).getName());
  }

  @Test
  void testExa() {
    assertEquals("exa:meter", MetricPrefix.exa(MetricUnits.METER).getName());
  }

  @Test
  void testPeta() {
    assertEquals("peta:meter", MetricPrefix.peta(MetricUnits.METER).getName());
  }

  @Test
  void testTera() {
    assertEquals("tera:meter", MetricPrefix.tera(MetricUnits.METER).getName());
  }

  @Test
  void testGiga() {
    assertEquals("giga:meter", MetricPrefix.giga(MetricUnits.METER).getName());
  }

  @Test
  void testMega() {
    assertEquals("mega:meter", MetricPrefix.mega(MetricUnits.METER).getName());
  }

  @Test
  void testKilo() {
    assertEquals("kilo:meter", MetricPrefix.kilo(MetricUnits.METER).getName());
  }

  @Test
  void testHecto() {
    assertEquals("hecto:meter", MetricPrefix.hecto(MetricUnits.METER).getName());
  }

  @Test
  void testDeca() {
    assertEquals("deca:meter", MetricPrefix.deca(MetricUnits.METER).getName());
  }

  @Test
  void testDeci() {
    assertEquals("deci:meter", MetricPrefix.deci(MetricUnits.METER).getName());
  }

  @Test
  void testCenti() {
    assertEquals("centi:meter", MetricPrefix.centi(MetricUnits.METER).getName());
  }

  @Test
  void testMilli() {
    assertEquals("milli:meter", MetricPrefix.milli(MetricUnits.METER).getName());
  }

  @Test
  void testMicro() {
    assertEquals("micro:meter", MetricPrefix.micro(MetricUnits.METER).getName());
  }

  @Test
  void testNano() {
    assertEquals("nano:meter", MetricPrefix.nano(MetricUnits.METER).getName());
  }

  @Test
  void testPico() {
    assertEquals("pico:meter", MetricPrefix.pico(MetricUnits.METER).getName());
  }

  @Test
  void testFemto() {
    assertEquals("femto:meter", MetricPrefix.femto(MetricUnits.METER).getName());
  }

  @Test
  void testAtto() {
    assertEquals("atto:meter", MetricPrefix.atto(MetricUnits.METER).getName());
  }

  @Test
  void testZepto() {
    assertEquals("zepto:meter", MetricPrefix.zepto(MetricUnits.METER).getName());
  }

  @Test
  void testYocto() {
    assertEquals("yocto:meter", MetricPrefix.yocto(MetricUnits.METER).getName());
  }
}
