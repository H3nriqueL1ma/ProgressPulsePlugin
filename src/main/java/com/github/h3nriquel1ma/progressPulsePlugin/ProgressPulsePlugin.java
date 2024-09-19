package com.github.h3nriquel1ma.progressPulsePlugin;

import com.github.h3nriquel1ma.progressPulsePlugin.Commands.SkillsXpListCommand;
import com.github.h3nriquel1ma.progressPulsePlugin.Events.*;
import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

// Classe principal de habilitação e desabilitação de ouvintes de eventos (listeners) e comandos.
public final class ProgressPulsePlugin extends JavaPlugin {

    PlayerScoreManager playerScoreManager = new PlayerScoreManager();

    @Override
    public void onEnable() {
        getLogger().info("ProgressPulse has been enabled!");

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        getLogger().info("ProgressPulse has been disabled!");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new CombatEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new MiningEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new ConstructionEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new ResourceCollectionEventListener(playerScoreManager), this);
        getServer().getPluginManager().registerEvents(new FishingEventListener(playerScoreManager), this);
    }

    private void registerCommands() {
        Objects.requireNonNull(this.getCommand("skillsXP")).setExecutor(new SkillsXpListCommand(playerScoreManager));
    }
}
