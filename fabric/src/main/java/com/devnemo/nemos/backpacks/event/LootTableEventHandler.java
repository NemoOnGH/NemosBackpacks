package com.devnemo.nemos.backpacks.event;

import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableEventHandler {

    public static void handleLootTableEvent() {
        LootTableEvents.MODIFY.register(
                (resourceKey, builder, lootTableSource, provider) -> {
                    if (
                            resourceKey == BuiltInLootTables.ABANDONED_MINESHAFT ||
                                    resourceKey == BuiltInLootTables.SHIPWRECK_TREASURE ||
                                    resourceKey == BuiltInLootTables.SIMPLE_DUNGEON ||
                                    resourceKey == BuiltInLootTables.UNDERWATER_RUIN_BIG
                    ) {
                        builder.pool(createUpgradeTemplateLootPool(5, 2));
                    }

                    if (resourceKey == BuiltInLootTables.BURIED_TREASURE) {
                        builder.pool(createUpgradeTemplateLootPool(2, 5));
                    }

                    if (resourceKey == BuiltInLootTables.ANCIENT_CITY) {
                        builder.pool(createUpgradeTemplateLootPool(5, 9));
                    }

                    if (
                            resourceKey == BuiltInLootTables.DESERT_PYRAMID ||
                                    resourceKey == BuiltInLootTables.JUNGLE_TEMPLE ||
                                    resourceKey == BuiltInLootTables.PILLAGER_OUTPOST
                    ) {
                        builder.pool(createUpgradeTemplateLootPool(3, 1));
                    }

                    if (resourceKey == BuiltInLootTables.UNDERWATER_RUIN_SMALL) {
                        builder.pool(createCommonUpgradeTemplateLootPool(2));
                    }

                    if (
                            resourceKey == BuiltInLootTables.VILLAGE_WEAPONSMITH ||
                                    resourceKey == BuiltInLootTables.VILLAGE_TOOLSMITH
                    ) {
                        builder.pool(createCommonUpgradeTemplateLootPool(1));
                    }

                    if (resourceKey == BuiltInLootTables.WOODLAND_MANSION) {
                        builder.pool(createUpgradeTemplateLootPool(4, 6));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE) {
                        builder.pool(createRareUpgradeTemplateLootPool(5));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON) {
                        builder.pool(createCommonUpgradeTemplateLootPool(4));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE) {
                        builder.pool(createRareUpgradeTemplateLootPool(7));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE) {
                        builder.pool(createRareUpgradeTemplateLootPool(6));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON) {
                        builder.pool(createCommonUpgradeTemplateLootPool(5));
                    }

                    if (resourceKey == BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE) {
                        builder.pool(createRareUpgradeTemplateLootPool(8));
                    }
                }
        );
    }

    private static LootPool createCommonUpgradeTemplateLootPool(int commonWeight) {
        var fullWeight = 100;
        var emptyItemWeight = fullWeight - (2 * commonWeight);

        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(commonWeight))
                .add(LootItem.lootTableItem(NemosBackpackItems.IRON_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(commonWeight))
                .add(EmptyLootItem.emptyItem().setWeight(emptyItemWeight))
                .build();
    }

    private static LootPool createRareUpgradeTemplateLootPool(int rareWeight) {
        var fullWeight = 100;
        var emptyItemWeight = fullWeight - (2 * rareWeight);

        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(NemosBackpackItems.GOLD_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(rareWeight))
                .add(LootItem.lootTableItem(NemosBackpackItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(rareWeight))
                .add(EmptyLootItem.emptyItem().setWeight(emptyItemWeight))
                .build();
    }

    private static LootPool createUpgradeTemplateLootPool(int commonWeight, int rareWeight) {
        var fullWeight = 100;
        var emptyItemWeight = fullWeight - (2 * commonWeight) - (2 * rareWeight);

        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(NemosBackpackItems.COPPER_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(commonWeight))
                .add(LootItem.lootTableItem(NemosBackpackItems.IRON_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(commonWeight))
                .add(LootItem.lootTableItem(NemosBackpackItems.GOLD_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(rareWeight))
                .add(LootItem.lootTableItem(NemosBackpackItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(rareWeight))
                .add(EmptyLootItem.emptyItem().setWeight(emptyItemWeight))
                .build();
    }
}
