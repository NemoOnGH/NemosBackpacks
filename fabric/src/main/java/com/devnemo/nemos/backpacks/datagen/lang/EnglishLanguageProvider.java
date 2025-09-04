package com.devnemo.nemos.backpacks.datagen.lang;

import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

public class EnglishLanguageProvider extends FabricLanguageProvider {

    public EnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(NemosBackpackItems.BACKPACK.get(), "Backpack");
        translationBuilder.add(NemosBackpackItems.COPPER_BACKPACK.get(), "Copper Backpack");
        translationBuilder.add(NemosBackpackItems.IRON_BACKPACK.get(), "Iron Backpack");
        translationBuilder.add(NemosBackpackItems.GOLDEN_BACKPACK.get(), "Golden Backpack");
        translationBuilder.add(NemosBackpackItems.DIAMOND_BACKPACK.get(), "Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.NETHERITE_BACKPACK.get(), "Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_BACKPACK.get(), "White Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_COPPER_BACKPACK.get(), "White Copper Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_IRON_BACKPACK.get(), "White Iron Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_GOLDEN_BACKPACK.get(), "White Golden Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_DIAMOND_BACKPACK.get(), "White Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.WHITE_NETHERITE_BACKPACK.get(), "White Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_BACKPACK.get(), "Light Gray Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_COPPER_BACKPACK.get(), "Light Gray Copper Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_IRON_BACKPACK.get(), "Light Gray Iron Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_GOLDEN_BACKPACK.get(), "Light Gray Golden Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_DIAMOND_BACKPACK.get(), "Light Gray Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_GRAY_NETHERITE_BACKPACK.get(), "Light Gray Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_BACKPACK.get(), "Gray Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_COPPER_BACKPACK.get(), "Gray Copper Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_IRON_BACKPACK.get(), "Gray Iron Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_GOLDEN_BACKPACK.get(), "Gray Golden Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_DIAMOND_BACKPACK.get(), "Gray Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.GRAY_NETHERITE_BACKPACK.get(), "Gray Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_BACKPACK.get(), "Black Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_COPPER_BACKPACK.get(), "Black Copper Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_IRON_BACKPACK.get(), "Black Iron Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_GOLDEN_BACKPACK.get(), "Black Golden Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_DIAMOND_BACKPACK.get(), "Black Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.BLACK_NETHERITE_BACKPACK.get(), "Black Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_BACKPACK.get(), "Brown Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_COPPER_BACKPACK.get(), "Brown Copper Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_IRON_BACKPACK.get(), "Brown Iron Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_GOLDEN_BACKPACK.get(), "Brown Golden Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_DIAMOND_BACKPACK.get(), "Brown Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.BROWN_NETHERITE_BACKPACK.get(), "Brown Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.RED_BACKPACK.get(), "Red Backpack");
        translationBuilder.add(NemosBackpackItems.RED_COPPER_BACKPACK.get(), "Red Copper Backpack");
        translationBuilder.add(NemosBackpackItems.RED_IRON_BACKPACK.get(), "Red Iron Backpack");
        translationBuilder.add(NemosBackpackItems.RED_GOLDEN_BACKPACK.get(), "Red Golden Backpack");
        translationBuilder.add(NemosBackpackItems.RED_DIAMOND_BACKPACK.get(), "Red Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.RED_NETHERITE_BACKPACK.get(), "Red Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_BACKPACK.get(), "Orange Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_COPPER_BACKPACK.get(), "Orange Copper Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_IRON_BACKPACK.get(), "Orange Iron Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_GOLDEN_BACKPACK.get(), "Orange Golden Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_DIAMOND_BACKPACK.get(), "Orange Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.ORANGE_NETHERITE_BACKPACK.get(), "Orange Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_BACKPACK.get(), "Yellow Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_COPPER_BACKPACK.get(), "Yellow Copper Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_IRON_BACKPACK.get(), "Yellow Iron Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_GOLDEN_BACKPACK.get(), "Yellow Golden Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_DIAMOND_BACKPACK.get(), "Yellow Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.YELLOW_NETHERITE_BACKPACK.get(), "Yellow Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_BACKPACK.get(), "Lime Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_COPPER_BACKPACK.get(), "Lime Copper Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_IRON_BACKPACK.get(), "Lime Iron Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_GOLDEN_BACKPACK.get(), "Lime Golden Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_DIAMOND_BACKPACK.get(), "Lime Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.LIME_NETHERITE_BACKPACK.get(), "Lime Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_BACKPACK.get(), "Green Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_COPPER_BACKPACK.get(), "Green Copper Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_IRON_BACKPACK.get(), "Green Iron Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_GOLDEN_BACKPACK.get(), "Green Golden Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_DIAMOND_BACKPACK.get(), "Green Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.GREEN_NETHERITE_BACKPACK.get(), "Green Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_BACKPACK.get(), "Cyan Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_COPPER_BACKPACK.get(), "Cyan Copper Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_IRON_BACKPACK.get(), "Cyan Iron Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_GOLDEN_BACKPACK.get(), "Cyan Golden Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_DIAMOND_BACKPACK.get(), "Cyan Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.CYAN_NETHERITE_BACKPACK.get(), "Cyan Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_BACKPACK.get(), "Light Blue Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_COPPER_BACKPACK.get(), "Light_Blue Copper Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_IRON_BACKPACK.get(), "Light Blue Iron Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_GOLDEN_BACKPACK.get(), "Light Blue Golden Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_DIAMOND_BACKPACK.get(), "Light Blue Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.LIGHT_BLUE_NETHERITE_BACKPACK.get(), "Light Blue Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_BACKPACK.get(), "Blue Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_COPPER_BACKPACK.get(), "Blue Copper Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_IRON_BACKPACK.get(), "Blue Iron Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_GOLDEN_BACKPACK.get(), "Blue Golden Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_DIAMOND_BACKPACK.get(), "Blue Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.BLUE_NETHERITE_BACKPACK.get(), "Blue Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_BACKPACK.get(), "Purple Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_COPPER_BACKPACK.get(), "Purple Copper Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_IRON_BACKPACK.get(), "Purple Iron Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_GOLDEN_BACKPACK.get(), "Purple Golden Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_DIAMOND_BACKPACK.get(), "Purple Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.PURPLE_NETHERITE_BACKPACK.get(), "Purple Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_BACKPACK.get(), "Magenta Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_COPPER_BACKPACK.get(), "Magenta Copper Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_IRON_BACKPACK.get(), "Magenta Iron Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_GOLDEN_BACKPACK.get(), "Magenta Golden Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_DIAMOND_BACKPACK.get(), "Magenta Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.MAGENTA_NETHERITE_BACKPACK.get(), "Magenta Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_BACKPACK.get(), "Pink Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_COPPER_BACKPACK.get(), "Pink Copper Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_IRON_BACKPACK.get(), "Pink Iron Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_GOLDEN_BACKPACK.get(), "Pink Golden Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_DIAMOND_BACKPACK.get(), "Pink Diamond Backpack");
        translationBuilder.add(NemosBackpackItems.PINK_NETHERITE_BACKPACK.get(), "Pink Netherite Backpack");
        translationBuilder.add(NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get(), "Copper Upgrade");
        translationBuilder.add("item.nemos_backpacks.smithing_template.copper_upgrade.applies_to", "Default Backpack");
        translationBuilder.add("item.nemos_backpacks.smithing_template.copper_upgrade.additions_slot_description", "Add Copper Ingot");
        translationBuilder.add("item.nemos_backpacks.smithing_template.copper_upgrade.base_slot_description", "Add Default Backpack");
        translationBuilder.add("item.nemos_backpacks.smithing_template.copper_upgrade.ingredients", "Copper Ingot");
        translationBuilder.add(NemosBackpackItems.IRON_UPGRADE_SMITHING_TEMPLATE.get(), "Iron Upgrade");
        translationBuilder.add("item.nemos_backpacks.smithing_template.iron_upgrade.applies_to", "Default Backpack");
        translationBuilder.add("item.nemos_backpacks.smithing_template.iron_upgrade.additions_slot_description", "Add Iron Ingot");
        translationBuilder.add("item.nemos_backpacks.smithing_template.iron_upgrade.base_slot_description", "Add Default Backpack");
        translationBuilder.add("item.nemos_backpacks.smithing_template.iron_upgrade.ingredients", "Iron Ingot");

        translationBuilder.add("itemGroup." + MOD_ID, "Nemo's Backpacks");
    }
}
