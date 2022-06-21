package com.github.dmtex.measure.converter;

import com.github.dmtex.math.rational.Rational;
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

class AddConverterTest {

  @Test
  void testCreateFailure() {
    assertThrows(IllegalArgumentException.class, () -> fromOffset(null));
  }

  @Test
  void testIdentity() {
    assertEquals(IDENTITY, fromOffset(0));
  }

  @Test
  void testNotIdentity() {
    assertFalse(fromOffset(1).isIdentity());
  }

  @Test
  void testLinear() {
    assertFalse(fromOffset(1).isLinear());
  }

  @Test
  void testInverse() {
    UnitConverter converter = fromOffset(1).inverse();
    assertEquals(0.0, converter.convert(1.0));
  }

  @Test
  void testConvert() {
    UnitConverter converter = fromOffset(1);
    assertAll(
        () -> assertEquals(Rational.TWO, converter.convert(Rational.ONE)),
        () -> assertEquals(2.0, converter.convert(1.0))
    );
  }

  @Test
  void testConcatenate() {
    UnitConverter converter = fromOffset(1);
    assertAll(
        () -> assertEquals(3.0, converter.concatenate(fromOffset(1)).convert(1.0)),
        () -> assertEquals(IDENTITY, converter.concatenate(fromOffset(-1))),
        () -> assertEquals(2.0, converter.concatenate(IDENTITY).convert(1.0)),
        () -> assertEquals(3.0, converter.concatenate(fromFactor(2)).convert(1.0))
    );
  }

  @Test
  void testConversionSteps() {
    List<? extends UnitConverter> steps = fromOffset(1).getConversionSteps();
    assertEquals(Collections.singletonList(fromOffset(1)), steps);
  }

  @Test
  void testToString() {
    assertEquals("AddConverter(1)", fromOffset(1).toString());
  }

  @Test
  void testEquals() {
    UnitConverter converter = fromOffset(1);
    assertAll(
        () -> assertEquals(converter, converter),
        () -> assertNotEquals(fromOffset(1), fromFactor(2)),
        () -> assertNotEquals(converter, null)
    );
  }
}
