package com.github.dmtex.measure.format.spi;

import com.github.dmtex.measure.format.BaseUnitFormatProvider;
import com.github.dmtex.measure.format.MeasureUnitFormat;

/**
 * {@code MeasureUnitFormatResourceBundleProvider} class provides resources for {@link MeasureUnitFormat} class.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MeasureUnitFormatResourceBundleProvider extends BaseUnitFormatProvider
    implements MeasureUnitFormatProvider {

  /**
   * Initializes Resource Bundle Provider.
   */
  public MeasureUnitFormatResourceBundleProvider() {
    super(MeasureUnitFormat.class);
  }
}
