package net.r4mble.simplecoords;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.r4mble.simplecoords.client.gui.CoordsHud;

public class SimpleCoordsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(new CoordsHud());
	}
}