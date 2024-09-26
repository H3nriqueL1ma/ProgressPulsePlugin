package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.*;

public abstract class SelectDataManager {

    private final LogUtil<String> loggerPlugin;
    private final ConnectionManager databaseManagement;

    protected SelectDataManager(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);
        this.databaseManagement = DatabaseManagement.getInstance(plugin);
    }

    public ResultSet selectData(String sql, String tableName, Object... params) {
        try (Connection connection = databaseManagement.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            int index = 1;

            for (Object param : params) {
                statement.setObject(index++, param);
            }

            return statement.executeQuery();
        } catch (SQLException error) {
            loggerPlugin.printErr("Error selecting data from " + tableName + " table: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }
}
