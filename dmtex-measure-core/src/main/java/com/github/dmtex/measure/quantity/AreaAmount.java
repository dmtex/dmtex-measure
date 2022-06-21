package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Area;

/**
 * {@code AreaAmount} class represents {@link Quantity} of type {@link Area}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class AreaAmount extends AbstractQuantity<Area> implements Area {

  /**
   * Initializes instance with value and unit.
   *
   * @param number value
   * @param unit   unit
   */
  public AreaAmount(Number number, AbstractUnit<Area> unit) {
    super(number, unit);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Area>, Area> factory() {
    return AreaAmount::new;
  }
}
