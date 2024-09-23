package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataInsert;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerInsert;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.util.UUID;

// Ouvinte de evento de entrada do jogador no servidor.
public class JoinEventListener implements Listener {

    private final InsertManager databasePlayerInsert;
    private final InsertManager databasePlayerDataInsert;

    public JoinEventListener(Connection connection, Plugin plugin) {
        this.databasePlayerInsert = new DatabasePlayerInsert(connection, plugin);
        this.databasePlayerDataInsert = new DatabasePlayerDataInsert(connection, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();

        databasePlayerInsert.insert(playerID);
        databasePlayerDataInsert.insert(0, 0, 0, 0, 0, playerID);
    }
}
