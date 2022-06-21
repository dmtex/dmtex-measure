package com.github.dmtex.measure.format;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javax.measure.MeasurementException;
import javax.measure.Prefix;
import javax.measure.Unit;

import static java.util.stream.Collectors.joining;

/**
 * {@code UnitNameHelper} class helps with unit name creation and formatting.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class UnitNameHelper {

  private static final char PREFIX = ':';
  private static final char STAR = '*';
  private static final char DIV = '/';
  private static final char POW = '^';

  private static final String STAR_REGEX = "[*]";

  private UnitNameHelper() {
  }

  /**
   * Provides string representation of unit with prefix.
   *
   * @param prefix prefix
   * @param unit   unit
   * @return unit name with prefix
   */
  public static String prefix(Prefix prefix, Unit<?> unit) {
    UnitName name = parse(unit.getName());
    if (!name.denominator.isEmpty() || name.numerator.size() != 1) {
      throw new MeasurementException("Cannot add prefix to unit: " + unit);
    }
    if (Objects.nonNull(name.numerator.get(0).prefix)) {
      throw new MeasurementException("Cannot add two prefixes to unit: " + unit);
    }
    name.numerator.get(0).prefix = prefix.getName();
    return name.toString();
  }

  /**
   * Provides string representation of units' product.
   *
   * @param left  left unit
   * @param right right unit
   * @return name of product of units
   */
  public static String multiply(Unit<?> left, Unit<?> right) {
    UnitName leftName = parse(left.getName());
    UnitName rightName = parse(right.getName());
    UnitName result = new UnitName();
    result.numerator.addAll(leftName.numerator);
    result.numerator.addAll(rightName.numerator);
    result.denominator.addAll(leftName.denominator);
    result.denominator.addAll(rightName.denominator);
    return result.toString();
  }

  /**
   * Provides string representation of units' ratio.
   *
   * @param left  left unit
   * @param right right unit
   * @return name of ratio of units
   */
  public static String divide(Unit<?> left, Unit<?> right) {
    UnitName leftName = parse(left.getName());
    UnitName rightName = parse(right.getName());
    UnitName result = new UnitName();
    result.numerator.addAll(leftName.numerator);
    result.numerator.addAll(rightName.denominator);
    result.denominator.addAll(leftName.denominator);
    result.denominator.addAll(rightName.numerator);
    return result.toString();
  }

  /**
   * Provides string representation of unit to the nth power.
   *
   * @param unit unit
   * @param n    exponent
   * @return name of unit to the nth power
   */
  public static String pow(Unit<?> unit, int n) {
    UnitName name = parse(unit.getName());
    name.numerator.forEach(p -> part(p, n));
    name.denominator.forEach(p -> part(p, n));
    return name.toString();
  }

  private static void part(Part part, int n) {
    if (Objects.isNull(part.suffix)) {
      part.suffix = String.valueOf(n);
    } else {
      try {
        int power = n * Integer.parseInt(part.suffix);
        part.suffix = String.valueOf(power);
      } catch (NumberFormatException e) {
        throw new MeasurementException(e);
      }
    }
  }

  private static UnitName parse(String unit) {
    UnitName unitName = new UnitName();
    int index = unit.indexOf(DIV);
    if (index == -1) {
      parse(unit, unitName.numerator);
    } else {
      parse(unit.substring(0, index), unitName.numerator);
      parse(unit.substring(index + 1), unitName.denominator);
    }
    return unitName;
  }

  private static void parse(String value, List<Part> parts) {
    String[] units = value.split(STAR_REGEX);
    for (String unit : units) {
      parts.add(Part.parse(unit));
    }
  }

  /**
   * {@code Formatter} class.
   */
  public abstract static class Formatter {

    private static final String PREFIX = "prefix.";
    private static final String UNIT = "unit.";
    private static final String SUFFIX = "suffix.";

    private final LocaleAdapter adapter;
    private final String bundleName;

    protected Formatter(LocaleAdapter adapter, String bundleName) {
      this.adapter = adapter;
      this.bundleName = bundleName;
    }

    /**
     * The implementation should format given value of given unit.
     *
     * @param value value
     * @param unit  unit
     * @return formatted string
     */
    protected abstract String format(Number value, String unit);

    final String format(Number value, Part part) {
      StringBuilder builder = new StringBuilder();
      if (Objects.nonNull(part.prefix)) {
        builder.append(getString(PREFIX + part.prefix));
      }
      builder.append(getString(UNIT + adapter.name(part.name, value), () -> UNIT + adapter.name(part.name, 1)));
      if (Objects.isNull(part.suffix)) {
        return builder.toString();
      }
      String format = getString(SUFFIX + adapter.suffix(part.suffix, part.name, value));
      return MessageFormat.format(format, builder.toString());
    }

    final String formatNumerator(Number value, List<Part> parts) {
      StringBuilder builder = new StringBuilder();
      int last = parts.size() - 1;
      for (int i = 0; i < last; i++) {
        builder.append(format(1, parts.get(i))).append('\u2011'); // Nonbreaking hyphen
      }
      builder.append(format(value, parts.get(last)));
      return builder.toString();
    }

    final String formatDenominator(Part part) {
      String prefix = Optional.ofNullable(part.prefix).map(v -> getString(PREFIX + v)).orElse("");
      String name = MessageFormat.format(getString("per." + part.name), prefix);
      if (Objects.isNull(part.suffix)) {
        return name;
      }
      return MessageFormat.format(getString(SUFFIX + part.suffix + ".denom"), name);
    }

    private String getString(String key) {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
      if (bundle.containsKey(key)) {
        return bundle.getString(key);
      }
      return String.format("[%s]", key);
    }

    private String getString(String key, Supplier<String> altKeySupplier) {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
      if (bundle.containsKey(key)) {
        return bundle.getString(key);
      }
      return getString(altKeySupplier.get());
    }
  }

  static final class DefaultFormatter extends Formatter {

    DefaultFormatter(LocaleAdapter adapter, String bundleName) {
      super(adapter, bundleName);
    }

    @Override
    public String format(Number value, String unit) {
      StringBuilder builder = new StringBuilder();
      UnitName name = parse(unit);
      final String bullet = "\u00B7"; // middle dot
      builder.append(name.numerator.stream().map(p -> format(value, p)).collect(joining(bullet)));
      if (!name.denominator.isEmpty()) {
        builder.append('\u2044'); // fraction slash
        builder.append(name.denominator.stream().map(p -> format(value, p)).collect(joining(bullet)));
      }
      return builder.toString();
    }
  }

  static final class FullFormatter extends Formatter {

    FullFormatter(LocaleAdapter adapter, String bundleName) {
      super(adapter, bundleName);
    }

    @Override
    public String format(Number value, String unit) {
      UnitName name = parse(unit);
      if (name.denominator.size() > 1) {
        return "?/?";
      }
      if (name.denominator.isEmpty()) {
        return formatNumerator(value, name.numerator);
      }
      char space = '\u202F'; // unbreakable space
      return formatNumerator(value, name.numerator) + space + formatDenominator(name.denominator.get(0));
    }
  }

  private static final class UnitName {

    private final List<Part> numerator = new ArrayList<>();
    private final List<Part> denominator = new ArrayList<>();

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(numerator.stream().map(Part::toString).collect(joining(String.valueOf(STAR))));
      if (!denominator.isEmpty()) {
        builder.append(DIV).append(denominator.stream().map(Part::toString).collect(joining(String.valueOf(STAR))));
      }
      return builder.toString();
    }
  }

  private static final class Part {

    private String prefix;
    private final String name;
    private String suffix;

    private Part(String prefix, String name, String suffix) {
      this.prefix = prefix;
      this.name = name;
      this.suffix = suffix;
    }

    static Part parse(String unit) {
      int start = unit.indexOf(PREFIX);
      String prefix = start == -1 ? null : unit.substring(0, start);
      int end = unit.indexOf(POW);
      String suffix = end == -1 ? null : unit.substring(end + 1);
      start++;
      String name = end == -1 ? unit.substring(start) : unit.substring(start, end);
      return new Part(prefix, name, suffix);
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (prefix != null) {
        builder.append(prefix).append(PREFIX);
      }
      builder.append(name);
      if (suffix != null) {
        builder.append(POW).append(suffix);
      }
      return builder.toString();
    }
  }
}
