package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class CreationTableManager implements CreationManager {

    private final Connection connection;
    private final LogUtil<String> loggerPlugin;

    protected CreationTableManager(Connection connection, Plugin plugin) {
        this.connection = connection;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    protected void createTable(String sql, String tableName) {
        try (Statement statement = connection.createStatement()) {
           statement.execute(sql);

           loggerPlugin.printInfo(tableName + " table created");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error creating " + tableName + " table: " + error.getMessage());
        }
    }
}
