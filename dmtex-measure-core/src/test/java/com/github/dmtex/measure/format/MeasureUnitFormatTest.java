package com.github.dmtex.measure.format;

import com.github.dmtex.measure.system.MetricUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import com.github.dmtex.measure.unit.TestUnit;
import java.io.IOException;
import java.util.Locale;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.dmtex.measure.system.MeterUnits.METER_PER_SECOND_SQUARED;
import static com.github.dmtex.measure.system.MeterUnits.SQUARE_METER;
import static com.github.dmtex.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MeasureUnitFormatTest {

  private final MeasureUnitFormat format = new MeasureUnitFormat();

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormat() {
    assertAll(
        () -> assertEquals("m", format.format(MetricUnits.METER)),
        () -> assertEquals("km", format.format(MetricPrefix.kilo(MetricUnits.METER))),
        () -> assertEquals("m\u00B2", format.format(SQUARE_METER)),
        () -> assertEquals("m\u2044s", format.format(METER_PER_SECOND)),
        () -> assertEquals("m\u2044s\u00B2", format.format(METER_PER_SECOND_SQUARED)),
        () -> assertEquals("test", format.format(new TestUnit<>()))
    );
  }

  @Test
  void testLabel() {
    assertThrows(UnsupportedOperationException.class, () -> format.label(null, null));
  }

  @Test
  void testLocaleSensitive() {
    assertTrue(format.isLocaleSensitive());
  }

  @Test
  void testParse() {
    assertAll(
        () -> assertThrows(UnsupportedOperationException.class, () -> format.parse("")),
        () -> assertThrows(UnsupportedOperationException.class, () -> format.parse("", null))
    );
  }

  @Test
  void testFailure() {
    Appendable appendable = new BrokenAppendable();
    assertAll(
        () -> assertThrows(MeasurementException.class, () -> format.format(METER, appendable)),
        () -> assertThrows(MeasurementException.class, () -> format.format(1, METER, appendable)),
        () -> assertThrows(MeasurementException.class, () -> format.format(new TestUnit<>(), appendable))
    );
  }

  private static class BrokenAppendable implements Appendable {

    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException();
    }
  }
}
