package net.r4mble.simplecoords.config;

public class ModConfigDefaults implements ModConfig {
    public static final boolean showCoords = true;
    public static final boolean showFacing = false;
    public static final boolean showBiome = false;
    public static final boolean showFPS = false;

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
