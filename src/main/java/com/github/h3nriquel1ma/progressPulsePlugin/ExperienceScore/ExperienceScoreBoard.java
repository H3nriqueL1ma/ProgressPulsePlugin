package com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.*;

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
            objective = scoreboard.registerNewObjective("playerExperience", "dummy", Component.text("Stats (" + player.getName() + ")"));

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        player.setScoreboard(scoreboard);

        Objective finalObjective = objective;

        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            Score score = finalObjective.getScore(ChatColor.RED + "Combat: ");
            score.setScore(playerScoreManager.getPlayerCombatPoints(player.getUniqueId()));

            player.setScoreboard(scoreboard);
        }, 0L, 20L);
    }
}
