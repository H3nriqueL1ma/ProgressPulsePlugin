package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import java.util.concurrent.CompletableFuture;

public interface InsertManager {
    CompletableFuture<Void> insert(int combatPoints, int constructionPoints, int fishingPoints, int miningPoints, int resourceColPoints, String playerId);
}
