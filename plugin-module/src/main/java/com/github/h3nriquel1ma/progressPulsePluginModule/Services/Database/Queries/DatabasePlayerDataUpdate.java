package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.UpdateManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.UpdateDataManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class DatabasePlayerDataUpdate extends UpdateDataManager implements UpdateManager {

    private final SelectManager databasePlayerDataSelect;
    private final LogUtil<String> loggerPlugin;

    public DatabasePlayerDataUpdate(Plugin plugin) {
        super(plugin);
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public CompletableFuture<Void> update(String playerId, String updateParam) {
        return CompletableFuture.runAsync(() -> {
            if (databasePlayerDataSelect.select(playerId) != null) {
                String sql = "UPDATE ? FROM players WHERE playerID = ?";

                updateData(sql, "Players", updateParam, playerId);
            } else {
                loggerPlugin.printErr("Error: PlayerId not exists!");
            }
        });
    }
}
