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

public abstract class UpdateDataManager {

    private final LogUtil<String> loggerPlugin;
    private final ConnectionManager databaseManagement;

    protected UpdateDataManager(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);
        this.databaseManagement = new DatabaseManagement(plugin);
    }

    public CompletableFuture<Void> updateData(String sql, String tableName, Object... params) {
        return CompletableFuture.runAsync(() -> {
            try (Connection connection = databaseManagement.getConnection("progress.db")) {
                PreparedStatement statement = connection.prepareStatement(sql);

                int index = 1;

                for (Object param : params) {
                    statement.setObject(index++, param);
                }

                statement.executeUpdate();

                loggerPlugin.printInfo("Updating data in " + tableName + "successfully");
            } catch (SQLException error) {
                loggerPlugin.printErr("Error updating data in " + tableName + "table: " + error.getMessage());
            }
        });
    }
}
