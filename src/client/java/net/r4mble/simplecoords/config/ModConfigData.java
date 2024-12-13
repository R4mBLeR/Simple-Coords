package net.r4mble.simplecoords.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "simplecoords")
public class ModConfigData implements ConfigData, ModConfig {
    public float HudScale = ModConfigDefaults.HudScale;
    public boolean showCoords = ModConfigDefaults.showCoords;
    public boolean showFacing = ModConfigDefaults.showFacing;
    public boolean showBiome = ModConfigDefaults.showBiome;
    public boolean showFPS = ModConfigDefaults.showFPS;
    public String textColor = ModConfigDefaults.textColor;
    public String backgroundColor = ModConfigDefaults.backgroundColor;
    public int opacity = ModConfigDefaults.opacity;

    @Override
    public float HudScale() {
        if (HudScale > 3.0f) {
            HudScale = ModConfigDefaults.HudScale;
        }
        return HudScale;
    }

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

    @Override
    public String textColor() {
        if (textColor.length() != 6) {
            textColor = ModConfigDefaults.textColor;
        }
        return textColor;
    }

    @Override
    public int getTextColor() {
        return Integer.parseInt(textColor(), 16);
    }

    @Override
    public String backgroundColor() {
        if (backgroundColor.length() != 6) {
            backgroundColor = ModConfigDefaults.backgroundColor;
        }
        return backgroundColor;
    }

    @Override
    public int getBackgroundColor() {
        String sColor = opacity() + backgroundColor();
        return Integer.parseInt(sColor, 16);
    }

    @Override
    public int opacity() {
        if (opacity > 100) {
            opacity = 30;
        }
        return opacity;
    }

}
