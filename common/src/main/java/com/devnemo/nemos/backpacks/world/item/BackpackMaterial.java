package com.devnemo.nemos.backpacks.world.item;

public enum BackpackMaterial {

    STRING,
    COPPER,
    IRON,
    GOLD,
    DIAMOND,
    NETHERITE;

    public static BackpackMaterial getNextMaterialLevel(BackpackMaterial backpackMaterial) {
        return switch (backpackMaterial) {
            case STRING -> COPPER;
            case COPPER -> IRON;
            case IRON -> GOLD;
            case GOLD -> DIAMOND;
            case DIAMOND, NETHERITE -> NETHERITE;
        };
    }
}
