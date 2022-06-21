package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Speed;

/**
 * {@code SpeedAmount} class represents {@link Quantity} of type {@link Speed}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class SpeedAmount extends AbstractQuantity<Speed> implements Speed {

  /**
   * Initializes instance with value and unit.
   *
   * @param number value
   * @param unit   unit
   */
  public SpeedAmount(Number number, AbstractUnit<Speed> unit) {
    super(number, unit);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Speed>, Speed> factory() {
    return SpeedAmount::new;
  }
}
