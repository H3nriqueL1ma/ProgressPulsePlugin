package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.InsertManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database.InsertDataManager;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;

public class DatabasePlayerInsert extends InsertDataManager implements InsertManager {

    protected DatabasePlayerInsert(Connection connection, Plugin plugin) {
        super(connection, plugin);
    }

    @Override
    public void insert() {
        String sql = "INSERT INTO players("
    }
}
