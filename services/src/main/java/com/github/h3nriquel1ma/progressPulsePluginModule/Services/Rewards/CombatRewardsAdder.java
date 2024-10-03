package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.ConcreteEntries.AddCombatRewardsEntriesManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CombatRewardsAdder implements AddCombatRewardsEntriesManager {

    private final PotionItemManager potionItemCreator;

    public CombatRewardsAdder(PotionItemManager potionItemCreator) {
        this.potionItemCreator = potionItemCreator;
    }

    @Override
    public void addEntries(Map<Integer, RewardModel> list) {
        list.put(100, new RewardModel(new ItemStack(Material.STONE_SWORD, 1)));

        ItemStack healingPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.SPLASH_POTION, 5), new PotionData(PotionType.INSTANT_HEAL));
        list.put(300, new RewardModel(healingPotion));

        list.put(500, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 72000, 0)));

        list.put(700, new RewardModel(new ItemStack(Material.IRON_CHESTPLATE, 1)));

        list.put(900, new RewardModel(new ItemStack(Material.ARROW, 10)));

        list.put(1100, new RewardModel(new ItemStack(Material.IRON_SWORD, 1)));

        ItemStack strengthPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 3), new PotionData(PotionType.STRENGTH));
        list.put(1300, new RewardModel(strengthPotion));

        list.put(1500, new RewardModel(new PotionEffect(PotionEffectType.REGENERATION, 72000, 0)));

        list.put(1700, new RewardModel(new ItemStack(Material.DIAMOND_SWORD, 1)));

        list.put(10000, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2)));

        list.put(30000, new RewardModel(new ItemStack(Material.NETHERITE_SWORD, 1)));

        ItemStack regenPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 1), new PotionData(PotionType.REGEN));
        list.put(50000, new RewardModel(regenPotion));

        list.put(100000, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1)));

        List<ItemStack> netheriteArmorPack = new ArrayList<>();
        netheriteArmorPack.add(new ItemStack(Material.NETHERITE_HELMET, 1));
        netheriteArmorPack.add(new ItemStack(Material.NETHERITE_CHESTPLATE, 1));
        netheriteArmorPack.add(new ItemStack(Material.NETHERITE_LEGGINGS, 1));
        netheriteArmorPack.add(new ItemStack(Material.NETHERITE_BOOTS, 1));
        list.put(150000, new RewardModel(netheriteArmorPack));

        ItemStack strengthPotion2 = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 1), new PotionData(PotionType.STRENGTH));
        list.put(200000, new RewardModel(strengthPotion2));

        list.put(250000, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3)));

        ItemStack invisibilityPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 5), new PotionData(PotionType.INVISIBILITY));
        list.put(300000, new RewardModel(invisibilityPotion));

        list.put(1000000, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 4)));
    }
}
