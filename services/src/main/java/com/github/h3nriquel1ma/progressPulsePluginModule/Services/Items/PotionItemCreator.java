package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Items;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;

public class PotionItemCreator implements PotionItemManager {

    @Override
    public ItemStack createCustomPotion(ItemStack potion, PotionData potionType) {
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        potionMeta.setBasePotionData(potionType);
        potion.setItemMeta(potionMeta);

        return potion;
    }
}
