package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads.OnEventManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerInsert;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de entrada do jogador no servidor.
public class JoinEventListener extends OnEventManager implements Listener {

    private final InsertManager databasePlayerInsert;

    public JoinEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        super(plugin, singleThread, threadTask);
        this.databasePlayerInsert = new DatabasePlayerInsert(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerID = event.getPlayer().getUniqueId().toString();

        onEvent("PlayerJoinEvent Inserting Data", () -> databasePlayerInsert.insert(0, 0, 0, 0, 0, playerID));
    }
}
