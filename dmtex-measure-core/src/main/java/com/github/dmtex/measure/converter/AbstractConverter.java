package com.github.dmtex.measure.converter;

import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;

/**
 * {@code AbstractConverter} class is basic abstract implementation of {@link UnitConverter}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
abstract class AbstractConverter implements UnitConverter {

  @Override
  public boolean isIdentity() {
    return false;
  }

  @Override
  public UnitConverter concatenate(UnitConverter converter) {
    return Converters.IDENTITY.equals(converter) ? this : new CombineConverter(this, converter);
  }

  @Override
  public List<? extends UnitConverter> getConversionSteps() {
    return Collections.singletonList(this);
  }
}
