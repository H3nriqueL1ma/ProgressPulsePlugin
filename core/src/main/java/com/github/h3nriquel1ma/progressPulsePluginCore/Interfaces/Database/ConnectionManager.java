package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import java.sql.Connection;

public interface ConnectionManager {
    void connect();
    void disconnect();
    Connection getConnection(String databaseName);
}
