package com.github.h3nriquel1ma.progressPulsePluginModule.Lists;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.ItemPackManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.AddEntriesManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards.RewardsAdder;

import java.util.HashMap;
import java.util.Map;

public class RewardsList {

    Map<Integer, RewardModel> combatRewardsList = new HashMap<>();
    Map<Integer, RewardModel> miningRewardsList = new HashMap<>();
    Map<Integer, RewardModel> resourcingRewardsList = new HashMap<>();
    Map<Integer, RewardModel> constructionRewardsList = new HashMap<>();
    Map<Integer, RewardModel> fishingRewardsList = new HashMap<>();

    public RewardsList(PotionItemManager potionItemCreator, ItemPackManager itemPackCreator) {
        AddEntriesManager<Integer, RewardModel> rewardsAdder = new RewardsAdder(potionItemCreator, itemPackCreator);
        rewardsAdder.addEntries(combatRewardsList, miningRewardsList, fishingRewardsList, resourcingRewardsList, constructionRewardsList);
    }

    public Map<Integer, RewardModel> getCombatRewardsList() {
        return combatRewardsList;
    }

    public Map<Integer, RewardModel> getMiningRewardsList() {
        return miningRewardsList;
    }

    public Map<Integer, RewardModel> getConstructionRewardsList() {
        return constructionRewardsList;
    }

    public Map<Integer, RewardModel> getFishingRewardsList() {
        return fishingRewardsList;
    }

    public Map<Integer, RewardModel> getResourcingRewardsList() {
        return resourcingRewardsList;
    }
}
