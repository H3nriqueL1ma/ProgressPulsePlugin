package com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.SubRegisters;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class RegisterCommands implements Register {

    private final JavaPlugin plugin;

    public RegisterCommands(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void register(String commandName, CommandExecutor command) {
        Objects.requireNonNull(plugin.getCommand(commandName)).setExecutor(command);
    }

    @Override
    public void register(String[] commandsName, CommandExecutor... commands) {
        int index = 0;

        for (CommandExecutor command : commands) {
            if (index < commandsName.length) {
                Objects.requireNonNull(plugin.getCommand(commandsName[index])).setExecutor(command);
                index++;
            } else {
                break;
            }
        }
    }
}
