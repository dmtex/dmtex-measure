package com.github.dmtex.measure.converter;

import com.github.dmtex.math.rational.Rational;
import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.converter.Converters.IDENTITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentityConverterTest {

  @Test
  void testIdentity() {
    assertTrue(IDENTITY.isIdentity());
  }

  @Test
  void testLinear() {
    assertTrue(IDENTITY.isLinear());
  }

  @Test
  void testInverse() {
    UnitConverter converter = IDENTITY.inverse();
    assertEquals(IDENTITY, converter);
  }

  @Test
  void testConvertNumber() {
    assertEquals(Rational.ONE, IDENTITY.convert(Rational.ONE));
  }

  @Test
  void testConvertDouble() {
    assertEquals(1.0, IDENTITY.convert(1.0));
  }

  @Test
  void testConcatenate() {
    UnitConverter converter = IDENTITY.concatenate(Converters.fromOffset(1));
    assertEquals(Converters.fromOffset(1), converter);
  }

  @Test
  void testConversionSteps() {
    List<? extends UnitConverter> steps = IDENTITY.getConversionSteps();
    assertEquals(Collections.singletonList(IDENTITY), steps);
  }
}
