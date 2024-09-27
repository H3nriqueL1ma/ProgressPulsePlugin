package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

// Ouvinte de evento de blocos que são colocados pelo jogador.
public class ConstructionEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final VirtualThreadManager singleThread;
    private final VirtualTaskManager threadTask;
    private final LogUtil<String> loggerPlugin;

    public ConstructionEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.singleThread = singleThread;
        this.threadTask = threadTask;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @EventHandler
    public void onConstructionEvent(BlockPlaceEvent event) {
        String playerId = event.getPlayer().getUniqueId().toString();
        Player player = event.getPlayer();

        ExecutorService singleExecutor = singleThread.newSingleExecutor();

        threadTask.execute(() -> {
                databasePlayerDataUpdate.update(playerId, "constructionPoints");
                player.sendActionBar(Component.text(ChatColor.YELLOW + "+1 XP in " + ChatColor.BLUE + "Construction" + ChatColor.YELLOW + "!"));
            }, singleExecutor)
                .whenComplete((result, throwable) -> {
                    singleExecutor.shutdown();

                    if (throwable != null) {
                        loggerPlugin.printErr("Error executing ConstructionEvent Updating Data task: " + throwable.getMessage());
                    }
                });
    }
}
