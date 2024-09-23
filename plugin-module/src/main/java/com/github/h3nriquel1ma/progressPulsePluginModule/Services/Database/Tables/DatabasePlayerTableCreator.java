package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.CreationTableManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;

public class DatabasePlayerTableCreator extends CreationTableManager implements CreationManager {

    public DatabasePlayerTableCreator(Plugin plugin, Connection connection) {
        super(connection, plugin);
    }

    @Override
    public void create() {
        String sql = "CREATE TABLE IF NOT EXISTS players(" +
                        "playerId TEXT PRIMARY KEY NOT NULL, " +
                        ");";

        createTable(sql, "Players");
    }
}
