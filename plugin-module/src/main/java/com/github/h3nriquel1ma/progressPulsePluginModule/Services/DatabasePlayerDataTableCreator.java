package com.github.h3nriquel1ma.progressPulsePluginModule.Services;

import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.CreationTableManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;

public class DatabasePlayerDataTableCreator extends CreationTableManager {

    protected DatabasePlayerDataTableCreator(Connection connection, Plugin plugin) {
        super(connection, plugin);
    }

    @Override
    public void create() {
        String sql = "CREATE TABLE IF NOT EXISTS playersData(" +
                        "datasId TEXT PRIMARY KEY NOT NULL, " +
                        "combatPoints INTEGER NOT NULL, " +
                        "constructionPoints INTEGER NOT NULL, " +
                        "fishingPoints INTEGER NOT NULL, " +
                        "miningPoints INTEGER NOT NULL, " +
                        "resoureColPoints INTEGER NOT NULL, " +
                        ");";
    }
}
