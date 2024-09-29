package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class InsertDataManager {

    private final LogUtil<String> loggerPlugin;
    private final ConnectionManager databaseManagement;

    protected InsertDataManager(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);
        this.databaseManagement = DatabaseManagement.getInstance(plugin);
    }

    public void insertData(String sql, String tableName, Object... params) {
        try (Connection connection = databaseManagement.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            int index = 1;

            for (Object param : params) {
                statement.setObject(index++, param);
            }

            statement.executeUpdate();

            loggerPlugin.printInfo("Inserting data in " + tableName + " successfully!");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error inserting data in " + tableName + " table: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }
}
