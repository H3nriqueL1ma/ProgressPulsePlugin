package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.SelectDataManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabasePlayerDataSelect extends SelectDataManager implements SelectManager {

    private final LogUtil<String> loggerPlugin;
    private final ConnectionManager databaseManagement;

    public DatabasePlayerDataSelect(Plugin plugin) {
        super(plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
        this.databaseManagement = DatabaseManagement.getInstance(plugin);
    }

    @Override
    public PlayerData select(String playerId) {
        String sql = "SELECT combatPoints, constructionPoints, fishingPoints, miningPoints, resourceColPoints FROM players WHERE playerId = ?;";

        ResultSet playerData = null;

        try (Connection connection = databaseManagement.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, playerId);
            playerData = statement.executeQuery();

            if (playerData.next()) { //<- Erro aqui
                int combatPoints = playerData.getInt("combatPoints");
                int constructionPoints = playerData.getInt("constructionPoints");
                int fishingPoints = playerData.getInt("fishingPoints");
                int miningPoints = playerData.getInt("miningPoints");
                int resourceColPoints = playerData.getInt("resourceColPoints");

                return new PlayerData(combatPoints, miningPoints, constructionPoints, resourceColPoints, fishingPoints);
            } else {
                loggerPlugin.printInfo("Não retornado o ResultSet");
                return null;
            }
        } catch (SQLException error) {
            loggerPlugin.printErr("Error returning the player data from the table: " + error.getMessage());
            throw new RuntimeException(error);
        } finally {
            if (playerData != null) {
                try {
                    playerData.close();
                } catch (SQLException error) {
                    loggerPlugin.printErr("Error closing ResultSet: " + error.getMessage());
                }
            }
        }
    }
}
