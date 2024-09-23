package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.InsertDataManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.util.UUID;

public class DatabasePlayerDataInsert extends InsertDataManager implements InsertManager {

    private final SelectManager databasePlayerDataSelect;

    public DatabasePlayerDataInsert(Connection connection, Plugin plugin) {
        super(connection, plugin);
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(connection, plugin);
    }

    @Override
    public void insert(int combatPoints, int constructionPoints, int fishingPoints, int miningPoints, int resourceColPoints, UUID playerId) {
        if (databasePlayerDataSelect.select(playerId) != null) {
            String sql = "INSERT INTO playersData(combatPoints, constructionPoints, fishingPoints, miningPoints, resourceColPoints, playerId) VALUES(?, ?, ?, ?, ?, ?);";

            insertData(sql, "PlayersData", combatPoints, constructionPoints, fishingPoints, miningPoints, resourceColPoints, playerId);
        }
    }
}
