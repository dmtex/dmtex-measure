package com.github.dmtex.measure.unit;

import com.github.dmtex.math.rational.BigRational;
import java.util.HashMap;
import java.util.Map;
import javax.measure.Unit;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.converter.Converters.IDENTITY;
import static com.github.dmtex.measure.converter.Converters.fromFactor;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MiscUnits.CELSIUS;
import static com.github.dmtex.measure.unit.MetricPrefix.nano;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductUnitTest {

  @Test
  void testGetBaseUnits() {
    Map<Unit<?>, Integer> expected = new HashMap<>();
    expected.put(METER, 2);
    assertEquals(expected, SQUARE_METER.getBaseUnits());
  }

  @Test
  void testToSystemUnit() {
    assertEquals(SQUARE_METER.getBaseUnits(), SQUARE_METER.toSystemUnit().getBaseUnits());
  }

  @Test
  void testGetSystemConverter() {
    assertAll(
        () -> assertSame(IDENTITY, SQUARE_METER.getSystemConverter()),
        () -> assertEquals(fromFactor(new BigRational(1, 1000000000)), nano(METER).getSystemConverter()),
        () -> assertThrows(UnsupportedOperationException.class, () -> CELSIUS.multiply(CELSIUS).getSystemConverter()),
        () -> assertThrows(UnsupportedOperationException.class, () -> METER.root(2).getSystemConverter()),
        () -> assertEquals(IDENTITY, METER.pow(-1).getSystemConverter())
    );
  }
}
