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
        this.databaseManagement = new DatabaseManagement(plugin);
    }

    public void insertData(String sql, String tableName, Object... params) {
        try {
            Connection connection = databaseManagement.getConnection("progress.db");
            PreparedStatement statement = connection.prepareStatement(sql);

            int index = 1;

            StringBuilder sqlWithValues = new StringBuilder(sql);
            for (Object param : params) {
                String paramValue = param instanceof String ? "'" + param + "'" : param.toString();
                int placeholderIndex = sqlWithValues.indexOf("?");
                if (placeholderIndex != -1) {
                    sqlWithValues.replace(placeholderIndex, placeholderIndex + 1, paramValue);
                }
            }
            // Log da SQL completa
            loggerPlugin.printInfo("Executing SQL: " + sqlWithValues.toString());

            for (Object param : params) {
                statement.setObject(index++, param);
            }

            statement.executeUpdate();

            loggerPlugin.printInfo("Inserting data in " + tableName + " successfully");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error inserting data in " + tableName + " table: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }
}
