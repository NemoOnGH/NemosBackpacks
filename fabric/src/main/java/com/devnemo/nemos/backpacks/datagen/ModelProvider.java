package com.devnemo.nemos.backpacks.datagen;

import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModelProvider extends FabricModelProvider {

    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.WHITE_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_GRAY_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GRAY_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLACK_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BROWN_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.RED_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.ORANGE_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.YELLOW_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIME_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.GREEN_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.CYAN_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.LIGHT_BLUE_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.BLUE_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PURPLE_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.MAGENTA_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_COPPER_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_IRON_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_GOLDEN_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_DIAMOND_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.PINK_NETHERITE_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
    }
}
