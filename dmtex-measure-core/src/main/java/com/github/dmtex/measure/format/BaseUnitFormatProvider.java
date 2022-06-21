package com.github.dmtex.measure.format;

import com.github.dmtex.measure.spi.MeasureResourceBundleProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.spi.AbstractResourceBundleProvider;
import java.util.stream.Collectors;

/**
 * {@code BaseUnitFormatProvider} class provides general logic to build resource bundle from several provided by SPI.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class BaseUnitFormatProvider extends AbstractResourceBundleProvider {

  private final Class<? extends MeasureUnitFormat> formatClass;

  private final List<MeasureResourceBundleProvider> providers = ServiceLoader.load(MeasureResourceBundleProvider.class)
      .stream()
      .map(Provider::get)
      .collect(Collectors.toList());

  /**
   * Initializes resource bundle provider with given format class.
   *
   * @param formatClass format class
   */
  public BaseUnitFormatProvider(Class<? extends MeasureUnitFormat> formatClass) {
    this.formatClass = formatClass;
  }

  @Override
  public ResourceBundle getBundle(String baseName, Locale locale) {
    if (formatClass.getName().equals(baseName)) {
      List<ResourceBundle> bundles = providers.stream()
          .map(p -> p.getBundle(formatClass, locale))
          .filter(Objects::nonNull)
          .collect(Collectors.toCollection(ArrayList::new));
      Optional.ofNullable(super.getBundle(formatClass.getSimpleName() + "_unit", locale)).ifPresent(bundles::add);
      if (!bundles.isEmpty()) {
        return new CombinedResourceBundle(bundles);
      }
    }
    return null;
  }
}
