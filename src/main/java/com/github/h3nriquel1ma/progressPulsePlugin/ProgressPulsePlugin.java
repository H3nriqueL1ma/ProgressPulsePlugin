package com.github.h3nriquel1ma.progressPulsePlugin;

import com.github.h3nriquel1ma.progressPulsePlugin.Events.CombatEventListener;
import com.github.h3nriquel1ma.progressPulsePlugin.Events.JoinEventListener;
import com.github.h3nriquel1ma.progressPulsePlugin.Events.MiningEventListener;
import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.ExperienceScoreBoard;
import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import org.bukkit.plugin.java.JavaPlugin;

// Classe principal de habilitação e desabilitação de ouvintes de eventos (listeners) e comandos.
public final class ProgressPulsePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ProgressPulse has been enabled!");

        registerListeners();
    }

    @Override
    public void onDisable() {
        getLogger().info("ProgressPulse has been disabled!");
    }

    private void registerListeners() {
        PlayerScoreManager playerScoreManager = new PlayerScoreManager();
        ExperienceScoreBoard experienceScoreBoard = new ExperienceScoreBoard(playerScoreManager, this);

        getServer().getPluginManager().registerEvents(new JoinEventListener(playerScoreManager, experienceScoreBoard), this);
        getServer().getPluginManager().registerEvents(new CombatEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new MiningEventListener(playerScoreManager), this);
    }
}
