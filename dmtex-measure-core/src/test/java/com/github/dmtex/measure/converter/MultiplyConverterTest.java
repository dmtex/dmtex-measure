package com.github.dmtex.measure.converter;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.converter.Converters.IDENTITY;
import static com.github.dmtex.measure.converter.Converters.fromFactor;
import static com.github.dmtex.measure.converter.Converters.fromOffset;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiplyConverterTest {

  @Test
  void testCreateFailure() {
    assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> fromFactor(null)),
        () -> assertThrows(IllegalArgumentException.class, () -> fromFactor(0))
    );
  }

  @Test
  void testIdentity() {
    assertEquals(IDENTITY, fromFactor(1));
  }

  @Test
  void testNotIdentity() {
    assertFalse(fromFactor(2).isIdentity());
  }

  @Test
  void testLinear() {
    assertTrue(fromFactor(2).isLinear());
  }

  @Test
  void testInverse() {
    UnitConverter converter = fromFactor(2).inverse();
    assertEquals(1.0, converter.convert(2.0));
  }

  @Test
  void testConvertNumber() {
    UnitConverter converter = fromFactor(2);
    assertEquals(BigDecimal.valueOf(2.0), converter.convert(BigDecimal.ONE));
  }

  @Test
  void testConvertDouble() {
    UnitConverter converter = fromFactor(2);
    assertEquals(2.0, converter.convert(1.0));
  }

  @Test
  void testConcatenate() {
    UnitConverter converter = fromFactor(2);
    assertAll(
        () -> assertEquals(4.0, converter.concatenate(fromFactor(2)).convert(1.0)),
        () -> assertEquals(IDENTITY, converter.concatenate(fromFactor(0.5))),
        () -> assertEquals(2.0, converter.concatenate(IDENTITY).convert(1.0)),
        () -> assertEquals(4.0, converter.concatenate(fromOffset(1)).convert(1.0))
    );
  }

  @Test
  void testConversionSteps() {
    List<? extends UnitConverter> steps = fromFactor(2).getConversionSteps();
    assertEquals(Collections.singletonList(fromFactor(2)), steps);
  }

  @Test
  void testToString() {
    assertEquals("MultiplyConverter(2)", fromFactor(2).toString());
  }

  @Test
  void testEquals() {
    UnitConverter converter = fromFactor(2);
    assertAll(
        () -> assertEquals(converter, converter),
        () -> assertNotEquals(converter, null),
        () -> assertNotEquals(fromFactor(2), fromOffset(1))
    );
  }
}
