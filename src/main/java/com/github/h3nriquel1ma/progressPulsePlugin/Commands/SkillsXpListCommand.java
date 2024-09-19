package com.github.h3nriquel1ma.progressPulsePlugin.Commands;

import com.github.h3nriquel1ma.progressPulsePlugin.ExperienceScore.PlayerScoreManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

// Comando que retorna o XP das skills do jogador.
public class SkillsXpListCommand implements CommandExecutor {

    private final PlayerScoreManager playerScoreManager;

    public SkillsXpListCommand(PlayerScoreManager playerScoreManager) {
        this.playerScoreManager = playerScoreManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            UUID playerId = player.getUniqueId();
            String playerName = player.getName();

            Integer playerCombatPoints = playerScoreManager.getPlayerCombatPoints(playerId);
            Integer playerConstructionPoints = playerScoreManager.getPlayerConstrnPoints(playerId);
            Integer playerFishingPoints = playerScoreManager.getPlayerFishingPoints(playerId);
            Integer playerMiningPoints = playerScoreManager.getPlayerMiningPoints(playerId);
            Integer playerResPoints = playerScoreManager.getPlayerResourcePoints(playerId);

            player.sendMessage(
                    Component.text().content(playerName + " Skills").color(TextColor.color(255, 153, 51))
                            .append(Component.text("Combat: " + playerCombatPoints, TextColor.color(128, 128, 128))).decoration(TextDecoration.ITALIC, true)
                    );
        }

        return true;
    }
}
