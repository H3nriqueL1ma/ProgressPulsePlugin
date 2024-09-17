package com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore;

import com.github.h3nriquel1ma.progressPulsePlugin.Models.PlayerData;

import java.util.*;

// Sistema de gerenciamento de pontos dos jogadores.
public class PlayerScoreManager {
    private final Map<UUID, PlayerData> playersData = new HashMap<>();

    public void setPlayerId(UUID playerId) {
        if (!isPlayerIdExisting(playerId)) {
            PlayerData newPlayer = new PlayerData();

            this.playersData.put(playerId, newPlayer);
        }
    }

    public Boolean isPlayerIdExisting(UUID playerId) {
        return this.playersData.containsKey(playerId);
    }

    public void incrementCombatPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            player.incrementCombatPoints();
        }
    }

    public Integer getPlayerCombatPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            return player.getCombatPoints();
        }

        return 0;
    }

    public void incrementMiningPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            player.incrementMiningPoints();
        }
    }

    public Integer getPlayerMiningPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            return player.getMiningPoints();
        }

        return 0;
    }

    public void incrementConstrnPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            player.incrementConstrnPoints();
        }
    }

    public Integer getPlayerConstrnPoints(UUID playerId) {
        if (isPlayerIdExisting(playerId)) {
            PlayerData player = playersData.get(playerId);

            return player.getConstrnPoints();
        }

        return 0;
    }
}
