package com.github.h3nriquel1ma.progressPulsePlugin.Events;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

// Ouvinte de evento de ações de quebra de bloco.
public class MiningEventListener implements Listener {

    private final PlayerScoreManager playerScoreManager;

    public MiningEventListener(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @EventHandler
    public void onMiningEvent(BlockBreakEvent event) {
        Material blockType = event.getBlock().getType();
        ItemStack itemPlayerHand = event.getPlayer().getInventory().getItemInMainHand();

        if (isOreOrMineBlock(blockType)) {

        }


//        UUID playerId = event.getPlayer().getUniqueId();
//
//        playerScoreManager.incrementMiningPoints(playerId);
    }

    private Boolean isOreOrMineBlock(Material material) {
        return material.equals(Material.COAL_ORE)
                || material.equals(Material.COPPER_ORE)
                || material.equals(Material.DIAMOND_ORE)
                || material.equals(Material.EMERALD_ORE)
                || material.equals(Material.GOLD_ORE)
                || material.equals(Material.IRON_ORE)
                || material.equals(Material.LAPIS_ORE)
                || material.equals(Material.NETHER_GOLD_ORE)
                || material.equals(Material.NETHER_QUARTZ_ORE)
                || material.equals(Material.REDSTONE_ORE)
                || material.equals(Material.DEEPSLATE_COAL_ORE)
                || material.equals(Material.DEEPSLATE_COPPER_ORE)
                || material.equals(Material.DEEPSLATE_DIAMOND_ORE)
                || material.equals(Material.DEEPSLATE_EMERALD_ORE)
                || material.equals(Material.DEEPSLATE_GOLD_ORE)
                || material.equals(Material.DEEPSLATE_IRON_ORE)
                || material.equals(Material.DEEPSLATE_LAPIS_ORE)
                || material.equals(Material.DEEPSLATE_REDSTONE_ORE)
                || material.equals(Material.ANCIENT_DEBRIS)
                || material.equals(Material.STONE)
                || material.equals(Material.COBBLESTONE)
                || material.equals(Material.ANDESITE)
                || material.equals(Material.BLACKSTONE)
                || material.equals(Material.CALCITE)
                || material.equals(Material.DEEPSLATE)
                || material.equals(Material.GRANITE)
                || material.equals(Material.DIORITE)
                || material.equals(Material.END_STONE)
                || material.equals(Material.GLOWSTONE)
                || material.equals(Material.SANDSTONE)
                || material.equals(Material.TERRACOTTA);
    }
}
