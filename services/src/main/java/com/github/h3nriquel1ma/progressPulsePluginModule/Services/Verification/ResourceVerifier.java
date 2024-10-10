package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Verification;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Verification.MaterialVerify;
import org.bukkit.Material;

public class ResourceVerifier implements MaterialVerify {

    @Override
    public Boolean isMaterial(Material material) {
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
