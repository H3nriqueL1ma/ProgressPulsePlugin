package com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import com.github.h3nriquel1ma.progressPulsePluginModule.Commands.SkillsXpListCommand;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.SubRegisters.RegisterCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsStaticRegister {

    public static void register(JavaPlugin plugin) {
        Register registerCommands = new RegisterCommands(plugin);

        registerCommands.register(
                "skills",
                new SkillsXpListCommand(plugin)
        );
    }
}
