package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class CreationTableManager {

    private final Connection connection;
    private final LogUtil<String> loggerPlugin;

    protected CreationTableManager(Connection connection, Plugin plugin) {
        this.connection = connection;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    protected void createTable(String sql, String tableName) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.execute();

           loggerPlugin.printInfo(tableName + " table created");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error creating " + tableName + " table: " + error.getMessage());
        }
    }
}
