package com.github.dmtex.measure.format;

import com.github.dmtex.math.rational.Rational;
import com.github.dmtex.math.rational.format.RationalFormat;
import com.github.dmtex.measure.quantity.AngleAmount;
import com.github.dmtex.measure.quantity.LengthAmount;
import com.github.dmtex.measure.quantity.Quantities;
import com.github.dmtex.measure.quantity.QuantityDecomposer;
import com.github.dmtex.measure.quantity.TestQuantity;
import com.github.dmtex.measure.system.NonSiUnits;
import com.github.dmtex.measure.unit.MetricPrefix;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.QuantityFormat;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.measure.system.MetricUnits.METER;
import static com.github.dmtex.measure.unit.MetricPrefix.centi;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeasureQuantityFormatTest {

  private final MeasureUnitFormat measureUnitFormat = new MeasureUnitFormat();
  private final RationalFormat rationalFormat = new RationalFormat();

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormat() {
    QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), measureUnitFormat);
    assertAll(
        () -> assertEquals("0\u202Fm", format.format(new LengthAmount(0, METER))),
        () -> assertEquals("1\u202Fcm", format.format(new LengthAmount(1, MetricPrefix.centi(METER)))),
        () -> assertEquals("2\u202F\u00B5m", format.format(new LengthAmount(2, MetricPrefix.micro(METER)))),
        () -> assertEquals("1\u00B0", format.format(new AngleAmount(1, NonSiUnits.DEGREE_ANGLE))),
        () -> assertEquals("2\u202Fm\u00B7m", new MeasureQuantityFormat(rationalFormat, measureUnitFormat)
            .format(Quantities.of(2, METER.multiply(METER)))),
        () -> assertEquals("1\u202Fdecimeter", new MeasureQuantityFormat(rationalFormat, new FullUnitFormat())
            .format(new LengthAmount(Rational.ONE, MetricPrefix.deci(METER)))),
        () -> assertEquals("1\u202Ftest", format.format(new TestQuantity<Length>()))
    );
  }

  @Test
  void testFormatList() {
    MeasureQuantityFormat format = new MeasureQuantityFormat();
    Unit<Length> cm = centi(METER);
    QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
    Quantity<Length> length = Quantities.of(1.25, METER);
    List<Quantity<Length>> list = decomposer.decompose(length);
    String actual = format.format(list);
    String expected = "1\u202Fm 25\u202Fcm";
    assertEquals(expected, actual);
  }

  @Test
  void testParse() {
    assertAll(
        () -> assertThrows(UnsupportedOperationException.class,
            () -> new MeasureQuantityFormat(NumberFormat.getInstance()).parse("", null)),
        () -> assertThrows(UnsupportedOperationException.class, () -> new MeasureQuantityFormat().parse(""))
    );
  }

  @Test
  void testFailure() {
    List<Quantity<Length>> quantities = asList(Quantities.of(1, METER), Quantities.of(1, METER));
    assertAll(
        () -> assertThrows(MeasurementException.class,
            () -> new MeasureQuantityFormat().format(Quantities.of(1, METER), new BrokenAppendable())),
        () -> assertThrows(MeasurementException.class,
            () -> new MeasureQuantityFormat().format(quantities, new BrokenAppendable()))
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
