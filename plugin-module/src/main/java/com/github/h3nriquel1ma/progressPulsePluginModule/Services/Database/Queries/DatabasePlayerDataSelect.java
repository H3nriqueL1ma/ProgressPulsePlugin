package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.SelectDataManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DatabasePlayerDataSelect extends SelectDataManager implements SelectManager {

    private final LogUtil<String> loggerPlugin;

    public DatabasePlayerDataSelect(Connection connection, Plugin plugin) {
        super(connection, plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public PlayerData select(UUID playerId) {
        String sql = "SELECT combatPoints, constructionPoints, fishingPoints, miningPoints, resourceColPoints FROM playersData WHERE playerId = ?;";

        ResultSet playerData = selectData(sql, "PlayersData", playerId);

        try {
            if (playerData.next()) {
                int combatPoints = playerData.getInt("combatPoints");
                int constructionPoints = playerData.getInt("constructionPoints");
                int fishingPoints = playerData.getInt("fishingPoints");
                int miningPoints = playerData.getInt("miningPoints");
                int resourceColPoints = playerData.getInt("resourceColPoints");

                return new PlayerData(combatPoints, miningPoints, constructionPoints, resourceColPoints, fishingPoints);
            }
        } catch (SQLException error) {
            loggerPlugin.printErr("Error returning the player data from the table: " + error.getMessage());
        }

        return null;
    }
}
