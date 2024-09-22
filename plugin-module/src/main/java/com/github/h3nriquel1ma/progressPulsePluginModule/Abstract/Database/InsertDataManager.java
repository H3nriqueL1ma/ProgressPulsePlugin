package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class InsertDataManager {

    private final Connection connection;
    private final LogUtil<String> loggerPlugin;

    protected InsertDataManager(Connection connection, Plugin plugin) {
        this.connection = connection;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    public void insertData(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);

            loggerPlugin.printInfo("Insert data successfully");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error inserting data in the table: " + error.getMessage());
        }
    }
}
