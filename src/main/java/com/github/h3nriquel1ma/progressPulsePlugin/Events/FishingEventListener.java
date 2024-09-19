package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.UUID;

public class FishingEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public FishingEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onFishing(PlayerFishEvent event) {
        UUID playerId = event.getPlayer().getUniqueId();
        Player player = event.getPlayer();

        playerScoreManager.incrementFishingPoints(playerId);
        player.sendActionBar(Component.text(ChatColor.YELLOW + "+1 XP in " + ChatColor.AQUA + "Fishing" + ChatColor.YELLOW + "!"));
    }
}
