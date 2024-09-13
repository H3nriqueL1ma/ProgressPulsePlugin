package com.github.h3nriquel1ma.progressPulsePlugin;

import com.github.h3nriquel1ma.progressPulsePlugin.Events.CombatEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProgressPulsePlugin extends JavaPlugin {

    // Utilizado para registrar ouvintes de eventos.
    @Override
    public void onEnable() {
        getLogger().info("ProgressPulse has been enabled!");
        getServer().getPluginManager().registerEvents(new CombatEventListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ProgressPulse has been disabled!");
    }
}
