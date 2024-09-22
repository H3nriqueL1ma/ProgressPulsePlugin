package com.github.h3nriquel1ma.progressPulsePluginMain;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerDataTableCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerTableCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;

public final class ProgressPulsePlugin extends JavaPlugin {

    private final ConnectionManager databaseManagement;
    private final CreationManager databasePlayerTableCreator;
    private final CreationManager databasePlayerDataTableCreator;

    public ProgressPulsePlugin(Connection connection) {
        this.databasePlayerTableCreator = new DatabasePlayerTableCreator(this, connection);
        this.databasePlayerDataTableCreator = new DatabasePlayerDataTableCreator(connection, this);
        this.databaseManagement = new DatabaseManagement(this);
    }

    @Override
    public void onEnable() {
        databaseManagement.connect();

        databasePlayerTableCreator.create();
        databasePlayerDataTableCreator.create();
    }

    @Override
    public void onDisable() {
        databaseManagement.disconnect();
    }
}
