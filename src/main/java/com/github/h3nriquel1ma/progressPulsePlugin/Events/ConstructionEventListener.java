package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.UUID;

public class ConstructionEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public ConstructionEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onConstructionEvent(BlockPlaceEvent event) {
        UUID playerId = event.getPlayer().getUniqueId();
        Player player = event.getPlayer();

        playerScoreManager.incrementConstrnPoints(playerId);
        player.sendActionBar(Component.text(ChatColor.DARK_GREEN + "+1 XP in" + ChatColor.GOLD + "Construction" + ChatColor.DARK_GREEN + "!"));
    }
}
