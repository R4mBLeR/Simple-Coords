package net.r4mble.simplecoords;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.NoticeScreen;
import net.minecraft.text.Text;
import net.r4mble.simplecoords.config.ModConfigData;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            if(FabricLoader.getInstance().isModLoaded("cloth-config")) {
                return AutoConfig.getConfigScreen(ModConfigData.class, parent).get();
            }
            return new NoticeScreen(() -> MinecraftClient.getInstance().setScreen(parent), Text.of("Simple Coords"), Text.of("Simple Coords requires Cloth Config to configure the mod, adding new values to the HUD"));
        };
    }
}
