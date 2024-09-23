package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class FishingEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;

    public FishingEventListener(Plugin plugin) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
    }

    @EventHandler
    public void onFishing(PlayerFishEvent event) {
        UUID playerId = event.getPlayer().getUniqueId();
        Player player = event.getPlayer();

        databasePlayerDataUpdate.update(playerId, "fishingPoints");
        player.sendActionBar(Component.text(ChatColor.YELLOW + "+1 XP in " + ChatColor.AQUA + "Fishing" + ChatColor.YELLOW + "!"));
    }
}
