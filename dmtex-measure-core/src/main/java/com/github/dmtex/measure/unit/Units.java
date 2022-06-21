package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.converter.Converters;
import javax.measure.Dimension;
import javax.measure.Quantity;

/**
 * {@code Units} class provides utility methods for unit creation.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class Units {

  private Units() {
  }

  /**
   * Adds unit to system.
   *
   * @param unit unit
   * @param type type
   * @param <Q> quantity type
   * @return added unit
   */
  @SuppressWarnings("unchecked")
  public static <Q extends Quantity<Q>> AbstractUnit<Q> unit(AbstractUnit<?> unit, Class<Q> type) {
    return (AbstractUnit<Q>) unit;
  }

  /**
   * Adds base unit to the system.
   *
   * @param name      name
   * @param dimension dimension
   * @param type      type
   * @param <Q> quantity type
   * @return added unit
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> unit(String name, Dimension dimension, Class<Q> type) {
    return unit(new BaseUnit<>(name, dimension), type);
  }

  /**
   * Adds unit created with given factor.
   *
   * @param name   name
   * @param unit   unit
   * @param factor factor
   * @param type   type
   * @param <Q> quantity type
   * @return added unit
   */
  public static <Q extends Quantity<Q>> AbstractUnit<Q> unit(String name, AbstractUnit<Q> unit, Number factor,
      Class<Q> type) {
    return unit(new TransformedUnit<>(unit, Converters.fromFactor(factor)).alternate(name), type);
  }
}
