package com.github.h3nriquel1ma.progressPulsePluginCore.Models;

import org.bukkit.inventory.ItemStack;

public class RewardModel {
    private ItemStack reward;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setReward(ItemStack reward) {
        this.reward = reward;
    }
    public ItemStack getReward() {
        return reward;
    }

    public RewardModel(ItemStack reward, int quantity) {
        this.reward = reward;
        this.quantity = quantity;
    }
}
