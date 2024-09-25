package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public abstract class CreationTableManager {

    private final LogUtil<String> loggerPlugin;
    private final ConnectionManager databaseManagement;

    protected CreationTableManager(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);
        this.databaseManagement = new DatabaseManagement(plugin);
    }

    protected CompletableFuture<Void> createTable(String sql, String tableName) {
        return CompletableFuture.runAsync(() -> {
            try (Connection connection = databaseManagement.getConnection("progress.db")) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.execute();

                loggerPlugin.printInfo(tableName + " table created");
            } catch (SQLException error) {
                loggerPlugin.printErr("Error creating " + tableName + " table: " + error.getMessage());
            }
        });
    }
}
