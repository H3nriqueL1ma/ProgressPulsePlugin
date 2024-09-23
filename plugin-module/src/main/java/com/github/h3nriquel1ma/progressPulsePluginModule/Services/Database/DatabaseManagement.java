package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManagement implements ConnectionManager {

    private final Plugin plugin;
    private Connection connection;
    private final LogUtil<String> loggerPlugin;

    public DatabaseManagement(Plugin plugin) {
        this.plugin = plugin;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public void connect() {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }

            String url = "jdbc:sqlite:" + plugin.getDataFolder() + "/progress.db";
            connection = DriverManager.getConnection(url);

            loggerPlugin.printInfo("Database connection established");
        } catch (SQLException error) {
            loggerPlugin.printErr("Error connecting to database: " + error.getMessage());
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection.isValid(15)) {
                connection.close();

                loggerPlugin.printInfo("Database disconnected");
            }
        } catch (SQLException error) {
            loggerPlugin.printErr("Error disconnecting the database: " + error.getMessage());
        }
    }

    @Override
    public Connection getConnection(String databaseName) {
        try {
            String url = "jdbc:sqlite:" + plugin.getDataFolder() + "/" + databaseName;

            return DriverManager.getConnection(url);
        } catch (SQLException error) {
            loggerPlugin.printErr("Error getting database connection: " + error.getMessage());
        }
        return null;
    }
}
