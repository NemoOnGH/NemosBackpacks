package com.devnemo.nemos.backpacks.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

import static com.devnemo.nemos.backpacks.Constants.MOD_ID;

@Mixin(SmithingTemplateItem.class)
public class SmithingTemplateItemMixin {

    @Unique
    private static final ResourceLocation EMPTY_SLOT_BACKPACK = ResourceLocation.fromNamespaceAndPath(MOD_ID, "container/slot/backpack");

    @ModifyReturnValue(method = "createNetheriteUpgradeIconList", at = @At("RETURN"))
    private static List<ResourceLocation> addBackpackToNetheriteUpgradeIconList(List<ResourceLocation> original) {
        List<ResourceLocation> emptyIcons = new ArrayList<>(original);
        emptyIcons.add(EMPTY_SLOT_BACKPACK);

        return emptyIcons;
    }
}
