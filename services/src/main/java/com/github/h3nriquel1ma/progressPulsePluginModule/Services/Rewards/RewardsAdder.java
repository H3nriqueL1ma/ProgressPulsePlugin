package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.ItemPackManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.AddEntriesManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RewardsAdder implements AddEntriesManager<Integer, RewardModel> {

    private final PotionItemManager potionItemCreator;
    private final ItemPackManager itemPackCreator;

    public RewardsAdder(PotionItemManager potionItemCreator, ItemPackManager itempackCreator) {
        this.potionItemCreator = potionItemCreator;
        this.itemPackCreator = itempackCreator;
    }

    @Override
    public void addEntries(Map<Integer, RewardModel> combatList,
                           Map<Integer, RewardModel> miningList,
                           Map<Integer, RewardModel> fishingList,
                           Map<Integer, RewardModel> resourcingList,
                           Map<Integer, RewardModel> constructionList
    ) {
        combatList.put(200, new RewardModel(new ItemStack(Material.STONE_SWORD)));

        ItemStack healingPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.SPLASH_POTION, 5), new PotionData(PotionType.INSTANT_HEAL));
        combatList.put(400, new RewardModel(healingPotion));

        combatList.put(600, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 72000, 0)));

        combatList.put(800, new RewardModel(new ItemStack(Material.IRON_CHESTPLATE)));

        combatList.put(1000, new RewardModel(new ItemStack(Material.ARROW, 10)));

        combatList.put(1500, new RewardModel(new ItemStack(Material.IRON_SWORD)));

        ItemStack strengthPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 3), new PotionData(PotionType.STRENGTH));
        combatList.put(2000, new RewardModel(strengthPotion));

        combatList.put(2500, new RewardModel(new PotionEffect(PotionEffectType.REGENERATION, 72000, 0)));

        combatList.put(3000, new RewardModel(new ItemStack(Material.DIAMOND_SWORD)));

        combatList.put(3500, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2)));

        combatList.put(4000, new RewardModel(new ItemStack(Material.NETHERITE_SWORD)));

        ItemStack regenPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION), new PotionData(PotionType.REGEN));
        combatList.put(4500, new RewardModel(regenPotion));

        combatList.put(5000, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1)));

        List<ItemStack> netheriteArmorPack = itemPackCreator.createItemPack(
                new ItemStack(Material.NETHERITE_HELMET),
                new ItemStack(Material.NETHERITE_CHESTPLATE),
                new ItemStack(Material.NETHERITE_LEGGINGS),
                new ItemStack(Material.NETHERITE_BOOTS)
        );
        combatList.put(10000, new RewardModel(netheriteArmorPack));

        ItemStack strengthPotion2 = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION), new PotionData(PotionType.STRENGTH));
        combatList.put(15000, new RewardModel(strengthPotion2));

        combatList.put(20000, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3)));

        ItemStack invisibilityPotion = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 5), new PotionData(PotionType.INVISIBILITY));
        combatList.put(25000, new RewardModel(invisibilityPotion));

        combatList.put(100000, new RewardModel(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 4)));






        miningList.put(200, new RewardModel(new ItemStack(Material.STONE_PICKAXE)));

        miningList.put(400, new RewardModel(new ItemStack(Material.DIAMOND, 5)));

        miningList.put(600, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, 72000, 0)));

        miningList.put(800, new RewardModel(new ItemStack(Material.IRON_HELMET)));

        miningList.put(1000, new RewardModel(new ItemStack(Material.COAL)));

        miningList.put(1500, new RewardModel(new ItemStack(Material.IRON_PICKAXE)));

        miningList.put(2000, new RewardModel(new ItemStack(Material.EMERALD_BLOCK, 3)));

        miningList.put(2500, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 72000, 0)));

        miningList.put(3000, new RewardModel(new ItemStack(Material.NETHERITE_BLOCK)));

        miningList.put(3500, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 2)));

        miningList.put(4500, new RewardModel(new ItemStack(Material.NETHERITE_PICKAXE)));

        miningList.put(5000, new RewardModel(new ItemStack(Material.EMERALD_BLOCK, 10)));

        miningList.put(10000, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 3)));

        miningList.put(15000, new RewardModel(new ItemStack(Material.BEACON)));

        miningList.put(20000, new RewardModel(new ItemStack(Material.DIAMOND_BLOCK, 5)));

        miningList.put(25000, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1)));

        miningList.put(50000, new RewardModel(new ItemStack(Material.QUARTZ_BLOCK, 10)));

        miningList.put(100000, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 4)));






        fishingList.put(10, new RewardModel(new ItemStack(Material.FISHING_ROD)));

        fishingList.put(30, new RewardModel(new ItemStack(Material.COOKED_SALMON, 5)));

        fishingList.put(50, new RewardModel(new PotionEffect(PotionEffectType.LUCK, 72000, 0)));

        ItemStack regenPotion2 = potionItemCreator.createCustomPotion(new ItemStack(Material.POTION, 3), new PotionData(PotionType.REGEN));
        fishingList.put(100, new RewardModel(new ItemStack(regenPotion2)));

        fishingList.put(200, new RewardModel(new PotionEffect(PotionEffectType.LUCK, 72000, 1)));

        fishingList.put(600, new RewardModel(new PotionEffect(PotionEffectType.LUCK, Integer.MAX_VALUE, 2)));






        resourcingList.put(10, new RewardModel(new ItemStack(Material.WHEAT_SEEDS, 16)));

        List<ItemStack> fruitsPack = itemPackCreator.createItemPack(
                new ItemStack(Material.APPLE, 5),
                new ItemStack(Material.COCOA, 5),
                new ItemStack(Material.SWEET_BERRIES, 5),
                new ItemStack(Material.MELON_SLICE, 5),
                new ItemStack(Material.GLOW_BERRIES, 5)
        );
        resourcingList.put(30, new RewardModel(fruitsPack));

        resourcingList.put(50, new RewardModel(new ItemStack(Material.SPRUCE_WOOD, 5)));

        resourcingList.put(70, new RewardModel(new ItemStack(Material.BROWN_MUSHROOM, 10)));

        List<ItemStack> goldArmorPack = itemPackCreator.createItemPack(
                new ItemStack(Material.GOLDEN_HELMET),
                new ItemStack(Material.GOLDEN_CHESTPLATE),
                new ItemStack(Material.GOLDEN_LEGGINGS),
                new ItemStack(Material.GOLDEN_BOOTS)
        );
        resourcingList.put(100, new RewardModel(goldArmorPack));

        resourcingList.put(200, new RewardModel(new ItemStack(Material.SAND, 5)));

        resourcingList.put(400, new RewardModel(new ItemStack(Material.TNT, 3)));






        constructionList.put(10, new RewardModel(new ItemStack(Material.DARK_OAK_WOOD, 32)));

        constructionList.put(30, new RewardModel(new ItemStack(Material.COBBLESTONE, 16)));

        constructionList.put(50, new RewardModel(new ItemStack(Material.DARK_OAK_DOOR)));

        constructionList.put(70, new RewardModel(new ItemStack(Material.GLASS, 8)));

        constructionList.put(100, new RewardModel(new ItemStack(Material.LAPIS_BLOCK, 5)));

        constructionList.put(200, new RewardModel(new ItemStack(Material.LADDER, 10)));

        constructionList.put(400, new RewardModel(new ItemStack(Material.STONE, 5)));
    }
}
