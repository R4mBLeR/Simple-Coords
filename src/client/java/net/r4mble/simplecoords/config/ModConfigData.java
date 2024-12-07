package net.r4mble.simplecoords.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "simplecoords")
public class ModConfigData implements ConfigData, ModConfig {
    public boolean showCoords = ModConfigDefaults.showCoords;
    public boolean showFacing = ModConfigDefaults.showFacing;
    public boolean showBiome = ModConfigDefaults.showBiome;
    public boolean showFPS = ModConfigDefaults.showFPS;

    @Override
    public boolean showCoords() {
        return showCoords;
    }

    @Override
    public boolean showFacing() {
        return showFacing;
    }

    @Override
    public boolean showBiome() {
        return showBiome;
    }

    @Override
    public boolean showFPS() {
        return showFPS;
    }

}
