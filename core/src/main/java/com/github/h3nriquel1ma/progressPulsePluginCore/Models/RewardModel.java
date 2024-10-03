package com.github.h3nriquel1ma.progressPulsePluginCore.Models;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class RewardModel {
    private ItemStack reward;
    private List<ItemStack> rewardsPack = new ArrayList<>();
    private PotionEffect effectReward;

    public void setReward(ItemStack reward) {
        this.reward = reward;
    }
    public ItemStack getReward() {
        return reward;
    }

    public void setEffectReward(PotionEffect effectReward) {
        this.effectReward = effectReward;
    }
    public PotionEffect getEffectReward() {
        return effectReward;
    }

    public void setRewardsPack(List<ItemStack> rewardsPack) {
        this.rewardsPack = rewardsPack;
    }
    public List<ItemStack> getRewardsPack() {
        return rewardsPack;
    }

    public RewardModel(ItemStack reward) {
        this.reward = reward;
    }

    public RewardModel(PotionEffect effectReward) {
        this.effectReward = effectReward;
    }

    public RewardModel(List<ItemStack> rewardsPack) {
        this.rewardsPack = rewardsPack;
    }
}
