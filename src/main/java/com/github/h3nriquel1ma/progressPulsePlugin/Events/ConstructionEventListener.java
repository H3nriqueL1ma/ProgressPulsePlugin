package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
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

        playerScoreManager.incrementConstrnPoints(playerId);
    }
}
