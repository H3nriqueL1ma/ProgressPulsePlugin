package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadPoolManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerInsert;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

// Ouvinte de evento de entrada do jogador no servidor.
public class JoinEventListener implements Listener {

    private final InsertManager databasePlayerInsert;
    private final VirtualThreadPoolManager threadPool;
    private final VirtualTaskManager threadTask;
    public JoinEventListener(Plugin plugin, VirtualThreadPoolManager threadPool, VirtualTaskManager threadTask) {
        this.databasePlayerInsert = new DatabasePlayerInsert(plugin);
        this.threadPool = threadPool;
        this.threadTask = threadTask;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerID = event.getPlayer().getUniqueId().toString();

        ExecutorService newExecutor = threadPool.newExecutor(1);

        threadTask.execute(() -> databasePlayerInsert.insert(0, 0, 0, 0, 0, playerID), newExecutor);

        newExecutor.shutdown();
    }
}
