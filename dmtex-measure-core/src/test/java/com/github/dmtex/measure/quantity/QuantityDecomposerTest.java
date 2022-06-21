package com.github.dmtex.measure.quantity;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.github.dmtex.measure.quantity.Quantities.of;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.centi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityDecomposerTest {

  private static final Unit<Length> CM = centi(METER);

  @Test
  void testGetUnits() {
    Unit<Length> alternateUnit = METER.alternate("alternate_meter_unit");
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(List.of(METER, alternateUnit));
    Set<Unit<Length>> actual = decomposer.getUnits();
    Set<Unit<Length>> expected = Set.of(METER, alternateUnit);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("toListSource")
  void testToList(Quantity<Length> length, List<Quantity<Length>> expected) {
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(List.of(METER, CM));
    List<Quantity<Length>> actual = decomposer.decompose(length);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> toListSource() {
    return Stream.of(
        Arguments.of(of(0, METER), List.of()),
        Arguments.of(of(1.25, METER), List.of(of(1.0, METER), of(25.0, CM))),
        Arguments.of(of(1, METER), List.of(of(1.0, METER))),
        Arguments.of(of(0.25, METER), List.of(of(25.0, CM)))
    );
  }

  @Test
  void testToListFailure() {
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(List.of(METER, CM));
    Quantity<Length> length = of(-1.25, METER);
    assertThrows(MeasurementException.class, () -> decomposer.decompose(length));
  }
}
