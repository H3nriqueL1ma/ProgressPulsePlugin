package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ItemPackManager {
    List<ItemStack> createItemPack(ItemStack... items);
}
