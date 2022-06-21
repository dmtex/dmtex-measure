package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.system.AmpereUnits;
import com.github.dmtex.measure.system.MeterUnits;
import com.github.dmtex.measure.system.MiscUnits;
import com.github.dmtex.measure.system.NamedUnits;
import com.github.dmtex.measure.system.RadianUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import com.github.dmtex.measure.unit.TestUnit;
import java.util.Objects;
import javax.measure.Quantity;
import javax.measure.Quantity.Scale;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.ElectricPotential;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;
import si.uom.quantity.Density;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MetricUnits.KELVIN;
import static com.github.dmtex.measure.system.MetricUnits.KILOGRAM;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantityImplTest {

  @Test
  void testAdd() {
    AngleAmount angle = new AngleAmount(1, RadianUnits.RADIAN);
    Angle actual = angle.add(angle);
    assertEquals(new AngleAmount(2.0, RadianUnits.RADIAN), actual);
  }

  @Test
  void testSubtract() {
    AreaAmount area = new AreaAmount(1, MeterUnits.SQUARE_METER);
    Area actual = area.subtract(area);
    assertEquals(new AreaAmount(0.0, MeterUnits.SQUARE_METER), actual);
  }

  @Test
  void testDivideQuantity() {
    DensityAmount density = new DensityAmount(1, NamedUnits.KILOGRAM_PER_CUBIC_METER);
    Quantity<?> actual = density.divide(density);
    assertEquals(1, actual.getValue().doubleValue());
  }

  @Test
  void testDivideNumber() {
    LengthAmount length = new LengthAmount(2, METER);
    Length actual = length.divide(2.0);
    assertEquals(1, actual.getValue().doubleValue());
  }

  @Test
  void testMultiplyQuantity() {
    LengthAmount length = new LengthAmount(2, METER);
    Quantity<Area> actual = length.multiply(length).asType(Area.class);
    assertEquals(4, actual.getValue().doubleValue());
  }

  @Test
  void testMultiplyNumber() {
    DensityAmount density = new DensityAmount(2, NamedUnits.KILOGRAM_PER_CUBIC_METER);
    Density actual = density.multiply(2.0);
    assertEquals(4, actual.getValue().doubleValue());
  }

  @Test
  void testTo() {
    LengthAmount length = new LengthAmount(1, METER);
    assertAll(
        () -> assertEquals(100, length.to(MetricPrefix.centi(METER)).getValue().doubleValue()),
        () -> assertThrows(UnsupportedOperationException.class, () -> length.to(new TestUnit<>()))
    );
  }

  @Test
  void testInverse() {
    LengthAmount length = new LengthAmount(1, METER);
    assertEquals(1, length.inverse().getValue().doubleValue());
  }

  @Test
  void testNegate() {
    LengthAmount length = new LengthAmount(1, METER);
    assertEquals(-1, length.negate().getValue().doubleValue());
  }

  @Test
  void testEquals() {
    Quantity<ElectricPotential> voltage = Quantities.of(1, AmpereUnits.VOLT);
    assertAll(
        () -> assertEquals(voltage, voltage),
        () -> assertNotEquals(Quantities.of(1, MiscUnits.CELSIUS), KELVIN),
        () -> assertNotEquals(new MassAmount(1, KILOGRAM), new MassAmount(1, NamedUnits.GRAM)),
        () -> assertNotEquals(new MassAmount(1, KILOGRAM), new MassAmount(2, KILOGRAM)),
        () -> assertNotEquals(new MassAmount(1, KILOGRAM), null)
    );
  }

  @Test
  void testIsEquivalentTo() {
    LengthAmount length = new LengthAmount(1, METER);
    assertAll(
        () -> assertTrue(length.isEquivalentTo(Quantities.of(100, MetricPrefix.centi(METER)))),
        () -> assertFalse(length.isEquivalentTo(Quantities.of(10, METER)))
    );
  }

  @Test
  void testCompareTo() {
    assertAll(
        () -> assertEquals(1, new MassAmount(1, KILOGRAM).compareTo(new MassAmount(1, NamedUnits.GRAM))),
        () -> assertEquals(0, new MassAmount(1, KILOGRAM).compareTo(new MassAmount(1, KILOGRAM))),
        () -> assertEquals(-1, new SpeedAmount(1, METER_PER_SECOND).compareTo(new SpeedAmount(2, METER_PER_SECOND)))
    );
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(1, METER, Scale.ABSOLUTE);
    assertEquals(hash, Quantities.of(1, METER).hashCode());
  }

  @Test
  void testToString() {
    assertEquals("1meter", Quantities.of(1, METER).toString());
  }
}
