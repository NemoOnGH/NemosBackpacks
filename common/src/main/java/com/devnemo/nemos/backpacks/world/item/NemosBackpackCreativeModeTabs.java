package com.devnemo.nemos.backpacks.world.item;

import com.devnemo.nemos.backpacks.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;
import static com.devnemo.nemos.backpacks.world.item.NemosBackpackItems.*;

public class NemosBackpackCreativeModeTabs {

    public static Supplier<CreativeModeTab> NEMOS_BACKPACKS = register(
            "itemGroup." + MOD_ID,
            GOLDEN_BACKPACK,
            List.of(
                    BACKPACK,
                    COPPER_BACKPACK,
                    IRON_BACKPACK,
                    GOLDEN_BACKPACK,
                    DIAMOND_BACKPACK,
                    NETHERITE_BACKPACK,
                    WHITE_BACKPACK,
                    WHITE_COPPER_BACKPACK,
                    WHITE_IRON_BACKPACK,
                    WHITE_GOLDEN_BACKPACK,
                    WHITE_DIAMOND_BACKPACK,
                    WHITE_NETHERITE_BACKPACK,
                    LIGHT_GRAY_BACKPACK,
                    LIGHT_GRAY_COPPER_BACKPACK,
                    LIGHT_GRAY_IRON_BACKPACK,
                    LIGHT_GRAY_GOLDEN_BACKPACK,
                    LIGHT_GRAY_DIAMOND_BACKPACK,
                    LIGHT_GRAY_NETHERITE_BACKPACK,
                    GRAY_BACKPACK,
                    GRAY_COPPER_BACKPACK,
                    GRAY_IRON_BACKPACK,
                    GRAY_GOLDEN_BACKPACK,
                    GRAY_DIAMOND_BACKPACK,
                    GRAY_NETHERITE_BACKPACK,
                    BLACK_BACKPACK,
                    BLACK_COPPER_BACKPACK,
                    BLACK_IRON_BACKPACK,
                    BLACK_GOLDEN_BACKPACK,
                    BLACK_DIAMOND_BACKPACK,
                    BLACK_NETHERITE_BACKPACK,
                    BROWN_BACKPACK,
                    BROWN_COPPER_BACKPACK,
                    BROWN_IRON_BACKPACK,
                    BROWN_GOLDEN_BACKPACK,
                    BROWN_DIAMOND_BACKPACK,
                    BROWN_NETHERITE_BACKPACK,
                    RED_BACKPACK,
                    RED_COPPER_BACKPACK,
                    RED_IRON_BACKPACK,
                    RED_GOLDEN_BACKPACK,
                    RED_DIAMOND_BACKPACK,
                    RED_NETHERITE_BACKPACK,
                    ORANGE_BACKPACK,
                    ORANGE_COPPER_BACKPACK,
                    ORANGE_IRON_BACKPACK,
                    ORANGE_GOLDEN_BACKPACK,
                    ORANGE_DIAMOND_BACKPACK,
                    ORANGE_NETHERITE_BACKPACK,
                    YELLOW_BACKPACK,
                    YELLOW_COPPER_BACKPACK,
                    YELLOW_IRON_BACKPACK,
                    YELLOW_GOLDEN_BACKPACK,
                    YELLOW_DIAMOND_BACKPACK,
                    YELLOW_NETHERITE_BACKPACK,
                    LIME_BACKPACK,
                    LIME_COPPER_BACKPACK,
                    LIME_IRON_BACKPACK,
                    LIME_GOLDEN_BACKPACK,
                    LIME_DIAMOND_BACKPACK,
                    LIME_NETHERITE_BACKPACK,
                    GREEN_BACKPACK,
                    GREEN_COPPER_BACKPACK,
                    GREEN_IRON_BACKPACK,
                    GREEN_GOLDEN_BACKPACK,
                    GREEN_DIAMOND_BACKPACK,
                    GREEN_NETHERITE_BACKPACK,
                    CYAN_BACKPACK,
                    CYAN_COPPER_BACKPACK,
                    CYAN_IRON_BACKPACK,
                    CYAN_GOLDEN_BACKPACK,
                    CYAN_DIAMOND_BACKPACK,
                    CYAN_NETHERITE_BACKPACK,
                    LIGHT_BLUE_BACKPACK,
                    LIGHT_BLUE_COPPER_BACKPACK,
                    LIGHT_BLUE_IRON_BACKPACK,
                    LIGHT_BLUE_GOLDEN_BACKPACK,
                    LIGHT_BLUE_DIAMOND_BACKPACK,
                    LIGHT_BLUE_NETHERITE_BACKPACK,
                    BLUE_BACKPACK,
                    BLUE_COPPER_BACKPACK,
                    BLUE_IRON_BACKPACK,
                    BLUE_GOLDEN_BACKPACK,
                    BLUE_DIAMOND_BACKPACK,
                    BLUE_NETHERITE_BACKPACK,
                    PURPLE_BACKPACK,
                    PURPLE_COPPER_BACKPACK,
                    PURPLE_IRON_BACKPACK,
                    PURPLE_GOLDEN_BACKPACK,
                    PURPLE_DIAMOND_BACKPACK,
                    PURPLE_NETHERITE_BACKPACK,
                    MAGENTA_BACKPACK,
                    MAGENTA_COPPER_BACKPACK,
                    MAGENTA_IRON_BACKPACK,
                    MAGENTA_GOLDEN_BACKPACK,
                    MAGENTA_DIAMOND_BACKPACK,
                    MAGENTA_NETHERITE_BACKPACK,
                    PINK_BACKPACK,
                    PINK_COPPER_BACKPACK,
                    PINK_IRON_BACKPACK,
                    PINK_GOLDEN_BACKPACK,
                    PINK_DIAMOND_BACKPACK,
                    PINK_NETHERITE_BACKPACK,
                    COPPER_UPGRADE_SMITHING_TEMPLATE,
                    IRON_UPGRADE_SMITHING_TEMPLATE,
                    GOLD_UPGRADE_SMITHING_TEMPLATE,
                    DIAMOND_UPGRADE_SMITHING_TEMPLATE
            )
    );

    public static void init() {
    }

    private static Supplier<CreativeModeTab> register(String title, Supplier<Item> itemSupplier, List<Supplier<Item>> dispalyItemSuppliers) {
        return Services.REGISTRY_HELPER.registerCreativeModeTab(MOD_ID, () -> Services.REGISTRY_HELPER.createCreativeModeTab()
                .title(Component.translatable(title))
                .icon(() -> new ItemStack(itemSupplier.get()))
                .displayItems((parameters, output) -> {
                    for (Supplier<Item> displayItemSupplier : dispalyItemSuppliers) {
                        output.accept(displayItemSupplier.get());
                    }
                })
                .build());
    }
}
