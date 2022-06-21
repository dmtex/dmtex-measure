package com.github.dmtex.measure.quantity;

import static com.github.dmtex.measure.quantity.Quantities.of;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.centi;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

class QuantityDecomposerTest {

  @Test
  void testGetUnits() {
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(Collections.singleton(METER));
    Set<Unit<Length>> actual = decomposer.getUnits();
    Set<Unit<Length>> expected = Collections.singleton(METER);
    assertEquals(expected, actual);
  }

  @Test
  void testToListZero() {
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = of(0, METER);
    List<Quantity<Length>> actual = decomposer.decompose(length);
    List<Quantity<Length>> expected = Collections.emptyList();
    assertEquals(expected, actual);
  }

  @Test
  void testToListCase1() {
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = of(1.25, METER);
    List<Quantity<Length>> actual = decomposer.decompose(length);
    List<Quantity<Length>> expected = asList(of(1.0, METER), of(25.0, cm));
    assertEquals(expected, actual);
  }

  @Test
  void testToListCase2() {
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = of(1, METER);
    List<Quantity<Length>> actual = decomposer.decompose(length);
    List<Quantity<Length>> expected = Collections.singletonList(of(1.0, METER));
    assertEquals(expected, actual);
  }

  @Test
  void testToListCase3() {
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = of(0.25, METER);
    List<Quantity<Length>> actual = decomposer.decompose(length);
    List<Quantity<Length>> expected = Collections.singletonList(of(25.0, cm));
    assertEquals(expected, actual);
  }

  @Test
  void testToListCase4() {
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = of(-1.25, METER);
    assertThrows(MeasurementException.class, () -> decomposer.decompose(length));
  }
}
