package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Verification;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Verification.MaterialVerify;
import org.bukkit.Material;

public class PickaxeVerifier implements MaterialVerify {

    @Override
    public Boolean isMaterial(Material material) {
        return material.equals(Material.DIAMOND_PICKAXE)
                || material.equals(Material.GOLDEN_PICKAXE)
                || material.equals(Material.IRON_PICKAXE)
                || material.equals(Material.STONE_PICKAXE)
                || material.equals(Material.WOODEN_PICKAXE)
                || material.equals(Material.NETHERITE_PICKAXE);
    }
}
