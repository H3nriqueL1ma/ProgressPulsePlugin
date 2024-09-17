package com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.*;

// Sistema de Scoreboard do jogador (parte visual).
public class ExperienceScoreBoard {
    private final PlayerScoreManager playerScoreManager;
    private final Plugin plugin;

    public ExperienceScoreBoard(PlayerScoreManager playerScoreManager, Plugin plugin) {
        this.playerScoreManager = playerScoreManager;
        this.plugin = plugin;
    }

    public void createExperienceBoard(Player player) {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.getObjective("playerExperience");

        if (objective == null) {
            objective = scoreboard.registerNewObjective("playerExperience", "dummy", Component.text(ChatColor.GOLD + "Stats (" + player.getName() + ")"));

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        player.setScoreboard(scoreboard);

        Objective finalObjective = objective;

        Bukkit.getScheduler().runTaskTimer(plugin, () -> {


            Score lineTop = finalObjective.getScore("§l§m----------------");
            lineTop.setScore(0);

            Score combatScore = finalObjective.getScore(ChatColor.DARK_GRAY + "Combat: ");
            combatScore.setScore(playerScoreManager.getPlayerCombatPoints(player.getUniqueId()));

            Score miningScore = finalObjective.getScore(ChatColor.DARK_GRAY + "Mining: ");
            miningScore.setScore(playerScoreManager.getPlayerMiningPoints(player.getUniqueId()));

            Score constrnScore = finalObjective.getScore(ChatColor.DARK_GRAY + "Construction: ");
            constrnScore.setScore(playerScoreManager.getPlayerConstrnPoints(player.getUniqueId()));

            Score resourceScore = finalObjective.getScore(ChatColor.DARK_GRAY + "Res. Collection: ");
            resourceScore.setScore(playerScoreManager.getPlayerResourcePoints(player.getUniqueId()));

            player.setScoreboard(scoreboard);
        }, 0L, 20L);
    }
}
