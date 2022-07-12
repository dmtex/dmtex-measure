package com.github.dmtex.measure.misc.spi;

import com.github.dmtex.measure.misc.ApothecariesUnits;
import com.github.dmtex.measure.misc.CgsUnits;
import com.github.dmtex.measure.misc.ImperialUnits;
import com.github.dmtex.measure.misc.InformationUnits;
import com.github.dmtex.measure.misc.LegacyUnits;
import com.github.dmtex.measure.misc.RussianUnits;
import com.github.dmtex.measure.misc.TemperatureUnits;
import com.github.dmtex.measure.misc.TroyUnits;
import com.github.dmtex.measure.misc.UsCustomaryUnits;
import com.github.dmtex.measure.spi.DefaultSystemOfUnitsService;

class MiscSystemOfUnitsService extends DefaultSystemOfUnitsService {

  MiscSystemOfUnitsService() {
    add(ImperialUnits.SYSTEM);
    add(UsCustomaryUnits.SYSTEM);
    add(TroyUnits.SYSTEM);
    add(ApothecariesUnits.SYSTEM);
    add(RussianUnits.SYSTEM);
    add(TemperatureUnits.SYSTEM);
    add(CgsUnits.SYSTEM);
    add(LegacyUnits.SYSTEM);
    add(InformationUnits.SYSTEM);
  }
}
