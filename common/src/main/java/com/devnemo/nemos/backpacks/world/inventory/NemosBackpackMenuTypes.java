package com.devnemo.nemos.backpacks.world.inventory;

import com.devnemo.nemos.backpacks.platform.Services;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class NemosBackpackMenuTypes {

    public static Supplier<MenuType<BackpackMenu>> DEFAULT_BACKPACK = register("default_backpack", BackpackMenu::defaultBackpack);
    public static Supplier<MenuType<BackpackMenu>> COPPER_BACKPACK = register("copper_backpack", BackpackMenu::copperBackpack);
    public static Supplier<MenuType<BackpackMenu>> IRON_BACKPACK = register("iron_backpack", BackpackMenu::ironBackpack);
    public static Supplier<MenuType<BackpackMenu>> GOLDEN_BACKPACK = register("golden_backpack", BackpackMenu::goldenBackpack);
    public static Supplier<MenuType<BackpackMenu>> DIAMOND_BACKPACK = register("diamond_backpack", BackpackMenu::diamondBackpack);
    public static Supplier<MenuType<BackpackMenu>> NETHERITE_BACKPACK = register("netherite_backpack", BackpackMenu::netheriteBackpack);

    public static void init() {}

    public static <T extends AbstractContainerMenu> Supplier<MenuType<T>> register(String id, MenuType.MenuSupplier<T> menuSupplier) {
        return Services.REGISTRY_HELPER.registerMenuType(id, menuSupplier);
    }
}
