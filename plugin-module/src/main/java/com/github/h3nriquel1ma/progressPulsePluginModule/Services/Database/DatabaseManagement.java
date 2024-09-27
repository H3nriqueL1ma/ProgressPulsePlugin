package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManagement implements ConnectionManager {

    private static DatabaseManagement instance;
    private final HikariDataSource dataSource;
    private final LogUtil<String> loggerPlugin;

    private DatabaseManagement(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);
        HikariConfig config = new HikariConfig();

        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }

            config.setJdbcUrl("jdbc:sqlite:" + plugin.getDataFolder() + "/progress.db");
            config.setMaximumPoolSize(5);
            config.setConnectionTimeout(30000);
            config.setIdleTimeout(600000);
            config.setMaxLifetime(1800000);

            this.dataSource = new HikariDataSource(config);

            loggerPlugin.printInfo("Database established connection pool!");
        } catch (Exception error) {
            loggerPlugin.printErr("Error setting up connection pool: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    public static synchronized DatabaseManagement getInstance(Plugin plugin) {
        if (instance == null) {
            instance = new DatabaseManagement(plugin);
        }

        return instance;
    }

    @Override
    public void disconnect() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();

            loggerPlugin.printInfo("Database pool connection closed...");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException error) {
            loggerPlugin.printErr("Error getting connection from pool: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }
}
