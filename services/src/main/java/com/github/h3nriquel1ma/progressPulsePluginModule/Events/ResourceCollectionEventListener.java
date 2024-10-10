package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards.RewardManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Verification.MaterialVerify;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads.OnEventManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataSelect;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Items.ItemPackCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Items.PotionItemCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Rewards.RewardsDistributor;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.OnEventInstance;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.PlayerMessageSender;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de quebra de blocos de recursos.
public class ResourceCollectionEventListener extends OnEventManager implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final MaterialVerify resourceVerifier;
    private final SelectManager databasePlayerDataSelect;
    private final RewardManager rewardsDistributor;

    public ResourceCollectionEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask, MaterialVerify resourceVerifier) {
        super(plugin, singleThread, threadTask);
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.resourceVerifier = resourceVerifier;
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(plugin);
        this.rewardsDistributor = new RewardsDistributor(new PotionItemCreator(), new ItemPackCreator(), new OnEventInstance(new OnEventManager(plugin, singleThread, threadTask) {
            @Override
            public void onEvent(String taskName, Runnable task) {
                super.onEvent(taskName, task);
            }
        }), new PlayerMessageSender());
    }

    @EventHandler
    public void onCollect(BlockBreakEvent event) {
        Material resource = event.getBlock().getType();

        if (resourceVerifier.isMaterial(resource)) {
            String playerId = event.getPlayer().getUniqueId().toString();
            Player player = event.getPlayer();

            onEvent("ResourceCollectionEvent Updating Data", () -> {
                databasePlayerDataUpdate.update(playerId, "resourceColPoints");
                player.sendActionBar(Component.text(ChatColor.GREEN + "+1 XP in " + ChatColor.GOLD + "Resource Collection" + ChatColor.GREEN + "!"));
            });

            onEvent("ResourceCollectionEvent Checking Data and Giving Reward", () -> {
                PlayerData playerData = databasePlayerDataSelect.select(playerId);
                rewardsDistributor.giveReward(playerData, player);
            });
        }
    }
}
