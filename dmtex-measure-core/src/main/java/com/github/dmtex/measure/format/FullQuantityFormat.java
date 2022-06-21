package com.github.dmtex.measure.format;

import java.text.NumberFormat;
import javax.measure.format.QuantityFormat;

/**
 * {@code FullQuantityFormat} class is implementation of {@link QuantityFormat} for {@link FullUnitFormat}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class FullQuantityFormat extends MeasureQuantityFormat {

  /**
   * Initializes formatter.
   *
   * @param numberFormat number format
   */
  public FullQuantityFormat(NumberFormat numberFormat) {
    super(numberFormat, new FullUnitFormat());
  }

  /**
   * Default formatter.
   */
  public FullQuantityFormat() {
    super(null, new FullUnitFormat());
  }
}
