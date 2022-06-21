package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Mass;

/**
 * {@code MassAmount} class represents {@link Quantity} of type {@link Mass}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class MassAmount extends AbstractQuantity<Mass> implements Mass {

  /**
   * Initializes instance with value and unit.
   *
   * @param number value
   * @param unit   unit
   */
  public MassAmount(Number number, AbstractUnit<Mass> unit) {
    super(number, unit);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Mass>, Mass> factory() {
    return MassAmount::new;
  }
}
