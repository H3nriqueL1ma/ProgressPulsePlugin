package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.RewardManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CombatRewardsDistributor implements RewardManager {

    @Override
    public void giveReward(PlayerData playerData, Player player) {
        if (playerData != null) {
            int playerCombatPoints = playerData.getCombatPoints();

            Map<Integer, RewardModel> rewarddList = new HashMap<>();
        }
    }
}
