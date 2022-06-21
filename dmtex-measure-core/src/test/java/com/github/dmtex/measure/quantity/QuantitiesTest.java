package com.github.dmtex.measure.quantity;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.measure.unit.TestUnit;
import javax.measure.Quantity.Scale;
import javax.measure.quantity.Length;
import javax.measure.spi.QuantityFactory;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MeterUnits.KILOMETER_PER_HOUR;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.kilo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantitiesTest {

  @Test
  void testGetFactory() {
    QuantityFactory<Length> factory = Quantities.getFactory(Length.class);
    assertAll(
        () -> assertThrows(UnsupportedOperationException.class, () -> factory.create(1, METER, Scale.ABSOLUTE)),
        () -> assertEquals(1, factory.create(1, METER).getValue()),
        () -> assertEquals(METER, factory.create(1, METER).getUnit()),
        () -> assertEquals(METER, factory.getSystemUnit())
    );
  }

  @Test
  void testOf() {
    assertThrows(UnsupportedOperationException.class, () -> Quantities.of(1, new TestUnit<Length>()));
  }

  @Test
  void testIsZero() {
    assertAll(
        () -> assertTrue(Quantities.isZero(new LengthAmount(0, kilo(METER)))),
        () -> assertFalse(Quantities.isZero(new LengthAmount(1, METER)))
    );
  }

  @Test
  void testIsPositive() {
    assertAll(
        () -> assertTrue(Quantities.isPositive(new LengthAmount(1, kilo(METER)))),
        () -> assertFalse(Quantities.isPositive(new LengthAmount(0, METER)))
    );
  }

  @Test
  void testIsNegative() {
    assertAll(
        () -> assertTrue(Quantities.isNegative(new LengthAmount(-1, kilo(METER)))),
        () -> assertFalse(Quantities.isNegative(new LengthAmount(0, METER)))
    );
  }

  @Test
  void testToDouble() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500.0, Quantities.toDouble(length, METER));
  }

  @Test
  void testToFloat() {
    SpeedAmount speed = new SpeedAmount(1.5, METER_PER_SECOND);
    assertEquals(5.4f, Quantities.toFloat(speed, KILOMETER_PER_HOUR));
  }

  @Test
  void testToLong() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500L, Quantities.toLong(length, METER));
  }

  @Test
  void testToInt() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500, Quantities.toInt(length, METER));
  }

  @Test
  void testToRational() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(Rational.valueOf(1500), Quantities.toRational(length, METER));
  }

  @Test
  void testToBigRational() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(BigRational.valueOf(1500), Quantities.toBigRational(length, METER));
  }
}
