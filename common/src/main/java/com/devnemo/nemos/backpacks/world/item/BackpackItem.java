package com.devnemo.nemos.backpacks.world.item;

import com.devnemo.nemos.backpacks.tags.NemosBackpackItemTags;
import com.devnemo.nemos.backpacks.world.inventory.BackpackMenu;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

public class BackpackItem extends Item {

    private static final Component TITLE = Component.translatable(MOD_ID + ".container.backpack");
    private final BackpackMaterial backpackMaterial;

    public BackpackItem(Properties properties, BackpackMaterial backpackMaterial) {
        super(properties);
        this.backpackMaterial = backpackMaterial;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        player.openMenu(createScreenHandlerFactory(player, interactionHand));
        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResult.SUCCESS;
    }

    @Nullable
    public MenuProvider createScreenHandlerFactory(Player player, @NotNull InteractionHand interactionHand) {
        var itemStack = player.getItemInHand(interactionHand);
        var components = itemStack.getComponents();
        var itemContainerContents = components.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        var slotCountPerRow = 9;
        var container = new SimpleContainer(slotCountPerRow * getRowCount());
        var items = itemContainerContents.stream().toList();

        for (int i = 0; i < items.size(); i++) {
            container.setItem(i, items.get(i));
        }

        return new SimpleMenuProvider(
                (syncId, playerInventory, player1) -> switch (backpackMaterial) {
                    case STRING -> BackpackMenu.defaultBackpack(syncId, playerInventory, itemStack, container);
                    case COPPER -> BackpackMenu.copperBackpack(syncId, playerInventory, itemStack, container);
                    case IRON -> BackpackMenu.ironBackpack(syncId, playerInventory, itemStack, container);
                    case GOLD -> BackpackMenu.goldenBackpack(syncId, playerInventory, itemStack, container);
                    case DIAMOND -> BackpackMenu.diamondBackpack(syncId, playerInventory, itemStack, container);
                    case NETHERITE -> BackpackMenu.netheriteBackpack(syncId, playerInventory, itemStack, container);
                },
                TITLE
        );
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        var itemContainerContents = this.components().getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);

        itemEntity.getItem().set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        ItemUtils.onContainerDestroyed(itemEntity, itemContainerContents.nonEmptyItemsCopy());
    }

    public boolean overrideStackedOnOther(@NotNull ItemStack backpack, @NotNull Slot slot, @NotNull ClickAction action, @NotNull Player player) {
        return overrideStackingLogic(backpack, slot.getItem(), slot, false, action, player);
    }

    public boolean overrideOtherStackedOnMe(@NotNull ItemStack backpack, @NotNull ItemStack other, @NotNull Slot slot, @NotNull ClickAction action, @NotNull Player player, @NotNull SlotAccess access) {
        return overrideStackingLogic(backpack, other, slot, true, action, player);
    }

    private boolean overrideStackingLogic(ItemStack backpack, ItemStack other, Slot slot, boolean isSlotModified, ClickAction action, Player player) {
        if (other.is(NemosBackpackItemTags.BACKPACKS) || action != ClickAction.PRIMARY || other.isEmpty()) {
            return false;
        }

        var itemContainerContents = backpack.get(DataComponents.CONTAINER);

        if (itemContainerContents == null) {
            return false;
        }

        var container = getContainer(itemContainerContents);

        if ((!isSlotModified || slot.allowModification(player)) && tryMoveItem(container, other)) {
            playInsertSound(player);
        } else {
            playInsertFailSound(player);
        }

        storeItemsIntoBackpack(container, backpack, player);

        return true;
    }

    private SimpleContainer getContainer(ItemContainerContents itemContainerContents) {
        var slotCountPerRow = 9;
        var container = new SimpleContainer(slotCountPerRow * getRowCount());
        var items = itemContainerContents.stream().toList();

        for (int i = 0; i < items.size(); i++) {
            container.setItem(i, items.get(i));
        }

        return container;
    }

    private boolean tryMoveItem(SimpleContainer container, ItemStack itemToMove) {
        var remainingStack = container.addItem(itemToMove);
        var itemWasMoved = remainingStack.isEmpty() || remainingStack.getCount() != itemToMove.getCount();

        if (!itemWasMoved) {
            return false;
        }

        itemToMove.setCount(remainingStack.getCount());

        return true;
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertFailSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT_FAIL, 1.0F, 1.0F);
    }

    private void storeItemsIntoBackpack(SimpleContainer container, ItemStack backpack, Player player) {
        var containerItems = new ArrayList<ItemStack>();

        for (int i = 0; i < container.getContainerSize(); i++) {
            containerItems.add(container.getItem(i));
        }

        backpack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(containerItems));
        this.broadcastChangesOnContainerMenu(player);
    }

    private void broadcastChangesOnContainerMenu(Player player) {
        AbstractContainerMenu abstractContainerMenu = player.containerMenu;
        abstractContainerMenu.slotsChanged(player.getInventory());
    }

    private int getRowCount() {
        return switch (backpackMaterial) {
            case STRING -> 1;
            case COPPER -> 2;
            case IRON -> 3;
            case GOLD -> 4;
            case DIAMOND -> 5;
            case NETHERITE -> 6;
        };
    }

    public static Item getByColorAndBackpackMaterial(DyeColor color, BackpackMaterial backpackMaterial) {
        var resourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, getItemName(color, backpackMaterial));
        var item = BuiltInRegistries.ITEM.getValue(resourceLocation);

        if (item == Items.AIR) {
            throw new IllegalArgumentException("Missing item: " + resourceLocation);
        }

        return item;
    }

    public static Item getByBackpackMaterial(BackpackMaterial backpackMaterial) {
        var resourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, getItemName(backpackMaterial));
        var item = BuiltInRegistries.ITEM.getValue(resourceLocation);

        if (item == Items.AIR) {
            throw new IllegalArgumentException("Missing item: " + resourceLocation);
        }

        return item;
    }

    private static String getItemName(DyeColor color, BackpackMaterial backpackMaterial) {
        var materialPrefix = switch (backpackMaterial) {
            case STRING -> "";
            case COPPER -> "copper";
            case IRON -> "iron";
            case GOLD -> "golden";
            case DIAMOND -> "diamond";
            case NETHERITE -> "netherite";
        };

        return color.getName() + (!materialPrefix.isEmpty() ? "_" + materialPrefix : "") + "_backpack";
    }

    private static String getItemName(BackpackMaterial backpackMaterial) {
        var materialPrefix = switch (backpackMaterial) {
            case STRING -> "";
            case COPPER -> "copper";
            case IRON -> "iron";
            case GOLD -> "golden";
            case DIAMOND -> "diamond";
            case NETHERITE -> "netherite";
        };

        return (!materialPrefix.isEmpty() ? materialPrefix + "_" : "") + "backpack";
    }
}
