package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;

public abstract class RewardDistributor {

    protected void reward(Map<Integer, RewardModel> rewardsList, int playerPoints, Player player) {
        PlayerInventory playerInventory = player.getInventory();

        if (playerInventory.firstEmpty() != -1) {


            if (reward != null) {
                playerInventory.addItem(reward, 1);
            }
        } else {

        }
    }
}
