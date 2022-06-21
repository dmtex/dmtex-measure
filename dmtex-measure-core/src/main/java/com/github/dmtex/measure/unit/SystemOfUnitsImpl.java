package com.github.dmtex.measure.unit;

import com.github.dmtex.measure.annotation.AddUnit;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.measure.Dimension;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code SystemOfUnitsImpl} class is implementation of {@link SystemOfUnits} interface.
 *
 * @author Denis Murashev
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public final class SystemOfUnitsImpl implements SystemOfUnits {

  private final String name;
  private final Set<Unit<?>> units;
  private final Map<String, Unit<?>> nameToUnit;
  private final Map<Class<?>, Unit<?>> classToUnit;

  private SystemOfUnitsImpl(String name, Set<Unit<?>> units, Map<String, Unit<?>> nameToUnit,
      Map<Class<?>, Unit<?>> classToUnit) {
    this.name = name;
    this.units = units;
    this.nameToUnit = nameToUnit;
    this.classToUnit = classToUnit;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <Q extends Quantity<Q>> Unit<Q> getUnit(Class<Q> quantityType) {
    return (Unit<Q>) classToUnit.get(quantityType);
  }

  @Override
  public Unit<?> getUnit(String string) {
    return nameToUnit.get(string);
  }

  @Override
  public Set<? extends Unit<?>> getUnits() {
    return new LinkedHashSet<>(units);
  }

  @Override
  public Set<? extends Unit<?>> getUnits(Dimension dimension) {
    return units.stream()
        .filter(u -> dimension.equals(u.getDimension()))
        .collect(Collectors.toSet());
  }

  /**
   * Creates builder for System of Units.
   *
   * @param name System of Units name
   * @return Builder for new System of Units
   */
  public static Builder builder(String name) {
    return new Builder(name);
  }

  /**
   * {@code Builder} class is Builder for System of Units.
   */
  public static final class Builder {

    private final String name;
    private final Set<Unit<?>> units = new HashSet<>();
    private final Map<String, Unit<?>> nameToUnit = new HashMap<>();
    private final Map<Class<?>, Unit<?>> classToUnit = new HashMap<>();

    private Builder(String name) {
      this.name = name;
    }

    /**
     * Adds unit information from given class.
     *
     * @param unitsClass class with unit constants
     * @return current instance
     */
    public Builder add(Class<?> unitsClass) {
      for (Field field : unitsClass.getDeclaredFields()) {
        AddUnit annotation = field.getAnnotation(AddUnit.class);
        if (Objects.isNull(annotation)) {
          continue;
        }
        if (!AbstractUnit.class.isAssignableFrom(field.getType())) {
          throw new MeasurementException("Unsupported unit type: " + field.getType());
        }
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
          throw new MeasurementException("Unit type is not parametrized: " + field.getGenericType());
        }
        Type typeArgument = ((ParameterizedType) genericType).getActualTypeArguments()[0];
        if (!(typeArgument instanceof Class)) {
          throw new MeasurementException("Unsupported type parameter: " + typeArgument);
        }
        Class<?> type = (Class<?>) typeArgument;
        try {
          add((AbstractUnit<?>) field.get(null), type);
        } catch (IllegalAccessException e) {
          throw new MeasurementException(e);
        }
      }
      return this;
    }

    private void add(AbstractUnit<?> unit, Class<?> type) {
      units.add(unit);
      nameToUnit.putIfAbsent(unit.getName(), unit);
      classToUnit.putIfAbsent(type, unit);
    }

    /**
     * Builds System of Units and returns it.
     *
     * @return built System of Units
     */
    public SystemOfUnits build() {
      return new SystemOfUnitsImpl(name, Collections.unmodifiableSet(units), nameToUnit, classToUnit);
    }
  }
}
