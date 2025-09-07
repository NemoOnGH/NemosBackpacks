package com.devnemo.nemos.backpacks.client.gui.screens.inventory;

import com.devnemo.nemos.backpacks.world.inventory.BackpackMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

//TODO: Register screen
public class BackpackScreen extends AbstractContainerScreen<BackpackMenu> {

    private static final ResourceLocation CONTAINER_BACKGROUND = ResourceLocation.withDefaultNamespace("textures/gui/container/generic_54.png");
    private final int containerRows;

    public BackpackScreen(BackpackMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.containerRows = menu.getRowCount();
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        super.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    //TODO: Figure out magic numbers
    //TODO: Renaming
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_BACKGROUND, i, j, 0.0F, 0.0F, this.imageWidth, this.containerRows * 18 + 17, 256, 256);
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_BACKGROUND, i, j + this.containerRows * 18 + 17, 0.0F, 126.0F, this.imageWidth, 96, 256, 256);
    }
}
