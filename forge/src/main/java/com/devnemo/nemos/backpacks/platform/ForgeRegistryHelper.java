package com.devnemo.nemos.backpacks.platform;

import com.devnemo.nemos.backpacks.Constants;
import com.devnemo.nemos.backpacks.ForgeNemosBackpacks;
import com.devnemo.nemos.backpacks.platform.services.IRegistryHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.devnemo.nemos.backpacks.ForgeNemosBackpacks.MENU;

public class ForgeRegistryHelper implements IRegistryHelper {

    @Override
    public Supplier<Block> registerBlock(String id, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        return ForgeNemosBackpacks.BLOCKS.register(id, () -> function.apply(properties.setId(createResourceKey(Registries.BLOCK, id))));
    }

    @Override
    public Supplier<Block> registerBlock(String id, Function<BlockBehaviour.Properties, Block> function, Supplier<BlockBehaviour.Properties> properties) {
        return ForgeNemosBackpacks.BLOCKS.register(id, () -> function.apply(properties.get().setId(createResourceKey(Registries.BLOCK, id))));
    }

    @Override
    public Supplier<Item> registerItem(String id, Function<Item.Properties, Item> function, Item.Properties properties) {
        return ForgeNemosBackpacks.ITEMS.register(id, () -> function.apply(properties.setId(createResourceKey(Registries.ITEM, id))));
    }

    @Override
    public Supplier<Item> registerItem(String id, Function<Item.Properties, Item> function, Supplier<Item.Properties> properties) {
        return ForgeNemosBackpacks.ITEMS.register(id, () -> function.apply(properties.get().setId(createResourceKey(Registries.ITEM, id))));
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, EntityType.Builder<T> entityTypeBuilder) {
        var resourceLocation = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id);
        var resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, resourceLocation);

        return ForgeNemosBackpacks.ENTITIES.register(id, () -> entityTypeBuilder.build(resourceKey));
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> creativeModeTab) {
        return ForgeNemosBackpacks.CREATIVE_TABS.register(id, creativeModeTab);
    }

    @Override
    public CreativeModeTab.Builder createCreativeModeTab() {
        return CreativeModeTab.builder();
    }

    @Override
    public Supplier<KeyMapping> registerKeyMapping(KeyMapping keyMapping) {
        return () -> keyMapping;
    }

    @Override
    public Supplier<Holder<Attribute>> registerAttribute(String id, Attribute attribute) {
        var registryObject = ForgeNemosBackpacks.ATTRIBUTE.register(id, () -> attribute);

        return () -> registryObject.getHolder().get();
    }

    @Override
    public <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(String id, MenuType.MenuSupplier<T> menuSupplier) {
        return MENU.register(id, () -> new MenuType<>(menuSupplier, FeatureFlags.DEFAULT_FLAGS));
    }

    @Override
    public <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void registerMenuScreen(Supplier<MenuType<M>> menuTypeSupplier, MenuScreens.ScreenConstructor<M, U> screenConstructor) {
        MenuScreens.register(menuTypeSupplier.get(), screenConstructor);
    }

    private static <T> ResourceKey<T> createResourceKey(ResourceKey<Registry<T>> registryResourceKey, String id) {
        return ResourceKey.create(registryResourceKey, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id));
    }
}
