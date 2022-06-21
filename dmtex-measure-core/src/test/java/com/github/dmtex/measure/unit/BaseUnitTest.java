package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.converter.Converters;
import com.github.dmtex.measure.dimension.Dimensions;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseUnitTest {

  @Test
  void testSystemConverter() {
    BaseUnit<Length> unit = new BaseUnit<>("x", Dimensions.LENGTH);
    assertEquals(Converters.IDENTITY, unit.getSystemConverter());
  }

  @Test
  void testDimension() {
    BaseUnit<Length> unit = new BaseUnit<>("x", Dimensions.LENGTH);
    assertEquals(Dimensions.LENGTH, unit.getDimension());
  }

  @Test
  void testDimensionless() {
    BaseUnit<Length> unit = new BaseUnit<>("x", Dimensions.DIMENSIONLESS);
    assertEquals(Dimensions.DIMENSIONLESS, unit.getDimension());
  }

  @Test
  void testDimensionNull() {
    BaseUnit<Length> unit = new BaseUnit<>("x");
    assertEquals(Dimensions.DIMENSIONLESS, unit.getDimension());
  }

  @Test
  void testIsSystemUnit() {
    BaseUnit<Length> unit = new BaseUnit<>("x", Dimensions.LENGTH);
    assertTrue(unit.isSystemUnit());
  }

  @Test
  void testToSystemUnit() {
    BaseUnit<Length> unit = new BaseUnit<>("x", Dimensions.LENGTH);
    assertSame(unit, unit.toSystemUnit());
  }
}
