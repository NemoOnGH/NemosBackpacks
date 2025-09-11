package com.devnemo.nemos.backpacks.world.inventory;

import com.devnemo.nemos.backpacks.world.item.BackpackItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BackpackMenu extends AbstractContainerMenu {

    private final Container container;
    private final int containerRows;

    public static BackpackMenu defaultBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DEFAULT_BACKPACK.get(), containerId, playerInventory, 1);
    }

    public static BackpackMenu defaultBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.DEFAULT_BACKPACK.get(), containerId, playerInventory, container, 1);
    }

    public static BackpackMenu copperBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.COPPER_BACKPACK.get(), containerId, playerInventory, 2);
    }

    public static BackpackMenu copperBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.COPPER_BACKPACK.get(), containerId, playerInventory, container, 2);
    }

    public static BackpackMenu ironBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.IRON_BACKPACK.get(), containerId, playerInventory, 3);
    }

    public static BackpackMenu ironBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.IRON_BACKPACK.get(), containerId, playerInventory, container, 3);
    }

    public static BackpackMenu goldenBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.GOLDEN_BACKPACK.get(), containerId, playerInventory, 4);
    }

    public static BackpackMenu goldenBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.GOLDEN_BACKPACK.get(), containerId, playerInventory, container, 4);
    }

    public static BackpackMenu diamondBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DIAMOND_BACKPACK.get(), containerId, playerInventory, 5);
    }

    public static BackpackMenu diamondBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.DIAMOND_BACKPACK.get(), containerId, playerInventory, container, 5);
    }

    public static BackpackMenu netheriteBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.NETHERITE_BACKPACK.get(), containerId, playerInventory, 6);
    }

    public static BackpackMenu netheriteBackpack(int containerId, Inventory playerInventory, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.NETHERITE_BACKPACK.get(), containerId, playerInventory, container, 6);
    }

    private BackpackMenu(MenuType<?> type, int containerId, Inventory playerInventory, int rows) {
        this(type, containerId, playerInventory, new SimpleContainer(9 * rows), rows);
    }

    public BackpackMenu(@Nullable MenuType<?> menuType, int containerId, Inventory playerInventory, Container container, int rows) {
        super(menuType, containerId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(playerInventory.player);

        var xOffset = 8;
        var yOffset = 18;
        var gapBetweenContainerAndInventory = 13;

        this.addBackpackGrid(container, xOffset, yOffset);
        int inventoryYOffset = yOffset + this.containerRows * yOffset + gapBetweenContainerAndInventory;
        this.addStandardInventorySlots(playerInventory, xOffset, inventoryYOffset);
    }

    private void addBackpackGrid(Container container, int xOffset, int yOffset) {
        var slotCountPerRow = 9;

        for (int rowIndex = 0; rowIndex < this.containerRows; rowIndex++) {
            for (int slotIndex = 0; slotIndex < slotCountPerRow; slotIndex++) {
                this.addSlot(new BackpackSlot(container, slotIndex + rowIndex * slotCountPerRow, xOffset + slotIndex * yOffset, yOffset + rowIndex * yOffset));
            }
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        var itemstack = ItemStack.EMPTY;
        var slot = this.slots.get(index);

        if (slot.hasItem()) {
            var slotItemStack = slot.getItem();
            itemstack = slotItemStack.copy();

            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(slotItemStack, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (slotItemStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public void clicked(int slotId, int button, @NotNull ClickType clickType, @NotNull Player player) {
        super.clicked(slotId, button, clickType, player);

        storeBackpackItems(player);
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        storeBackpackItems(player);
        this.container.stopOpen(player);
    }

    private void storeBackpackItems(Player player) {
        List<ItemStack> containerItems = new ArrayList<>();

        for (int i = 0; i < container.getContainerSize(); i++) {
            containerItems.add(container.getItem(i));
        }

        var backpackItemStack = getBackpackItemInHand(player);

        backpackItemStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(containerItems));
    }

    private ItemStack getBackpackItemInHand(Player player) {
        var itemInMainHand = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (itemInMainHand.getItem() instanceof BackpackItem) {
            return itemInMainHand;
        }

        return player.getItemInHand(InteractionHand.OFF_HAND);
    }

    public int getRowCount() {
        return this.containerRows;
    }
}
