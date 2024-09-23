package com.github.h3nriquel1ma.progressPulsePluginMain;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.SpacingUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Commands.SkillsXpListCommand;
import com.github.h3nriquel1ma.progressPulsePluginModule.Events.*;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerDataTableCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerTableCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.RegisterCommands;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.RegisterListeners;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.SpacingChatText;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProgressPulsePlugin extends JavaPlugin {

    private ConnectionManager databaseManagement;
    private LogUtil<String> loggerPlugin;

    public ProgressPulsePlugin() {}

    @Override
    public void onEnable() {
        loggerPlugin = new LoggerPlugin(this);
        loggerPlugin.printInfo("ProgressPulse has been enabled!");

        databaseManagement = new DatabaseManagement(this);
        databaseManagement.connect();

        CreationManager databasePlayerTableCreator = new DatabasePlayerTableCreator(this);
        databasePlayerTableCreator.create();

        CreationManager databasePlayerDataTableCreator = new DatabasePlayerDataTableCreator(this);
        databasePlayerDataTableCreator.create();

        Register registerListeners = new RegisterListeners(this);
        registerListeners.register(new JoinEventListener(this),
                                    new CombatEventListener(this),
                                    new ConstructionEventListener(this),
                                    new FishingEventListener(this),
                                    new MiningEventListener(this),
                                    new ResourceCollectionEventListener(this));

        Register registerCommands = new RegisterCommands(this);
        SpacingUtil spacingChatText = new SpacingChatText();
        registerCommands.register(
                "skillsXP",
                new SkillsXpListCommand(this, spacingChatText)
        );
    }

    @Override
    public void onDisable() {
        databaseManagement.disconnect();

        loggerPlugin.printInfo("ProgressPulse has been disabled!");
    }
}
