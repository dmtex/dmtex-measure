package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.dimension.Dimensions;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.converter.Converters.IDENTITY;
import static com.github.dmtex.measure.converter.Converters.fromFactor;
import static com.github.dmtex.measure.converter.Converters.fromOffset;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.MetricUnits.SECOND;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractUnitTest {

  @Test
  void testGetSymbol() {
    assertEquals("m", METER.getSymbol());
  }

  @Test
  void testCompatible() {
    assertAll(
        () -> assertTrue(METER.isCompatible(METER)),
        () -> assertTrue(METER.isCompatible(MetricPrefix.milli(METER))),
        () -> assertFalse(METER.isCompatible(SECOND)),
        () -> assertFalse(METER.isCompatible(new TestUnit<Length>()))
    );
  }

  @Test
  void testIsEquivalentTo() {
    assertAll(
        () -> assertTrue(METER.isEquivalentTo(METER)),
        () -> assertFalse(METER.isEquivalentTo(MetricPrefix.centi(METER)))
    );
  }

  @Test
  void testAsType() {
    assertNotNull(METER.asType(Length.class));
  }

  @Test
  void testGetConverterTo() {
    assertAll(
        () -> assertSame(IDENTITY, METER.getConverterTo(METER)),
        () -> assertEquals(fromFactor(MetricPrefix.DECA.getValue()), MetricPrefix.deca(METER).getConverterTo(METER)),
        () -> assertThrows(UnconvertibleException.class, () -> METER.getConverterTo(new TestUnit<>()))
    );
  }

  @Test
  void testGetConverterToAny() {
    assertAll(
        () -> assertThrows(IncommensurableException.class, () -> METER.getConverterToAny(SECOND)),
        () -> assertDoesNotThrow(() -> METER.getConverterToAny(METER))
    );
  }

  @Test
  void testShift() {
    assertAll(
        () -> assertEquals(fromOffset(BigDecimal.ONE), METER.shift(BigDecimal.ONE).getConverterTo(METER)),
        () -> assertEquals(fromOffset(1.0), METER.shift(1.0).getConverterTo(METER))
    );
  }

  @Test
  void testMultiply() {
    assertAll(
        () -> assertEquals(fromFactor(BigDecimal.TEN), METER.multiply(BigDecimal.TEN).getConverterTo(METER)),
        () -> assertEquals(fromFactor(10.0), METER.multiply(10.0).getConverterTo(METER)),
        () -> assertThrows(UnsupportedOperationException.class, () -> METER.multiply(new TestUnit<Length>()))
    );
  }

  @Test
  void testInverse() {
    Map<Unit<?>, Integer> expected = new HashMap<>();
    expected.put(METER, -1);
    Unit<?> unit = METER.inverse();
    assertEquals(expected, unit.getBaseUnits());
  }

  @Test
  void testDivide() {
    assertAll(
        () -> assertEquals(fromFactor(new BigDecimal("0.1")), METER.divide(BigDecimal.TEN).getConverterTo(METER)),
        () -> assertEquals(fromFactor(0.5), METER.divide(2.0).getConverterTo(METER)),
        () -> assertThrows(UnsupportedOperationException.class, () -> METER.divide(new TestUnit<Length>()))
    );
  }

  @Test
  void testRoot() {
    assertAll(
        () -> assertEquals(1, METER.pow(1).getDimension().getBaseDimensions().get(Dimensions.LENGTH)),
        () -> assertThrows(ArithmeticException.class, () -> METER.root(0)),
        () -> assertEquals(-1, METER.pow(-1).getDimension().getBaseDimensions().get(Dimensions.LENGTH))
    );
    ;
  }

  @Test
  void testPow() {
    assertEquals(Dimensions.DIMENSIONLESS, METER.pow(0).getDimension());
  }

  @Test
  void testTransform() {
    assertEquals(METER, METER.transform(IDENTITY));
  }

  @Test
  void testToString() {
    assertEquals("meter", METER.toString());
  }
}
