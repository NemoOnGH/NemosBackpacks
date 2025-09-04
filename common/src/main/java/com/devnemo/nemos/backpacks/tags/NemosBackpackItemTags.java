package com.devnemo.nemos.backpacks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

public class NemosBackpackItemTags {

    public static final TagKey<Item> BACKPACKS = create("backpacks");
    public static final TagKey<Item> COPPER_BACKPACKS = create("copper_backpacks");
    public static final TagKey<Item> IRON_BACKPACKS = create("iron_backpacks");
    public static final TagKey<Item> GOLDEN_BACKPACKS = create("golden_backpacks");
    public static final TagKey<Item> DIAMOND_BACKPACKS = create("diamond_backpacks");
    public static final TagKey<Item> NETHERITE_BACKPACKS = create("netherite_backpacks");
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = create("copper_tool_materials");

    private static TagKey<Item> create(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
