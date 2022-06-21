package com.github.dmtex.measure.format;

/**
 * {@code LocaleAdapter} interface is Locale adapter contract.
 * It helps to localize unit name forms, for example, to use different words for singular and plural forms.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public interface LocaleAdapter {

  /**
   * Provides name.
   *
   * @param name   unit name
   * @param number numeric value
   * @return updated name
   */
  default String name(String name, Number number) {
    return name;
  }

  /**
   * Provides suffix.
   *
   * @param suffix unit name suffix
   * @param name   unit name
   * @param number numeric value
   * @return updated suffix
   */
  default String suffix(String suffix, String name, Number number) {
    return suffix;
  }
}
