package com.devnemo.nemos.backpacks;

import net.fabricmc.api.ClientModInitializer;

public class FabricClientNemosBackpacks implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientCommon.init();
    }
}
