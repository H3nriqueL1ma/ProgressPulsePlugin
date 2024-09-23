package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SelectDataManager {

    private final Connection connection;
    private final LogUtil<String> loggerPlugin;

    protected SelectDataManager(Connection connection, Plugin plugin) {
        this.connection = connection;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    public ResultSet selectData(String sql, String tableName, Object... params) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int index = 1;

            for (Object param : params) {
                statement.setObject(index++, param);
            }

            ResultSet data = statement.executeQuery();

            loggerPlugin.printInfo("Selecting data from " + tableName + " successfully");

            return data;
        } catch (SQLException error) {
            loggerPlugin.printErr("Error selecting data from " + tableName + " table: " + error.getMessage());
        }

        return null;
    }
}
