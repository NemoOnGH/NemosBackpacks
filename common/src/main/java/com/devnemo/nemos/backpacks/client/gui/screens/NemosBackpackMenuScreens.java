package com.devnemo.nemos.backpacks.client.gui.screens;

import com.devnemo.nemos.backpacks.client.gui.screens.inventory.BackpackScreen;
import com.devnemo.nemos.backpacks.platform.Services;
import com.devnemo.nemos.backpacks.world.inventory.NemosBackpackMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class NemosBackpackMenuScreens {

    public static void init() {
        register(NemosBackpackMenuTypes.DEFAULT_BACKPACK, BackpackScreen::new);
        register(NemosBackpackMenuTypes.COPPER_BACKPACK, BackpackScreen::new);
        register(NemosBackpackMenuTypes.IRON_BACKPACK, BackpackScreen::new);
        register(NemosBackpackMenuTypes.GOLDEN_BACKPACK, BackpackScreen::new);
        register(NemosBackpackMenuTypes.DIAMOND_BACKPACK, BackpackScreen::new);
        register(NemosBackpackMenuTypes.NETHERITE_BACKPACK, BackpackScreen::new);
    }

    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(Supplier<MenuType<M>> menuTypeSupplier, MenuScreens.ScreenConstructor<M, U> screenConstructor) {
        Services.REGISTRY_HELPER.registerMenuScreen(menuTypeSupplier, screenConstructor);
    }
}
