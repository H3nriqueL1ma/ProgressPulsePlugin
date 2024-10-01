package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public interface Register {
    default void register(Listener... listeners) {}
    default void register(String commandName, CommandExecutor command) {}
    default void register(String[] commandsName, CommandExecutor... commands) {}
}
