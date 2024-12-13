package net.r4mble.simplecoords.config;

public class ModConfigDefaults implements ModConfig {
    public static final float HudScale = 1f;
    public static final boolean showCoords = true;
    public static final boolean showFacing = false;
    public static final boolean showBiome = false;
    public static final boolean showFPS = false;
    public static final String textColor = "FFFFFF";
    public static final String backgroundColor = "000000";
    public static final int opacity = 30;

    @Override
    public float HudScale() {
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
        return textColor;
    }

    @Override
    public int getTextColor() {
        return Integer.parseInt(textColor, 16);
    }

    @Override
    public String backgroundColor() {
        return backgroundColor;
    }

    @Override
    public int getBackgroundColor() {
        return 30000000;
    }

    @Override
    public int opacity() {
        return opacity;
    }

}
