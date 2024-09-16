package com.github.h3nriquel1ma.progressPulsePlugin.Models;

public class PlayerData {
    private Integer combatPoints;

    public PlayerData() {
        this.combatPoints = 0;
    }

    public void incrementCombatPoints() {
        this.combatPoints++;
    }

    public Integer getCombatPoints() {
        return combatPoints;
    }
}
