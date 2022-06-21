package com.github.dmtex.measure.dimension;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import javax.measure.Dimension;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.dimension.Dimensions.LENGTH;
import static com.github.dmtex.measure.dimension.Dimensions.TIME;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DimensionTest {

  @Test
  void testBaseDimension() {
    assertAll(
        () -> assertEquals(Collections.singleton(LENGTH), LENGTH.getBaseDimensions().keySet()),
        () -> assertNotEquals(Collections.singleton(LENGTH), Dimensions.MASS.getBaseDimensions().keySet())
    );
  }

  @Test
  void testDimensionDivide() {
    Dimension dimension = LENGTH.divide(Dimensions.TIME);
    Map<BaseDimension, Integer> expected = new EnumMap<>(BaseDimension.class);
    expected.put(BaseDimension.LENGTH, 1);
    expected.put(BaseDimension.TIME, -1);
    assertEquals(expected, dimension.getBaseDimensions());
  }

  @Test
  void testDimensionRoot() {
    assertAll(
        () -> assertThrows(ArithmeticException.class, () -> LENGTH.root(2)),
        () -> assertThrows(ArithmeticException.class, () -> LENGTH.pow(2).root(3))
    );
  }

  @Test
  void testEquals() {
    assertAll(
        () -> assertEquals(LENGTH.pow(2), LENGTH.multiply(LENGTH)),
        () -> assertNotEquals(LENGTH.divide(TIME), null),
        () -> assertNotEquals(LENGTH.divide(TIME), ""),
        () -> assertNotEquals(LENGTH.multiply(TIME), LENGTH.divide(TIME))
    );
  }

  @Test
  void testEqualsAndHashCode() {
    Map<Dimension, String> map1 = Map.of(LENGTH.divide(TIME), "a");
    Map<Dimension, String> map2 = Map.of(LENGTH.divide(TIME), "b");
    assertNotEquals(map1, map2);
  }
}
