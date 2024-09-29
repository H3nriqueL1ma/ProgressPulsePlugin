package com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.SubRegisters;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class RegisterListeners implements Register {

    private final Plugin plugin;

    public RegisterListeners(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void register(Listener... listeners) {
        for (Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
