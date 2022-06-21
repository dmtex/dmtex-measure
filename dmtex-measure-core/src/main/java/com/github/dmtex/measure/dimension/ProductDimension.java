package com.github.dmtex.measure.dimension;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import javax.measure.Dimension;

class ProductDimension implements Dimension {

  private final Map<BaseDimension, Integer> data;

  ProductDimension() {
    data = new EnumMap<>(BaseDimension.class);
  }

  ProductDimension(Map<BaseDimension, Integer> data) {
    this.data = data;
  }

  @Override
  public Map<? extends Dimension, Integer> getBaseDimensions() {
    return data;
  }

  @Override
  public Dimension multiply(Dimension dimension) {
    Map<BaseDimension, Integer> map = new EnumMap<>(BaseDimension.class);
    for (BaseDimension d : BaseDimension.values()) {
      int value = 0;
      Integer i = data.get(d);
      if (i != null) {
        value += i;
      }
      i = dimension.getBaseDimensions().get(d);
      if (i != null) {
        value += i;
      }
      if (value != 0) {
        map.put(d, value);
      }
    }
    return new ProductDimension(map);
  }

  @Override
  public Dimension divide(Dimension dimension) {
    Map<BaseDimension, Integer> map = new EnumMap<>(BaseDimension.class);
    for (BaseDimension d : BaseDimension.values()) {
      int value = 0;
      Integer i = data.get(d);
      if (i != null) {
        value += i;
      }
      i = dimension.getBaseDimensions().get(d);
      if (i != null) {
        value -= i;
      }
      if (value != 0) {
        map.put(d, value);
      }
    }
    return new ProductDimension(map);
  }

  @Override
  public Dimension pow(int n) {
    Map<BaseDimension, Integer> map = new EnumMap<>(BaseDimension.class);
    for (BaseDimension d : BaseDimension.values()) {
      Integer i = data.get(d);
      if (i != null) {
        map.put(d, i * n);
      }
    }
    return new ProductDimension(map);
  }

  @Override
  public Dimension root(int n) {
    Map<BaseDimension, Integer> map = new EnumMap<>(BaseDimension.class);
    for (BaseDimension d : BaseDimension.values()) {
      Integer i = data.get(d);
      if (i != null) {
        if (i % n != 0) {
          throw new ArithmeticException("Unsupported operation");
        }
        map.put(d, i / n);
      }
    }
    return new ProductDimension(map);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Dimension)) {
      return false;
    }
    Dimension other = (Dimension) obj;
    for (BaseDimension d : BaseDimension.values()) {
      if (!Objects.equals(data.get(d), other.getBaseDimensions().get(d))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    return prime + data.hashCode();
  }
}
