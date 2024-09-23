package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

// Ouvinte de evento de ações de combate.
public class CombatEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;

    public CombatEventListener(Plugin plugin) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
    }

    @EventHandler
    public void onCombatEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player) {
            UUID playerId = damager.getUniqueId();

            databasePlayerDataUpdate.update(playerId, "combatPoints");
            damager.sendActionBar(Component.text(ChatColor.GOLD + "+1 XP in " + ChatColor.RED + "Combat" + ChatColor.GOLD + "!"));
        }
    }
}
