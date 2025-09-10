package com.devnemo.nemos.backpacks.mixin;

import com.devnemo.nemos.backpacks.world.item.BackpackItem;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow public abstract Item asItem();

    @ModifyReturnValue(method = "canFitInsideContainerItems", at = @At("RETURN"))
    private boolean canFitInsideContainerItems(boolean original) {
        return original && !(asItem() instanceof BackpackItem);
    }
}
