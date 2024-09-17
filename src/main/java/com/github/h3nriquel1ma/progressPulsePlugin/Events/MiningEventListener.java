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
        Material itemPlayerHand = event.getPlayer().getInventory().getItemInMainHand().getType();

        if (isPickaxeItem(itemPlayerHand)) {
            if (isOreOrMineBlock(blockType)) {
                UUID playerId = event.getPlayer().getUniqueId();

                playerScoreManager.incrementMiningPoints(playerId);
            }
        }
    }

    private Boolean isPickaxeItem(Material item) {
        return item.equals(Material.DIAMOND_PICKAXE)
                || item.equals(Material.GOLDEN_PICKAXE)
                || item.equals(Material.IRON_PICKAXE)
                || item.equals(Material.STONE_PICKAXE)
                || item.equals(Material.WOODEN_PICKAXE)
                || item.equals(Material.NETHERITE_PICKAXE);
    }

    private Boolean isOreOrMineBlock(Material material) {
        Material[] materials = {
                Material.COAL_ORE,
                Material.COPPER_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,
                Material.GOLD_ORE,
                Material.IRON_ORE,
                Material.LAPIS_ORE,
                Material.NETHER_GOLD_ORE,
                Material.NETHER_QUARTZ_ORE,
                Material.REDSTONE_ORE,
                Material.DEEPSLATE_COAL_ORE,
                Material.DEEPSLATE_COPPER_ORE,
                Material.DEEPSLATE_DIAMOND_ORE,
                Material.DEEPSLATE_EMERALD_ORE,
                Material.DEEPSLATE_GOLD_ORE,
                Material.DEEPSLATE_IRON_ORE,
                Material.DEEPSLATE_LAPIS_ORE,
                Material.DEEPSLATE_REDSTONE_ORE,
                Material.ANCIENT_DEBRIS,
                Material.STONE,
                Material.COBBLESTONE,
                Material.ANDESITE,
                Material.BLACKSTONE,
                Material.CALCITE,
                Material.DEEPSLATE,
                Material.GRANITE,
                Material.DIORITE,
                Material.END_STONE,
                Material.GLOWSTONE,
                Material.SANDSTONE,
                Material.TERRACOTTA,
                Material.BASALT
        };

        for (Material materialItem : materials) {
            if (material.equals(materialItem)) {
                return true;
            }
        }

        return false;
    }
}
