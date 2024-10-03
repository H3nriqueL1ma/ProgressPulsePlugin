package com.github.h3nriquel1ma.progressPulsePluginModule.Lists;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.ConcreteEntries.AddCombatRewardsEntriesManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards.CombatRewardsAdder;

import java.util.HashMap;
import java.util.Map;

public class CombatRewardsList {

    Map<Integer, RewardModel> rewardsList = new HashMap<>();

    public CombatRewardsList(PotionItemManager potionItemCreator) {
        AddCombatRewardsEntriesManager combatRewardsAdder = new CombatRewardsAdder(potionItemCreator);
        combatRewardsAdder.addEntries(rewardsList);
    }

    public Map<Integer, RewardModel> getRewardsList() {
        return rewardsList;
    }
}
