package com.devnemo.nemos.backpacks.helper;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

public class SmithingTemplateItemHelper {

    private static final ResourceLocation EMPTY_SLOT_BACKPACK = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/slot/backpack");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("container/slot/ingot");
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component COPPER_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId(
                            "item",
                            resourceLocation("smithing_template.copper_upgrade.applies_to")
                    )
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component COPPER_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId(
                            "item",
                            resourceLocation("smithing_template.copper_upgrade.ingredients")
                    )
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component COPPER_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId(
                    "item",
                    resourceLocation("smithing_template.copper_upgrade.base_slot_description")
            )
    );
    private static final Component COPPER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId(
                    "item", 
                    resourceLocation("smithing_template.copper_upgrade.additions_slot_description")
            )
    );

    public static SmithingTemplateItem createCopperUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(COPPER_UPGRADE_APPLIES_TO, COPPER_UPGRADE_INGREDIENTS, COPPER_UPGRADE_BASE_SLOT_DESCRIPTION, COPPER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createCopperUpgradeIconList(), createCopperUpgradeMaterialList(), properties);
    }

    private static ResourceLocation resourceLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private static List<ResourceLocation> createCopperUpgradeIconList() {
        return List.of(EMPTY_SLOT_BACKPACK);
    }

    private static List<ResourceLocation> createCopperUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
