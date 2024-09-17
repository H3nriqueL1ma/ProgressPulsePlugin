package com.github.h3nriquel1ma.progressPulsePlugin.Models;

// Modelo de dados para o jogador (pontos de combate, mineração, construção, coleta de recursos, pesca, ...).
public class PlayerData {
    private Integer combatPoints = 0;
    private Integer miningPoints = 0;
    private Integer constrnPoints = 0;
    private Integer resCollPoints = 0;

    public void incrementCombatPoints() {
        this.combatPoints++;
    }
    public Integer getCombatPoints() {
        return combatPoints;
    }

    public void incrementMiningPoints() {
        this.miningPoints++;
    }
    public Integer getMiningPoints() {
        return miningPoints;
    }

    public void incrementConstrnPoints() {
        this.constrnPoints++;
    }
    public Integer getConstrnPoints() {
        return constrnPoints;
    }

    public void incrementResCollPoints() {
        this.resCollPoints++;
    }
    public Integer getResCollPoints() {
        return resCollPoints;
    }
}
