package net.r4mble.simplecoords.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.r4mble.simplecoords.SimpleCoordsClient;

@Environment(EnvType.CLIENT)
public class CoordsHud implements HudRenderCallback {
    int posX = 2;
    int posY = 2;
    int padding = 2;
    int offset = 5;

    @Override
    public void onHudRender(MatrixStack matrixStack, float v) {
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
            if (SimpleCoordsClient.config.showCoords()) {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();
                coords = String.format("X: %.2f Y: %.2f Z: %.2f", x, y, z).replace(',', '.');
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(coords));
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, Text.literal(coords), posX, posY, 0xFFFFFF);
                drawCount++;

            }
            if (SimpleCoordsClient.config.showFacing()) {
                facing = player.getHorizontalFacing().toString();
                facing = "Facing: " + facing.substring(0, 1).toUpperCase() + facing.substring(1);
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(facing));
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, Text.literal(facing), posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;

            }
            if (SimpleCoordsClient.config.showBiome()) {
                biome = "Biome: " + player.getWorld().getBiome(player.getBlockPos()).getKey().get().getValue().toString();
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(biome));
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, Text.literal(biome), posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;
            }
            if (SimpleCoordsClient.config.showFPS()) {
                fps = client.fpsDebugString + " fps";
                textWidth = Math.max(textWidth, client.textRenderer.getWidth(fps));
                DrawableHelper.drawTextWithShadow(matrixStack, client.textRenderer, Text.literal(fps), posX, posY + drawCount * textHeight + 1, 0xFFFFFF);
                drawCount++;

            }
            if (drawCount > 0) {
                DrawableHelper.fill(matrixStack, 0, 0, textWidth + padding + offset, posY + drawCount * textHeight + padding, 0x30000000);
            }
        }
    }
}