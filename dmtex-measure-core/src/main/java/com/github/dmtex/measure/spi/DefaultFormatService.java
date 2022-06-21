package com.github.dmtex.measure.spi;

import com.github.dmtex.measure.format.FullQuantityFormat;
import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureQuantityFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import java.util.Set;
import javax.measure.spi.FormatService;

/**
 * {@code DefaultFormatService} class is default implementation of {@link FormatService} SPI.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class DefaultFormatService implements FormatService {

  private static final String DEFAULT = "default";
  private static final String FULL = "full";

  @Override
  public MeasureQuantityFormat getQuantityFormat() {
    return new MeasureQuantityFormat();
  }

  @Override
  public MeasureQuantityFormat getQuantityFormat(String name) {
    if (FULL.equals(name)) {
      return new FullQuantityFormat();
    }
    return new MeasureQuantityFormat();
  }

  @Override
  public MeasureUnitFormat getUnitFormat() {
    return new MeasureUnitFormat();
  }

  @Override
  public MeasureUnitFormat getUnitFormat(String name) {
    if (FULL.equals(name)) {
      return new FullUnitFormat();
    }
    return new MeasureUnitFormat();
  }

  @Override
  public MeasureUnitFormat getUnitFormat(String name, String variant) {
    return variant == null || variant.isEmpty() ? getUnitFormat(name) : getUnitFormat(name + "_" + variant);
  }

  @Override
  public Set<String> getAvailableFormatNames(FormatType type) {
    return Set.of(DEFAULT, FULL);
  }
}
