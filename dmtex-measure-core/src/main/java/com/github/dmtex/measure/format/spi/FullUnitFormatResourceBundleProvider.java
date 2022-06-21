package com.github.dmtex.measure.format.spi;

import com.github.dmtex.measure.format.BaseUnitFormatProvider;
import com.github.dmtex.measure.format.FullUnitFormat;

/**
 * {@code FullUnitFormatResourceBundleProvider} class provides resources for {@link FullUnitFormat} class.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class FullUnitFormatResourceBundleProvider extends BaseUnitFormatProvider implements FullUnitFormatProvider {

  /**
   * Initializes Resource Bundle Provider.
   */
  public FullUnitFormatResourceBundleProvider() {
    super(FullUnitFormat.class);
  }
}
