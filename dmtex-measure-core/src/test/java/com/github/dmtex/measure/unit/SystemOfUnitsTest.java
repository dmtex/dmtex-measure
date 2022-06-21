package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.annotation.AddUnit;
import com.github.dmtex.measure.dimension.Dimensions;
import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.system.Si.SYSTEM;
import static com.github.dmtex.measure.unit.Units.unit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SystemOfUnitsTest {

  @Test
  void testGetName() {
    assertEquals("SI", SYSTEM.getName());
  }

  @Test
  void testGetUnitByType() {
    assertEquals(METER, SYSTEM.getUnit(Length.class));
  }

  @Test
  void testGetUnitByName() {
    assertEquals(METER, SYSTEM.getUnit("meter"));
  }

  @Test
  void testGetUnits() {
    assertFalse(SYSTEM.getUnits().isEmpty());
  }

  @Test
  void testGetUnitsLength() {
    assertFalse(SYSTEM.getUnits(Dimensions.LENGTH).isEmpty());
  }

  @Test
  void testFailure() {
    assertAll(
        () -> assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits1.class)),
        () -> assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits2.class)),
        () -> assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits3.class)),
        () -> assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits4.class))
    );
  }

  static final class TestUnits1 {
    @AddUnit
    public static final Unit<Length> UNIT = unit(METER, Length.class);
  }

  static final class TestUnits2 {
    @AddUnit
    public static final AbstractUnit<?> UNIT = unit(METER, Length.class);
  }

  static final class TestUnits3 {
    @AddUnit
    public static final AbstractUnit<?> UNIT = unit(METER, Length.class);
  }

  static final class TestUnits4 {
    @AddUnit
    private static final AbstractUnit<Length> UNIT = unit(METER, Length.class);
  }
}
