package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Items.PotionItemManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.RewardManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Lists.CombatRewardsList;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards.RewardDistributor;
import org.bukkit.entity.Player;

public class CombatRewardsDistributor extends RewardDistributor implements RewardManager {

    private final PotionItemManager potionItemCreator;

    public CombatRewardsDistributor(PotionItemManager potionItemCreator) {
        this.potionItemCreator = potionItemCreator;
    }

    @Override
    public void giveReward(PlayerData playerData, Player player) {
        if (playerData != null) {
            int playerCombatPoints = playerData.getCombatPoints();

            CombatRewardsList combatRewardsList = new CombatRewardsList(potionItemCreator);

            reward(combatRewardsList.getRewardsList(), playerCombatPoints, player);
        }
    }
}
