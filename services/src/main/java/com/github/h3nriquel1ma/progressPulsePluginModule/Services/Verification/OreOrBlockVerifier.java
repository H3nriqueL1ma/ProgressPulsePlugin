package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Verification;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Verification.MaterialVerify;
import org.bukkit.Material;

public class OreOrBlockVerifier implements MaterialVerify {

    @Override
    public Boolean isMaterial(Material material) {
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
