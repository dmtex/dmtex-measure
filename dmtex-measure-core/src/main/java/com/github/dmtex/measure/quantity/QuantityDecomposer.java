package com.github.dmtex.measure.quantity;

import com.github.dmtex.math.adapter.Adapters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * {@code QuantityDecomposer} class is able to decompose quantity by the set of units.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 1.0
 */
public class QuantityDecomposer<Q extends Quantity<Q>> {

  private final NavigableSet<Unit<Q>> units;

  /**
   * Initialises instance with given collection of units.
   *
   * @param units  units
   */
  public QuantityDecomposer(Collection<Unit<Q>> units) {
    var set = new TreeSet<Unit<Q>>(QuantityDecomposer::compare);
    set.addAll(units);
    this.units = Collections.unmodifiableNavigableSet(set);
  }

  private static <Q extends Quantity<Q>, U extends Unit<Q>> int compare(U a, U b) {
    int value = Double.compare(1, Quantities.of(1, a).to(b).getValue().doubleValue());
    if (value != 0) {
      return value;
    }
    return a.getName().compareTo(b.getName());
  }

  /**
   * Provides ordered set of units.
   *
   * @return the units
   */
  public final NavigableSet<Unit<Q>> getUnits() {
    return units;
  }

  /**
   * Evaluates decomposition for given quantity.
   * If different implementation is required, the method can be overridden.
   *
   * @param quantity quantity
   * @return decomposition
   */
  public List<Quantity<Q>> decompose(Quantity<Q> quantity) {
    double value = toDouble(quantity);
    if (value < 0) {
      throw new MeasurementException("Operation is not supported for negative values");
    }
    if (value == 0) {
      return Collections.emptyList();
    }
    List<Quantity<Q>> list = new ArrayList<>();
    Quantity<Q> amount = quantity;
    for (Unit<Q> unit : units) {
      if (toDouble(amount) == 0) {
        break;
      }
      amount = forUnit(unit, amount, list);
    }
    return list;
  }

  private Quantity<Q> forUnit(Unit<Q> unit, Quantity<Q> amount, List<Quantity<Q>> list) {
    Quantity<Q> q = amount.to(unit);
    if (units.last().equals(unit)) {
      if (toDouble(q) > 0) {
        list.add(q);
      }
    } else {
      Number v = Adapters.lookup(q.getValue()).floor();
      if (v.doubleValue() > 0) {
        Quantity<Q> o = Quantities.of(v, unit);
        if (toDouble(o) > 0) {
          list.add(o);
          return amount.subtract(o);
        }
      }
    }
    return amount;
  }

  private double toDouble(Quantity<Q> quantity) {
    return quantity.getValue().doubleValue();
  }
}
