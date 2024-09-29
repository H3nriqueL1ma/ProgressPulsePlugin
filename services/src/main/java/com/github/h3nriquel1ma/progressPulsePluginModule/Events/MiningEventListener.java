package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Verification.MaterialVerify;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads.OnEventManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de ações de quebra de blocos de mineração.
public class MiningEventListener extends OnEventManager implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final MaterialVerify pickaxeVerifier;
    private final MaterialVerify oreOrBlockVerifier;

    public MiningEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask, MaterialVerify pickaxeVerifier, MaterialVerify oreOrBlockVerifier) {
        super(plugin, singleThread, threadTask);
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.pickaxeVerifier = pickaxeVerifier;
        this.oreOrBlockVerifier = oreOrBlockVerifier;
    }

    @EventHandler
    public void onMiningEvent(BlockBreakEvent event) {
        Material blockType = event.getBlock().getType();
        Material itemPlayerHand = event.getPlayer().getInventory().getItemInMainHand().getType();

        if (pickaxeVerifier.isMaterial(itemPlayerHand)) {
            if (oreOrBlockVerifier.isMaterial(blockType)) {
                String playerId = event.getPlayer().getUniqueId().toString();
                Player player = event.getPlayer();

                onEvent("MiningEvent Updating Data", () -> {
                    databasePlayerDataUpdate.update(playerId, "miningPoints");
                    player.sendActionBar(Component.text(ChatColor.GRAY + "+1 XP in " + ChatColor.DARK_AQUA + "Mining" + ChatColor.GRAY + "!"));
                });
            }
        }
    }
}
