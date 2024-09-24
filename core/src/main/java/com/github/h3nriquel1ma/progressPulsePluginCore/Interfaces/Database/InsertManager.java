package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import java.util.UUID;

public interface InsertManager {
    default void insert(String playerId) {}
    default void insert(int combatPoints, int constructionPoints, int fishingPoints, int miningPoints, int resourceColPoints, String playerId) {};
}
