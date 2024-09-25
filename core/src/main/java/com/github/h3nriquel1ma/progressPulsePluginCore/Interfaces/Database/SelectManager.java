package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;

import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;

public interface SelectManager {
    PlayerData select(String playerId);
}
