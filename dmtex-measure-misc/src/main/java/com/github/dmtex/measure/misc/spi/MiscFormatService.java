package com.github.dmtex.measure.misc.spi;

import com.github.dmtex.measure.format.FullUnitFormat;
import com.github.dmtex.measure.format.MeasureUnitFormat;
import com.github.dmtex.measure.spi.DefaultFormatService;
import java.util.Set;

class MiscFormatService extends DefaultFormatService {

  private static final String DEFAULT = "default";
  private static final String ALT = "alt";
  private static final String FULL = "full";

  @Override
  public MeasureUnitFormat getUnitFormat(String name) {
    if (FULL.equals(name)) {
      return new FullUnitFormat();
    }
    return new MeasureUnitFormat();
  }

  @Override
  public Set<String> getAvailableFormatNames(FormatType type) {
    return Set.of(DEFAULT, FULL, ALT);
  }
}
