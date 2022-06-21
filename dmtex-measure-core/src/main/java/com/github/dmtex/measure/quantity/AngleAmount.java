package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Angle;

/**
 * {@code AngleAmount} class represents {@link Quantity} of type {@link Angle}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class AngleAmount extends AbstractQuantity<Angle> implements Angle {

  /**
   * Initializes instance with value and unit.
   *
   * @param number value
   * @param unit   unit
   */
  public AngleAmount(Number number, AbstractUnit<Angle> unit) {
    super(number, unit);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Angle>, Angle> factory() {
    return AngleAmount::new;
  }
}
