package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

// Ouvinte de evento de entrada do jogador no servidor.
public class JoinEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public JoinEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();

        this.playerScoreManager.setPlayerId(playerID);
    }
}
