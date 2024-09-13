package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CombatEventListener implements Listener {

    @EventHandler
    public void onTest(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();

        if (entity instanceof Player) {
            Player player = (Player) event.getEntity();

            player.sendMessage("Você atacou uma entidade!");
        }
    }
}
