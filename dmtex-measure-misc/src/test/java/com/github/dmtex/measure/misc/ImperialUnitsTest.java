package com.github.dmtex.measure.misc;

import com.github.dmtex.measure.quantity.Quantities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.misc.ImperialUnits.FAHRENHEIT;
import static com.github.dmtex.measure.misc.ImperialUnits.RANKINE;
import static com.github.dmtex.measure.system.MetricUnits.KELVIN;
import static com.github.dmtex.measure.system.MiscUnits.CELSIUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImperialUnitsTest {

  @Test
  void testRankine() {
    Assertions.assertEquals(Quantities.of(100.0, KELVIN), Quantities.of(180, RANKINE).to(KELVIN));
  }

  @Test
  void testFahrenheitCase1() {
    assertEquals(0, Quantities.of(32, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
  }

  @Test
  void testFahrenheitCase2() {
    assertEquals(100.0, Quantities.of(212, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
  }
}
