package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManagement implements ConnectionManager {

    private static DatabaseManagement instance;
    private Connection connection;
    private final LogUtil<String> loggerPlugin;

    private DatabaseManagement(Plugin plugin) {
        this.loggerPlugin = new LoggerPlugin(plugin);

        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }

            connection = DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/progress.db");
            loggerPlugin.printInfo("Database established connection!");
        } catch (Exception error) {
            loggerPlugin.printErr("Error connecting to database: " + error.getMessage());
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
        try {
            if (connection.isValid(15) && !connection.isClosed()) {
                connection.close();

                loggerPlugin.printInfo("Database disconnected...");
            }
        } catch (SQLException error) {
            loggerPlugin.printErr("Error disconnecting the database: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
