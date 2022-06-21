package com.github.dmtex.measure.format;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.spi.AbstractResourceBundleProvider;
import javax.measure.format.UnitFormat;

/**
 * {@code UnitFormatResourceBundleProvider} class helps to provide Resource Bundles via SPI mechanism.
 *
 * @author Denis Murashev
 *
 * @param <T> type of {@link UnitFormat}
 *
 * @since Measure 1.0
 */
public class UnitFormatResourceBundleProvider<T extends UnitFormat> extends AbstractResourceBundleProvider {

  private final String className;
  private final String resourceName;
  private final Predicate<Locale> predicate;

  /**
   * Initializes Resource Bundle Provider.
   *
   * @param formatClass formatClass
   * @param predicate   predicate for applicable locales
   */
  public UnitFormatResourceBundleProvider(Class<T> formatClass, Predicate<Locale> predicate) {
    this.className = formatClass.getName();
    this.resourceName = toResourceName(formatClass);
    this.predicate = predicate;
  }

  private String toResourceName(Class<T> formatClass) {
    int index = formatClass.getName().lastIndexOf('.');
    return formatClass.getName().substring(index + 1) + "_unit";
  }

  @Override
  public ResourceBundle getBundle(String baseName, Locale locale) {
    if (predicate.test(locale) && className.equals(baseName)) {
      return super.getBundle(resourceName, locale);
    }
    return null;
  }
}
