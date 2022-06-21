package com.github.dmtex.measure.format;

import com.github.dmtex.measure.format.UnitNameHelper.Formatter;
import com.github.dmtex.measure.format.UnitNameHelper.FullFormatter;
import java.util.Locale;

/**
 * {@code FullUnitFormat} class is extension of {@link MeasureUnitFormat} for providing full unit names.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class FullUnitFormat extends MeasureUnitFormat {

  @Override
  public Formatter getFormatter(String bundleName) {
    return new FullFormatter(FormatServiceUtil.getAdapter(Locale.getDefault()), bundleName);
  }
}
