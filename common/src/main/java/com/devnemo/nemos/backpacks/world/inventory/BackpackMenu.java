package com.devnemo.nemos.backpacks.world.inventory;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.Container;
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
    private final ItemStack itemStack;
    private final Inventory playerInventory;

    public static BackpackMenu defaultBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DEFAULT_BACKPACK.get(), containerId, playerInventory, 1);
    }

    public static BackpackMenu defaultBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.DEFAULT_BACKPACK.get(), containerId, playerInventory, itemStack, container, 1);
    }

    public static BackpackMenu copperBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.COPPER_BACKPACK.get(), containerId, playerInventory, 2);
    }

    public static BackpackMenu copperBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.COPPER_BACKPACK.get(), containerId, playerInventory, itemStack, container, 2);
    }

    public static BackpackMenu ironBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.IRON_BACKPACK.get(), containerId, playerInventory, 3);
    }

    public static BackpackMenu ironBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.IRON_BACKPACK.get(), containerId, playerInventory, itemStack, container, 3);
    }

    public static BackpackMenu goldenBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.GOLDEN_BACKPACK.get(), containerId, playerInventory, 4);
    }

    public static BackpackMenu goldenBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.GOLDEN_BACKPACK.get(), containerId, playerInventory, itemStack, container, 4);
    }

    public static BackpackMenu diamondBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DIAMOND_BACKPACK.get(), containerId, playerInventory, 5);
    }

    public static BackpackMenu diamondBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.DIAMOND_BACKPACK.get(), containerId, playerInventory, itemStack, container, 5);
    }

    public static BackpackMenu netheriteBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.NETHERITE_BACKPACK.get(), containerId, playerInventory, 6);
    }

    public static BackpackMenu netheriteBackpack(int containerId, Inventory playerInventory, ItemStack itemStack, Container container) {
        return new BackpackMenu(NemosBackpackMenuTypes.NETHERITE_BACKPACK.get(), containerId, playerInventory, itemStack, container, 6);
    }

    private BackpackMenu(MenuType<?> type, int containerId, Inventory playerInventory, int rows) {
        this(type, containerId, playerInventory, ItemStack.EMPTY, new SimpleContainer(9 * rows), rows);
    }

    public BackpackMenu(@Nullable MenuType<?> menuType, int containerId, Inventory playerInventory, ItemStack itemStack, Container container, int rows) {
        super(menuType, containerId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        this.itemStack = itemStack;
        this.playerInventory = playerInventory;
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

        storeBackpackItems();

        return itemstack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }

    //TODO: Find better solution for workaround
    @Override
    public void clicked(int slotId, int button, @NotNull ClickType clickType, @NotNull Player player) {
        var containerSize = container.getContainerSize();
        var playerInventoryContainerSize = 27;
        var hotbarSize = 9;
        var hotbarStartIndex = containerSize + playerInventoryContainerSize;
        var hotbarEndIndex = hotbarStartIndex + hotbarSize - 1;
        var isSlotIdWithinHotbarBounds = slotId >= hotbarStartIndex && slotId <= hotbarEndIndex;

        if (
                (isSlotIdWithinHotbarBounds && playerInventory.getItem(slotId - containerSize - playerInventoryContainerSize) == itemStack) ||
                        (slotId >= 9 && clickType.equals(ClickType.SWAP) && playerInventory.getItem(button) == itemStack)
        ) {
            return;
        }

        super.clicked(slotId, button, clickType, player);

        storeBackpackItems();
    }


    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        storeBackpackItems();
        this.container.stopOpen(player);
    }

    private void storeBackpackItems() {
        List<ItemStack> containerItems = new ArrayList<>();

        for (int i = 0; i < container.getContainerSize(); i++) {
            containerItems.add(container.getItem(i));
        }

        itemStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(containerItems));
    }

    public int getRowCount() {
        return this.containerRows;
    }
}
