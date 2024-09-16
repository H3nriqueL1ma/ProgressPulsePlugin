package com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ExperienceScoreBoard {
    public void createExperienceBoard(Player player) {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.getObjective("playerExperience");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("playerExperience", "dummy", Component.text("Habilidades"));

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score score = objective.getScore(ChatColor.RED + "Combate: ");
            score.setScore(0);

        }

        player.setScoreboard(scoreboard);
    }
}
