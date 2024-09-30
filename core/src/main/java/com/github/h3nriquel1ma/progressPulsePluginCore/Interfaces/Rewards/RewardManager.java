package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import org.bukkit.entity.Player;

public interface RewardManager {
    void giveReward(PlayerData playerData, Player player);
}
