package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import si.uom.quantity.Density;

/**
 * {@code DensityAmount} class represents {@link Quantity} of type {@link Density}.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class DensityAmount extends AbstractQuantity<Density> implements Density {

  /**
   * Initializes instance with value and unit.
   *
   * @param number number
   * @param unit   unit
   */
  public DensityAmount(Number number, AbstractUnit<Density> unit) {
    super(number, unit);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Density>, Density> factory() {
    return DensityAmount::new;
  }
}
