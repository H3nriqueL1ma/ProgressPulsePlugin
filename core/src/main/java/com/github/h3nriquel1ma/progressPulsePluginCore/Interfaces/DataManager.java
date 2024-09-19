package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces;

import java.util.UUID;

public interface DataManager {
    void increment(UUID playerId);
    void get(UUID playerId);
}
