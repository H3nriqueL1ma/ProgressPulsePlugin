package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.MessageUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;
import java.util.Objects;

public abstract class RewardDistributor {

    private final MessageUtil playerMessageSender;

    protected RewardDistributor(MessageUtil playerMessageSender) {
        this.playerMessageSender = playerMessageSender;
    }

    protected void reward(Map<Integer, RewardModel> rewardsList, int playerPoints, Player player) {
        PlayerInventory playerInventory = player.getInventory();

        if (playerInventory.firstEmpty() != -1) {
            RewardModel reward = rewardsList.get(playerPoints);

            if (reward != null) {
                if (reward.getReward() != null) {
                    playerInventory.addItem(reward.getReward());
                    playerMessageSender.sendMessage(player, playerPoints,
                            (reward.getReward().hasItemMeta() && reward.getReward().getItemMeta().hasDisplayName())
                                    ? Objects.requireNonNull(reward.getReward().getItemMeta().displayName()).toString()
                                    : reward.getReward().getType().toString()
                    );
                } else if (reward.getEffectReward() != null) {
                    player.addPotionEffect(reward.getEffectReward());
                    playerMessageSender.sendMessage(player, playerPoints, reward.getEffectReward().getType().getName());
                }
            } else {
                handleNoReward(playerPoints);
            }
        } else {
            player.sendMessage("Full inventory! Try claim the reward using /claimrewards");
        }
    }

    private void handleNoReward(int playerPoints) {}
}


