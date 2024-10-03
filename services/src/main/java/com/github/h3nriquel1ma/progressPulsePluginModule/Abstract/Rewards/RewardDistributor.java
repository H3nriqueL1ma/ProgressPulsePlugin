package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Rewards;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.RewardModel;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;

import java.util.Map;

public abstract class RewardDistributor {

    protected void reward(Map<Integer, RewardModel> rewardsList, int playerPoints, Player player) {
        PlayerInventory playerInventory = player.getInventory();

        if (playerInventory.firstEmpty() != -1) {
            RewardModel reward = rewardsList.get(playerPoints);

            if (reward != null) {
                if (reward.getReward() != null) {
                    playerInventory.addItem(reward.getReward());
                    player.sendMessage(
                            Component.text()
                                    .content("Congrats! ")
                                    .color(TextColor.color(50, 205, 50))
                                    .decoration(TextDecoration.BOLD, true)
                                    .append(
                                            Component.text("You reached level ", TextColor.color(255, 255, 0)),
                                            Component.text(playerPoints, TextColor.color(173, 216, 230)),
                                            Component.text(" and received ", TextColor.color(255, 255, 0)),
                                            Component.text(reward.getReward().displayName().toString(), TextColor.color(255, 215, 0)),
                                            Component.text("!", TextColor.color(255, 255, 0))
                                    )
                    );
                } else if (reward.getEffectReward() != null) {
                    player.addPotionEffect(reward.getEffectReward());
                }
            }
        } else {
            player.sendMessage("Full inventory! Try claim the reward using /claimrewards");
        }
    }
}
