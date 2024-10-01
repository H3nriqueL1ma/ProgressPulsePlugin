package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.RewardManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Lists.CombatRewardsList;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards.RewardDistributor;
import org.bukkit.entity.Player;

public class CombatRewardsDistributor extends RewardDistributor implements RewardManager {

    @Override
    public void giveReward(PlayerData playerData, Player player) {
        if (playerData != null) {
            int playerCombatPoints = playerData.getCombatPoints();

            CombatRewardsList combatRewardsList = new CombatRewardsList();

            reward(combatRewardsList.getRewardsList(), playerCombatPoints, player);
        }
    }
}
