package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.InsertDataManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

public class DatabasePlayerInsert extends InsertDataManager implements InsertManager {

    private final SelectManager databasePlayerDataSelect;
    private final LogUtil<String> loggerPlugin;

    public DatabasePlayerInsert(Plugin plugin) {
        super(plugin);
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public void insert(String playerId) {
        if (databasePlayerDataSelect.select(playerId) == null) {
            String sql = "INSERT INTO players(playerId) VALUES(?);";

            insertData(sql, "Players", playerId);
        } else {
            loggerPlugin.printErr("Error: PlayerId already registered!");
        }
    }
}
