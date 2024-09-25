package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.SelectDataManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class DatabasePlayerDataSelect extends SelectDataManager implements SelectManager {

    private final LogUtil<String> loggerPlugin;

    public DatabasePlayerDataSelect(Plugin plugin) {
        super(plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public CompletableFuture<PlayerData> select(String playerId) {
        return CompletableFuture.supplyAsync(() -> {
            String sql = "SELECT combatPoints, constructionPoints, fishingPoints, miningPoints, resourceColPoints FROM players WHERE playerId = ?;";

            try {
                CompletableFuture<ResultSet> playerData = selectData(sql, "Players", playerId);
                ResultSet playerDataExtracted = playerData.get();

                if (playerDataExtracted.next()) {
                    int combatPoints = playerDataExtracted.getInt("combatPoints");
                    int constructionPoints = playerDataExtracted.getInt("constructionPoints");
                    int fishingPoints = playerDataExtracted.getInt("fishingPoints");
                    int miningPoints = playerDataExtracted.getInt("miningPoints");
                    int resourceColPoints = playerDataExtracted.getInt("resourceColPoints");

                    return new PlayerData(combatPoints, miningPoints, constructionPoints, resourceColPoints, fishingPoints);
                } else {
                    return null;
                }
            } catch (SQLException error) {
                loggerPlugin.printErr("Error returning the player data from the table: " + error.getMessage());
                throw new RuntimeException(error);
            } catch (ExecutionException | InterruptedException error) {
                loggerPlugin.printErr("Error executing the CompletableFuture for the player data: " + error.getMessage());
                throw new RuntimeException(error);
            }
        });
    }
}
