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
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;

public final class ProgressPulsePlugin extends JavaPlugin {

    private final ConnectionManager databaseManagement;
    private final CreationManager databasePlayerTableCreator;
    private final CreationManager databasePlayerDataTableCreator;
    private final Register registerListeners;
    private final Register registerCommands;
    private final Connection connection;
    private final SpacingUtil spacingChatText;
    private final LogUtil<String> loggerPlugin;

    public ProgressPulsePlugin(Connection connection, SpacingUtil spacingChatText) {
        this.databasePlayerTableCreator = new DatabasePlayerTableCreator(this, connection);
        this.databasePlayerDataTableCreator = new DatabasePlayerDataTableCreator(connection, this);
        this.connection = connection;
        this.spacingChatText = spacingChatText;
        this.loggerPlugin = new LoggerPlugin(this);
        this.registerCommands = new RegisterCommands(this);
        this.registerListeners = new RegisterListeners(this);
        this.databaseManagement = new DatabaseManagement(this);
    }

    @Override
    public void onEnable() {
        loggerPlugin.printInfo("ProgressPulse has been enabled!");

        databaseManagement.connect();

        databasePlayerTableCreator.create();
        databasePlayerDataTableCreator.create();

        registerListeners.register(new JoinEventListener(connection, this),
                                    new CombatEventListener(connection, this),
                                    new ConstructionEventListener(connection, this),
                                    new FishingEventListener(connection, this),
                                    new MiningEventListener(connection, this),
                                    new ResourceCollectionEventListener(connection, this));
        registerCommands.register(
                "skillsXP",
                new SkillsXpListCommand(connection, this, spacingChatText)
        );
    }

    @Override
    public void onDisable() {
        databaseManagement.disconnect();

        loggerPlugin.printInfo("ProgressPulse has been disabled!");
    }
}
