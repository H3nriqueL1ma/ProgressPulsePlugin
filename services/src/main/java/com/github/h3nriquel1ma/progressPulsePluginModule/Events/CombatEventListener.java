package com.github.h3nriquel1ma.progressPulsePluginModule.Events;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads.OnEventManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataSelect;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataUpdate;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

// Ouvinte de evento de ações de combate.
public class CombatEventListener extends OnEventManager implements Listener {

    private final UpdateManager databasePlayerDataUpdate;
    private final SelectManager databasePlayerDataSelect;

    public CombatEventListener(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        super(plugin, singleThread, threadTask);
        this.databasePlayerDataUpdate = new DatabasePlayerDataUpdate(plugin);
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(plugin);
    }

    @EventHandler
    public void onCombatEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if (damager instanceof Player) {
            String playerId = damager.getUniqueId().toString();

            onEvent("CombatEvent Updating Data", () -> {
                databasePlayerDataUpdate.update(playerId, "combatPoints");
                damager.sendActionBar(Component.text(ChatColor.GOLD + "+1 XP in " + ChatColor.RED + "Combat" + ChatColor.GOLD + "!"));
            });

            onEvent("CombatEvent Checking Data", () -> {
                PlayerData playerData = databasePlayerDataSelect.select(playerId);

                if (playerData != null) {
                    if (playerData.getCombatPoints() == 10) {
                        PlayerInventory playerInventory = ((Player) damager).getInventory();

                        if (playerInventory.firstEmpty() != -1) {
                            playerInventory.addItem(new ItemStack(Material.STONE_SWORD, 1));
                        } else {
                            damager.sendMessage("Inventário cheio!");
                        }
                    }
                }
            });
        }
    }
}
