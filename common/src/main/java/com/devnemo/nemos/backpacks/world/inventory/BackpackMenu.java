package com.devnemo.nemos.backpacks.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: register menu
public class BackpackMenu extends AbstractContainerMenu {

    private final Container container;
    private final int containerRows;

    public static BackpackMenu defaultBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DEFAULT_BACKPACK, containerId, playerInventory, 1);
    }

    public static BackpackMenu copperBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.COPPER_BACKPACK, containerId, playerInventory, 2);
    }

    public static BackpackMenu ironBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.IRON_BACKPACK, containerId, playerInventory, 3);
    }

    public static BackpackMenu goldenBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.GOLDEN_BACKPACK, containerId, playerInventory, 4);
    }

    public static BackpackMenu diamondBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.DIAMOND_BACKPACK, containerId, playerInventory, 5);
    }

    public static BackpackMenu netheriteBackpack(int containerId, Inventory playerInventory) {
        return new BackpackMenu(NemosBackpackMenuTypes.NETHERITE_BACKPACK, containerId, playerInventory, 6);
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

        int i = 18;
        this.addBackpackGrid(container, 8, 18);
        int j = 18 + this.containerRows * 18 + 13;
        this.addStandardInventorySlots(playerInventory, 8, j);
    }

    private void addBackpackGrid(Container container, int x, int y) {
        for (int i = 0; i < this.containerRows; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(container, j + i * 9, x + j * 18, y + i * 18));
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
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}
