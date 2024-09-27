package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.sql.*;

public abstract class SelectDataManager {

    private final ConnectionManager databaseManagement;

    protected SelectDataManager(Plugin plugin) {
        this.databaseManagement = DatabaseManagement.getInstance(plugin);
    }

    public ResultSet selectData(String sql, Object... params) throws SQLException {
        Connection connection = databaseManagement.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        int index = 1;
        for (Object param : params) {
            statement.setObject(index++, param);
        }

        return statement.executeQuery();
    }
}
