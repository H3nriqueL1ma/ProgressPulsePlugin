package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;

import java.util.UUID;

public interface SelectManager {
    default PlayerData select(UUID playerId) {
        return null;
    }
}
