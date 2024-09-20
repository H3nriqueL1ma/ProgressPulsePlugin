package com.github.h3nriquel1ma.progressPulsePluginModule.Services;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.CreationTableManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePlayerTableCreator extends CreationTableManager {

    public DatabasePlayerTableCreator(Plugin plugin, Connection connection) {
        super(connection, plugin);
    }

    @Override
    public void create() {
        String sql = "CREATE TABLE IF NOT EXISTS players(" +
                        "playerId TEXT PRIMARY KEY NOT NULL, " +
                        ");";

        createTable(sql, "Player");
    }
}
