package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards.Mining;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.AddEntriesManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class MiningRewardsAdder implements AddEntriesManager<Integer, RewardModel> {

    @Override
    public void addEntries(Map<Integer, RewardModel> list) {
        list.put(100, new RewardModel(new ItemStack(Material.STONE_PICKAXE)));

        list.put(300, new RewardModel(new ItemStack(Material.DIAMOND, 5)));

        list.put(400, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, 72000, 0)));

        list.put(500, new RewardModel(new ItemStack(Material.IRON_HELMET)));

        list.put(600, new RewardModel(new ItemStack(Material.COAL)));

        list.put(700, new RewardModel(new ItemStack(Material.IRON_PICKAXE)));

        list.put(800, new RewardModel(new ItemStack(Material.EMERALD_BLOCK, 3)));

        list.put(900, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 72000, 0)));

        list.put(1000, new RewardModel(new ItemStack(Material.NETHERITE_BLOCK)));

        list.put(10000, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 2)));

        list.put(20000, new RewardModel(new ItemStack(Material.NETHERITE_PICKAXE)));

        list.put(30000, new RewardModel(new ItemStack(Material.EMERALD_BLOCK, 10)));

        list.put(50000, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 3)));

        list.put(100000, new RewardModel(new ItemStack(Material.BEACON)));

        list.put(150000, new RewardModel(new ItemStack(Material.DIAMOND_BLOCK, 5)));

        list.put(200000, new RewardModel(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1)));

        list.put(250000, new RewardModel(new ItemStack(Material.QUARTZ_BLOCK, 10)));

        list.put(500000, new RewardModel());

        list.put(1000000, new RewardModel(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 4)));
    }
}
