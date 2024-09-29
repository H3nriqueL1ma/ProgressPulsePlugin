package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public interface Register {
    default void register(Listener... listeners) {}
    default void register(String commandName, CommandExecutor command) {}
    default void register(String[] commandsName, CommandExecutor... commands) {}
}
