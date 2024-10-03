package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionData;

public interface PotionItemManager {
    ItemStack createCustomPotion(ItemStack potion, PotionData potionType);
}
