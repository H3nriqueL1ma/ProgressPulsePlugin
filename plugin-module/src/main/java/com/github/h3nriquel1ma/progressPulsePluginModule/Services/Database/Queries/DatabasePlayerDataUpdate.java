package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.UpdateDataManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.util.UUID;

public class DatabasePlayerDataUpdate extends UpdateDataManager implements UpdateManager {

    private final SelectManager databasePlayerDataSelect;

    public DatabasePlayerDataUpdate(Connection connection, Plugin plugin) {
        super(connection, plugin);
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(connection, plugin);
    }

    @Override
    public void update(UUID playerId, String updateParam) {
        if (databasePlayerDataSelect.select(playerId) != null) {
            String sql = "UPDATE ? FROM playersData WHERE playerID = ?";

            updateData(sql, "PlayersData", updateParam, playerId);
        }
    }
}
