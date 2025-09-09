package com.devnemo.nemos.backpacks;

import com.devnemo.nemos.backpacks.world.inventory.NemosBackpackMenuTypes;
import com.devnemo.nemos.backpacks.world.item.NemosBackpackCreativeModeTabs;
import com.devnemo.nemos.backpacks.world.item.NemosBackpackItems;

public class Common {

    public static void init() {
        Constants.LOG.info("Thank you for using Nemo's Backpack");

        NemosBackpackItems.init();
        NemosBackpackCreativeModeTabs.init();
        NemosBackpackMenuTypes.init();
    }
}