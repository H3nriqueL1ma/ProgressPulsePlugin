package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

// Ouvinte de evento de ações de combate.
public class CombatEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public CombatEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onCombatEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player) {
            UUID playerId = damager.getUniqueId();

            playerScoreManager.incrementCombatPoints(playerId);

            damager.sendMessage(Component.text("Score atual: " + playerScoreManager.getPlayerCombatPoints(playerId)));
        }
    }
}
