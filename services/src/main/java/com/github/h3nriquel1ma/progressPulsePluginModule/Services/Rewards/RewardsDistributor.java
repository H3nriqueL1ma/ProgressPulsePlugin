package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.ItemPackManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.RewardManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.MessageUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Lists.RewardsList;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards.RewardDistributor;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.OnEventInstance;
import org.bukkit.entity.Player;

public class RewardsDistributor extends RewardDistributor implements RewardManager {

    private final PotionItemManager potionItemCreator;
    private final ItemPackManager itemPackCreator;
    private final OnEventInstance onEventInstance;

    public RewardsDistributor(PotionItemManager potionItemCreator, ItemPackManager itemPackCreator, OnEventInstance onEventInstance, MessageUtil playerMessageSender) {
        super(playerMessageSender);
        this.potionItemCreator = potionItemCreator;
        this.itemPackCreator = itemPackCreator;
        this.onEventInstance = onEventInstance;
    }

    @Override
    public void giveReward(PlayerData playerData, Player player) {
        if (playerData != null) {
            int combatPlayerPoints = playerData.getCombatPoints();
            int miningPlayerPoints = playerData.getMiningPoints();
            int fishingPlayerPoints = playerData.getFishingPoints();
            int resourcingPlayerPoints = playerData.getResCollPoints();
            int constructionPlayerPoints = playerData.getConstrnPoints();

            RewardsList rewardsLists = new RewardsList(potionItemCreator, itemPackCreator);

            onEventInstance.executeOnEventInstance("RewardDistributor Giving Combat Rewards", () -> reward(rewardsLists.getCombatRewardsList(), combatPlayerPoints, player));

            onEventInstance.executeOnEventInstance("RewardDistributor Giving Mining Rewards", () -> reward(rewardsLists.getMiningRewardsList(), miningPlayerPoints, player));

            onEventInstance.executeOnEventInstance("RewardDistributor Giving Mining Rewards", () -> reward(rewardsLists.getFishingRewardsList(), fishingPlayerPoints, player));

            onEventInstance.executeOnEventInstance("RewardDistributor Giving Mining Rewards", () -> reward(rewardsLists.getConstructionRewardsList(), constructionPlayerPoints, player));

            onEventInstance.executeOnEventInstance("RewardDistributor Giving Mining Rewards", () -> reward(rewardsLists.getResourcingRewardsList(), resourcingPlayerPoints, player));
        }
    }
}
