package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.TaskManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataInsert;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerInsert;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.ThreadPool;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de entrada do jogador no servidor.
public class JoinEventListener implements Listener {

    private final InsertManager databasePlayerInsert;
    private final InsertManager databasePlayerDataInsert;
    private final ThreadPool threadPool;

    public JoinEventListener(Plugin plugin, ThreadPool threadPool) {
        this.databasePlayerInsert = new DatabasePlayerInsert(plugin);
        this.databasePlayerDataInsert = new DatabasePlayerDataInsert(plugin);
        this.threadPool = threadPool;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerID = event.getPlayer().getUniqueId().toString();

        databasePlayerInsert.insert(playerID);
        databasePlayerDataInsert.insert(0, 0, 0, 0, 0, playerID);
    }
}
