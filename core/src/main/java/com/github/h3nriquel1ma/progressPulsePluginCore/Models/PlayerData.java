package com.github.h3nriquel1ma.progressPulsePluginCore.Models;

// Modelo de dados para o jogador (pontos de combate, mineração, construção, coleta de recursos, pesca, ...).

public class PlayerData {
    private int combatPoints;
    private int miningPoints;
    private int constrnPoints;
    private int resCollPoints;
    private int fishingPoints;

    public PlayerData(int combatPoints, int miningPoints, int constrnPoints, int resCollPoints, int fishingPoints) {
        this.combatPoints = combatPoints;
        this.miningPoints = miningPoints;
        this.constrnPoints = constrnPoints;
        this.resCollPoints = resCollPoints;
        this.fishingPoints = fishingPoints;
    }

    public int getCombatPoints() {
        return combatPoints;
    }

    public int getConstrnPoints() {
        return constrnPoints;
    }

    public int getFishingPoints() {
        return fishingPoints;
    }

    public int getMiningPoints() {
        return miningPoints;
    }

    public int getResCollPoints() {
        return resCollPoints;
    }
}
