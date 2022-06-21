package com.github.dmtex.measure.format;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * {@code CombinedResourceBundle} class stores a list of resource bundles
 * and provides an interface to handle that list as single resource bundle.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class CombinedResourceBundle extends ResourceBundle {

  private final List<ResourceBundle> bundles;

  /**
   * Initializes with bundles.
   *
   * @param bundles bundles
   */
  public CombinedResourceBundle(List<ResourceBundle> bundles) {
    this.bundles = new ArrayList<>(bundles);
  }

  @Override
  protected Object handleGetObject(String key) {
    return bundles.stream().filter(b -> b.containsKey(key)).findFirst().map(b -> b.getObject(key)).orElse(null);
  }

  @Override
  public Enumeration<String> getKeys() {
    return new Enumeration<>() {

      private final CombinedIterator iterator = new CombinedIterator();

      @Override
      public boolean hasMoreElements() {
        return iterator.hasNext();
      }

      @Override
      public String nextElement() {
        return iterator.next();
      }
    };
  }

  private class CombinedIterator implements Iterator<String> {

    private int index;
    private Enumeration<String> current = getCurrent();

    @Override
    public boolean hasNext() {
      return Optional.ofNullable(current).map(Enumeration::hasMoreElements).orElse(false);
    }

    @Override
    public String next() {
      String next = Optional.ofNullable(current).map(Enumeration::nextElement).orElse(null);
      if (!hasNext()) {
        index++;
        current = getCurrent();
      }
      return next;
    }

    private Enumeration<String> getCurrent() {
      return index >= bundles.size() ? null : bundles.get(index).getKeys();
    }
  }
}
