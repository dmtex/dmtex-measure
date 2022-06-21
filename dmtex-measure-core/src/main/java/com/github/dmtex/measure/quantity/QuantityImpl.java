package com.github.dmtex.measure.quantity;

import com.github.dmtex.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;

final class QuantityImpl<Q extends Quantity<Q>> extends AbstractQuantity<Q> {

  QuantityImpl(Number value, AbstractUnit<Q> unit, Scale scale) {
    super(value, unit, scale);
  }

  QuantityImpl(Number value, AbstractUnit<Q> unit) {
    this(value, unit, Scale.ABSOLUTE);
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Q>, Q> factory() {
    return this::create;
  }

  @SuppressWarnings("unchecked")
  private Q create(Number v, AbstractUnit<Q> u) {
    return (Q) new QuantityImpl<>(v, u);
  }
}
