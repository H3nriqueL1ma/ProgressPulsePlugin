package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de blocos que são colocados pelo jogador.
public class ConstructionEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;

    public ConstructionEventListener(Plugin plugin) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
    }

    @EventHandler
    public void onConstructionEvent(BlockPlaceEvent event) {
        String playerId = event.getPlayer().getUniqueId().toString();
        Player player = event.getPlayer();

        databasePlayerDataUpdate.update(playerId, "constructionPoints");
        player.sendActionBar(Component.text(ChatColor.YELLOW + "+1 XP in " + ChatColor.BLUE + "Construction" + ChatColor.YELLOW + "!"));
    }
}
