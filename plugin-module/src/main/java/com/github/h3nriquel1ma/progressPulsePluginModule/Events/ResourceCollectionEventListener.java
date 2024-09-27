package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

// Ouvinte de evento de quebra de blocos de recursos.
public class ResourceCollectionEventListener implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final VirtualThreadManager singleThread;
    private final VirtualTaskManager threadTask;
    private final LogUtil<String> loggerPlugin;

    public ResourceCollectionEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.singleThread = singleThread;
        this.threadTask = threadTask;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @EventHandler
    public void onCollect(BlockBreakEvent event) {
        Material resource = event.getBlock().getType();

        if (isResource(resource)) {
            String playerId = event.getPlayer().getUniqueId().toString();
            Player player = event.getPlayer();

            ExecutorService singleExecutor = singleThread.newSingleExecutor();

            threadTask.execute(() -> {
                databasePlayerDataUpdate.update(playerId, "resourceColPoints");
                player.sendActionBar(Component.text(ChatColor.GREEN + "+1 XP in " + ChatColor.GOLD + "Resource Collection" + ChatColor.GREEN + "!"));
            }, singleExecutor)
                    .whenComplete((result, throwable) -> {
                        singleExecutor.shutdown();

                        if (throwable != null) {
                            loggerPlugin.printErr("Error executing MiningEvent Updating Data task: " + throwable.getMessage());
                        }
                    });
        }
    }

    private Boolean isResource(Material material) {
        Material[] materials = {
                Material.ACACIA_LOG,
                Material.OAK_LOG,
                Material.BIRCH_LOG,
                Material.JUNGLE_LOG,
                Material.DARK_OAK_LOG,
                Material.SPRUCE_LOG,
                Material.STRIPPED_ACACIA_LOG,
                Material.STRIPPED_BIRCH_LOG,
                Material.STRIPPED_OAK_LOG,
                Material.STRIPPED_JUNGLE_LOG,
                Material.STRIPPED_DARK_OAK_LOG,
                Material.STRIPPED_SPRUCE_LOG,
                Material.SAND,
                Material.SOUL_SAND,
                Material.RED_SAND,
                Material.CACTUS,
                Material.GRAVEL
        };
        
        for (Material materialResource : materials) {
            if (material.equals(materialResource)) {
                return true;
            }
        }

        return false;
    }
}
