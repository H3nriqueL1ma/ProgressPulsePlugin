package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

// Ouvinte de evento de ações de combate.
public class CombatEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final VirtualThreadManager singleThread;
    private final VirtualTaskManager threadTask;
    private final LogUtil<String> loggerPlugin;

    public CombatEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.singleThread = singleThread;
        this.threadTask = threadTask;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @EventHandler
    public void onCombatEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player) {
            String playerId = damager.getUniqueId().toString();

            ExecutorService singleExecutor = singleThread.newSingleExecutor();

            threadTask.execute(() -> {
                databasePlayerDataUpdate.update(playerId, "combatPoints");
                damager.sendActionBar(Component.text(ChatColor.GOLD + "+1 XP in " + ChatColor.RED + "Combat" + ChatColor.GOLD + "!"));
            }, singleExecutor)
                    .whenComplete((result, throwable) -> {
                        singleExecutor.shutdown();

                       if (throwable != null) {
                           loggerPlugin.printErr("Error executing PlayerJoin Inserting Data task: " + throwable.getMessage());
                       }
                    });


        }
    }
}
