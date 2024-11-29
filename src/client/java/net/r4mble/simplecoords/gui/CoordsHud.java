package net.r4mble.simplecoords.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.r4mble.simplecoords.SimpleCoordsClient;

@Environment(EnvType.CLIENT)
public class CoordsHud implements HudRenderCallback {
    int posX = 2;
    int posY = 2;
    int padding = 2;
    int offset = 5;
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player != null) {
            int textHeight = client.textRenderer.fontHeight;
            int textWidth = 0;
            int drawCount = 0;
            String coords;
            String facing;
            String fps;
            String biome;
            if(SimpleCoordsClient.config.showCoords())
            {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();
                coords = String.format("X: %.2f Y: %.2f Z: %.2f", x, y, z).replace(',', '.');
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(coords));
                drawContext.drawTextWithShadow(client.textRenderer, coords, posX, posY, 0xFFFFFF);
                drawCount++;

            }
            if(SimpleCoordsClient.config.showFacing())
            {
                facing = player.getHorizontalFacing().toString();
                facing = "Facing: " + facing.substring(0, 1).toUpperCase() + facing.substring(1);
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(facing));
                drawContext.drawTextWithShadow(client.textRenderer, facing, posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;

            }
            if(SimpleCoordsClient.config.showBiome())
            {
                biome = "Biome: " + player.getWorld().getBiome(player.getBlockPos()).getIdAsString();
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(biome));
                drawContext.drawTextWithShadow(client.textRenderer, biome, posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;
            }
            if(SimpleCoordsClient.config.showFPS())
            {
                fps = client.getCurrentFps() +" fps";
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(fps));
                drawContext.drawTextWithShadow(client.textRenderer, fps, posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;

            }
            if(drawCount>0)
            {
                drawContext.fill(0, 0, textWidth + padding + offset, posY + drawCount * textHeight + padding, 0x30000000);
            }
        }
    }
}