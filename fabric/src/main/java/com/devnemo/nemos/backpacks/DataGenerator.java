package com.devnemo.nemos.backpacks;

import com.devnemo.nemos.backpacks.datagen.BackpackRecipeProvider;
import com.devnemo.nemos.backpacks.datagen.ItemTagProvider;
import com.devnemo.nemos.backpacks.datagen.ModelProvider;
import com.devnemo.nemos.backpacks.datagen.lang.EnglishLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelProvider::new);
        pack.addProvider(EnglishLanguageProvider::new);
        pack.addProvider(BackpackRecipeProvider::new);
        pack.addProvider(ItemTagProvider::new);
    }
}
