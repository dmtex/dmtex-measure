package com.github.dmtex.measure.converter;

import com.github.dmtex.math.rational.Rational;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.converter.Converters.fromFactor;
import static com.github.dmtex.measure.converter.Converters.fromOffset;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CombineConverterTest {

  @Test
  void testNotIdentity() {
    assertFalse(fromOffset(1).concatenate(fromFactor(2)).isIdentity());
  }

  @Test
  void testLinear() {
    assertAll(
        () -> assertFalse(fromOffset(1).concatenate(fromOffset(1)).isLinear()),
        () -> assertFalse(fromOffset(1).concatenate(fromFactor(2)).isLinear()),
        () -> assertFalse(fromFactor(2).concatenate(fromOffset(1)).isLinear()),
        () -> assertTrue(fromFactor(2).concatenate(fromFactor(2)).isLinear())
    );
  }

  @Test
  void testInverse() {
    UnitConverter converter = fromOffset(1).concatenate(fromFactor(2)).inverse();
    assertEquals(0.5, converter.convert(2.0));
  }

  @Test
  void testConvertNumber() {
    UnitConverter converter = fromOffset(1).concatenate(fromFactor(2));
    assertEquals(new Rational(3), converter.convert(Rational.ONE));
  }

  @Test
  void testConvertDouble() {
    UnitConverter converter = fromOffset(1).concatenate(fromFactor(2));
    assertEquals(3.0, converter.convert(1.0));
  }

  @Test
  void testConversionSteps() {
    UnitConverter converter = fromOffset(1).concatenate(fromFactor(2));
    List<? extends UnitConverter> steps = converter.getConversionSteps();
    assertEquals(Arrays.asList(fromOffset(1), fromFactor(2)), steps);
  }

  @Test
  void testToString() {
    assertEquals("CombineConverter(AddConverter(1),MultiplyConverter(2))",
        fromOffset(1).concatenate(fromFactor(2)).toString());
  }

  @Test
  void testEqualsAndHashCode() {
    Map<UnitConverter, String> map1 = Map.of(fromOffset(1).concatenate(fromFactor(2)), "a", fromFactor(2), "b");
    Map<UnitConverter, String> map2 = Map.of(fromOffset(1).concatenate(fromFactor(2)), "a", fromOffset(1), "b");
    assertNotEquals(map1, map2);
  }

  @Test
  void testEquals() {
    UnitConverter converter = fromOffset(1).concatenate(fromFactor(2));
    assertAll(
        () -> assertEquals(converter, converter),
        () -> assertNotEquals(converter, null),
        () -> assertNotEquals(fromOffset(1).concatenate(fromFactor(2)), fromOffset(1)),
        () -> assertNotEquals(fromOffset(1).concatenate(fromFactor(2)), fromOffset(1).concatenate(fromFactor(3))),
        () -> assertNotEquals(fromOffset(1).concatenate(fromFactor(2)), fromOffset(2).concatenate(fromFactor(2))),
        () -> assertNotEquals(fromOffset(1).concatenate(fromFactor(2)), fromOffset(2).concatenate(fromFactor(3)))
    );
  }
}
