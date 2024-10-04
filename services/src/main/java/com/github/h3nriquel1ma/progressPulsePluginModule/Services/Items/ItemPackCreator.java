package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Items;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.ItemPackManager;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPackCreator implements ItemPackManager {

    @Override
    public List<ItemStack> createItemPack(ItemStack... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
