package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface SelectManager {
    CompletableFuture<PlayerData> select(String playerId);
}
