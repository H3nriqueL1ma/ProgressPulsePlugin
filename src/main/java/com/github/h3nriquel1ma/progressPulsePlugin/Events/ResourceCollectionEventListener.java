package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

public class ResourceCollectionEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public ResourceCollectionEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onCollect(BlockBreakEvent event) {
        Material resource = event.getBlock().getType();

        if (isResource(resource)) {
            UUID playerId = event.getPlayer().getUniqueId();

            playerScoreManager.incrementResourcePoints(playerId);
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
