package com.github.dmtex.measure.spi;

import com.github.dmtex.measure.system.MathConstants;
import com.github.dmtex.measure.system.PhysicalConstants;
import com.github.dmtex.measure.system.Si;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

/**
 * {@code DefaultSystemOfUnitsService} class is default implementation of {@link SystemOfUnitsService} SPI.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
public class DefaultSystemOfUnitsService implements SystemOfUnitsService {

  private final Map<String, SystemOfUnits> systems = new HashMap<>();

  /**
   * Initializes service provider.
   */
  protected DefaultSystemOfUnitsService() {
    add(Si.SYSTEM);
    add(MathConstants.SYSTEM);
    add(PhysicalConstants.SYSTEM);
  }

  @Override
  public SystemOfUnits getSystemOfUnits(String name) {
    return systems.get(name);
  }

  @Override
  public SystemOfUnits getSystemOfUnits() {
    return Si.SYSTEM;
  }

  @Override
  public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
    return systems.values();
  }

  protected final void add(SystemOfUnits system) {
    systems.put(system.getName(), system);
  }
}
