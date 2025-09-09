package com.devnemo.nemos.backpacks.world.item;

import com.devnemo.nemos.backpacks.world.inventory.BackpackMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

//TODO: Add item entity
public class BackpackItem extends Item {

    private static final Component TITLE = Component.translatable("container.backpack");
    private final BackpackMaterial backpackMaterial;


    public BackpackItem(Properties properties, BackpackMaterial backpackMaterial) {
        super(properties);
        this.backpackMaterial = backpackMaterial;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        var itemstack = player.getItemInHand(interactionHand);
        //TODO: Open gui
        player.openMenu(createScreenHandlerFactory());
        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResult.SUCCESS;
    }

    //TODO: Testing, add filled container
    @Nullable
    public MenuProvider createScreenHandlerFactory() {
        return new SimpleMenuProvider(
                (syncId, playerInventory, player) -> switch (backpackMaterial) {
                    case STRING -> BackpackMenu.defaultBackpack(syncId, playerInventory);
                    case COPPER -> BackpackMenu.copperBackpack(syncId, playerInventory);
                    case IRON -> BackpackMenu.ironBackpack(syncId, playerInventory);
                    case GOLD -> BackpackMenu.goldenBackpack(syncId, playerInventory);
                    case DIAMOND -> BackpackMenu.diamondBackpack(syncId, playerInventory);
                    case NETHERITE -> BackpackMenu.netheriteBackpack(syncId, playerInventory);
                },
                TITLE
        );
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
