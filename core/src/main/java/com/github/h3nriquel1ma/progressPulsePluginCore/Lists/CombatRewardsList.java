package com.github.h3nriquel1ma.progressPulsePluginCore.Lists;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CombatRewardsList {
    Map<Integer, RewardModel> rewardsList = new HashMap<>();

    public CombatRewardsList() {
        this.rewardsList.put(10, new RewardModel(new ItemStack(Material.STONE_SWORD, 1)));
    }

    public Map<Integer, RewardModel> getRewardsList() {
        return rewardsList;
    }
}
