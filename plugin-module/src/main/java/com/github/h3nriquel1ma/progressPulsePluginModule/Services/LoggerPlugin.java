package com.github.h3nriquel1ma.progressPulsePluginModule.Services;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import org.bukkit.plugin.Plugin;

public class LoggerPlugin implements LogUtil<String> {

    private final Plugin plugin;

    public LoggerPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void printInfo(String data) {
        plugin.getLogger().info(data);
    }

    @Override
    public void printErr(String data) {
        plugin.getLogger().severe(data);
    }
}
