package com.github.dmtex.measure.en.spi;

import com.github.dmtex.measure.format.LocaleAdapter;

class LocaleAdapterImpl implements LocaleAdapter {

  @Override
  public String name(String name, Number number) {
    if (Math.abs(number.doubleValue()) <= 1) {
      return name;
    }
    return name + ".plural";
  }
}
