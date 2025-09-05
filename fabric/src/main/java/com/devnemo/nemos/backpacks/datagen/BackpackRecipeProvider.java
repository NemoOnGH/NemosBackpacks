package com.devnemo.nemos.backpacks.datagen;

import com.devnemo.nemos.backpacks.tags.NemosBackpackItemTags;
import com.devnemo.nemos.backpacks.world.item.BackpackItem;
import com.devnemo.nemos.backpacks.world.item.BackpackMaterial;
import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BackpackRecipeProvider extends FabricRecipeProvider {

    public BackpackRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {

            @Override
            public void buildRecipes() {
                this.shaped(RecipeCategory.TOOLS, NemosBackpackItems.BACKPACK.get())
                        .define('-', Items.STRING)
                        .define('#', Items.LEATHER)
                        .pattern("###")
                        .pattern("#-#")
                        .pattern("###")
                        .unlockedBy("has_leather", this.has(Items.LEATHER))
                        .save(this.output);

                backpackDyeRecipes(NemosBackpackItemTags.BACKPACKS, BackpackMaterial.STRING, "");
                backpackDyeRecipes(NemosBackpackItemTags.COPPER_BACKPACKS, BackpackMaterial.COPPER, "copper");
                backpackDyeRecipes(NemosBackpackItemTags.IRON_BACKPACKS, BackpackMaterial.IRON, "iron");
                backpackDyeRecipes(NemosBackpackItemTags.GOLDEN_BACKPACKS, BackpackMaterial.GOLD, "golden");
                backpackDyeRecipes(NemosBackpackItemTags.DIAMOND_BACKPACKS, BackpackMaterial.DIAMOND, "diamond");
                backpackDyeRecipes(NemosBackpackItemTags.NETHERITE_BACKPACKS, BackpackMaterial.NETHERITE, "netherite");

                copySmithingUpgradeTemplate(NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get(), Items.COBBLESTONE);
                backpackSmithingRecipes(BackpackMaterial.STRING, NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get(), NemosBackpackItemTags.COPPER_TOOL_MATERIALS, "has_copper_ingot");
                
                copySmithingUpgradeTemplate(NemosBackpackItems.IRON_UPGRADE_SMITHING_TEMPLATE.get(), Items.COPPER_INGOT);
                backpackSmithingRecipes(BackpackMaterial.COPPER, NemosBackpackItems.IRON_UPGRADE_SMITHING_TEMPLATE.get(), ItemTags.IRON_TOOL_MATERIALS, "has_iron_ingot");
                
                copySmithingUpgradeTemplate(NemosBackpackItems.GOLD_UPGRADE_SMITHING_TEMPLATE.get(), Items.IRON_INGOT);
                backpackSmithingRecipes(BackpackMaterial.IRON, NemosBackpackItems.GOLD_UPGRADE_SMITHING_TEMPLATE.get(), ItemTags.GOLD_TOOL_MATERIALS, "has_gold_ingot");
                
                copySmithingUpgradeTemplate(NemosBackpackItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.GOLD_INGOT);
                backpackSmithingRecipes(BackpackMaterial.GOLD, NemosBackpackItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), ItemTags.DIAMOND_TOOL_MATERIALS, "has_diamond");

                backpackSmithingRecipes(BackpackMaterial.DIAMOND, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ItemTags.NETHERITE_TOOL_MATERIALS, "has_netherite_ingot");
            }

            private void backpackDyeRecipes(TagKey<Item> ingredientTag, BackpackMaterial backpackMaterial, String groupPrefix) {
                var ingredient = this.tag(ingredientTag);

                if (!groupPrefix.isEmpty()) {
                    groupPrefix = groupPrefix + "_";
                }

                for (DyeColor dyeColor : DyeColor.values()) {
                    var dyeItem = DyeItem.byColor(dyeColor);
                    TransmuteRecipeBuilder.transmute(
                                    RecipeCategory.TOOLS,
                                    ingredient,
                                    Ingredient.of(dyeItem),
                                    BackpackItem.getByColorAndBackpackMaterial(dyeColor, backpackMaterial)
                            )
                            .group(groupPrefix + "backpack_dye")
                            .unlockedBy(getHasName(dyeItem), this.has(dyeItem))
                            .save(this.output);
                }
            }

            private void backpackSmithingRecipes(BackpackMaterial backpackMaterial, Item smithingTemplate, TagKey<Item> itemTag, String condition) {
                smithing(
                        smithingTemplate,
                        BackpackItem.getByBackpackMaterial(backpackMaterial),
                        itemTag,
                        condition,
                        RecipeCategory.TOOLS,
                        BackpackItem.getByBackpackMaterial(BackpackMaterial.getNextMaterialLevel(backpackMaterial))
                );

                for (DyeColor dyeColor : DyeColor.values()) {
                    smithing(
                            smithingTemplate,
                            BackpackItem.getByColorAndBackpackMaterial(dyeColor, backpackMaterial),
                            itemTag,
                            condition,
                            RecipeCategory.TOOLS,
                            BackpackItem.getByColorAndBackpackMaterial(
                                    dyeColor,
                                    BackpackMaterial.getNextMaterialLevel(backpackMaterial)
                            )
                    );
                }
            }

            private void smithing(Item smithingTemplate, Item ingredientItem, TagKey<Item> itemTag, String condition, RecipeCategory category, Item resultItem) {
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(smithingTemplate),
                                Ingredient.of(ingredientItem),
                                this.tag(itemTag),
                                category,
                                resultItem
                        )
                        .unlocks(condition, this.has(itemTag))
                        .save(this.output, getItemName(resultItem) + "_smithing");
            }

            private void copySmithingUpgradeTemplate(ItemLike template, ItemLike baseItem) {
                shaped(RecipeCategory.MISC, template, 2)
                        .define('#', baseItem)
                        .define('C', template)
                        .pattern("###")
                        .pattern("#C#")
                        .pattern("###")
                        .unlockedBy(getHasName(template), this.has(template))
                        .save(this.output);
            }
        };
    }

    @Override
    public @NotNull String getName() {
        return "Nemo's Backpacks Recipes";
    }
}
