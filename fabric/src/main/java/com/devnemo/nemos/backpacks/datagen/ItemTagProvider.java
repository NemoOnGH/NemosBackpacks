package com.devnemo.nemos.backpacks.datagen;

import com.devnemo.nemos.backpacks.tags.NemosBackpackItemTags;
import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(NemosBackpackItemTags.BACKPACKS)
                .add(NemosBackpackItems.BACKPACK.get())
                .add(NemosBackpackItems.WHITE_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_BACKPACK.get())
                .add(NemosBackpackItems.RED_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_BACKPACK.get())
                .add(NemosBackpackItems.LIME_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_BACKPACK.get())
                .add(NemosBackpackItems.PINK_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.COPPER_BACKPACKS)
                .add(NemosBackpackItems.COPPER_BACKPACK.get())
                .add(NemosBackpackItems.WHITE_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.RED_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.LIME_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_COPPER_BACKPACK.get())
                .add(NemosBackpackItems.PINK_COPPER_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.IRON_BACKPACKS)
                .add(NemosBackpackItems.IRON_BACKPACK.get())
                .add(NemosBackpackItems.WHITE_IRON_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_IRON_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_IRON_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_IRON_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_IRON_BACKPACK.get())
                .add(NemosBackpackItems.RED_IRON_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_IRON_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_IRON_BACKPACK.get())
                .add(NemosBackpackItems.LIME_IRON_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_IRON_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_IRON_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_IRON_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_IRON_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_IRON_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_IRON_BACKPACK.get())
                .add(NemosBackpackItems.PINK_IRON_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.GOLDEN_BACKPACKS)
                .add(NemosBackpackItems.GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.WHITE_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.RED_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.LIME_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_GOLDEN_BACKPACK.get())
                .add(NemosBackpackItems.PINK_GOLDEN_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.DIAMOND_BACKPACKS)
                .add(NemosBackpackItems.DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.WHITE_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.RED_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.LIME_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_DIAMOND_BACKPACK.get())
                .add(NemosBackpackItems.PINK_DIAMOND_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.NETHERITE_BACKPACKS)
                .add(NemosBackpackItems.NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.WHITE_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_GRAY_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.GRAY_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.BLACK_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.BROWN_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.RED_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.ORANGE_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.YELLOW_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.LIME_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.GREEN_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.CYAN_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.LIGHT_BLUE_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.BLUE_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.PURPLE_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.MAGENTA_NETHERITE_BACKPACK.get())
                .add(NemosBackpackItems.PINK_NETHERITE_BACKPACK.get());

        getOrCreateTagBuilder(NemosBackpackItemTags.COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);
    }
}
