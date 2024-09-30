package com.github.h3nriquel1ma.progressPulsePluginCore.Models;

import org.bukkit.inventory.ItemStack;

public class RewardModel {
    private ItemStack reward;

    public void setReward(ItemStack reward) {
        this.reward = reward;
    }
    public ItemStack getReward() {
        return reward;
    }

    public RewardModel(ItemStack reward) {
        this.reward = reward;
    }
}
