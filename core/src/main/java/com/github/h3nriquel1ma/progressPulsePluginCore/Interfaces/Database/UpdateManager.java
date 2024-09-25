package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import java.util.concurrent.CompletableFuture;

public interface UpdateManager {
    CompletableFuture<Void> update(String playerId, String updateParam);
}
