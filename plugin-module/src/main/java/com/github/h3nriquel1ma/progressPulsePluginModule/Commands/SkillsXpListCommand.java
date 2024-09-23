package com.github.h3nriquel1ma.progressPulsePluginModule.Commands;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.SpacingUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataSelect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.UUID;

// Comando que retorna o XP das skills do jogador.
public class SkillsXpListCommand implements CommandExecutor {

    private final SelectManager databasePlayerDataSelect;
    private final SpacingUtil spacingChatText;

    public SkillsXpListCommand(Connection connection, Plugin plugin, SpacingUtil spacingChatText) {
        this.spacingChatText = spacingChatText;
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(connection, plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            UUID playerId = player.getUniqueId();
            String playerName = player.getName();

            PlayerData playerData = databasePlayerDataSelect.select(playerId);

            if (playerData != null) {
                int playerCombatPoints = playerData.getCombatPoints();
                int playerConstructionPoints = playerData.getConstrnPoints();
                int playerFishingPoints = playerData.getFishingPoints();
                int playerMiningPoints = playerData.getMiningPoints();
                int playerResPoints = playerData.getResCollPoints();

                player.sendMessage(
                        Component.text()
                                .content(playerName + " Skills")
                                .color(TextColor.color(255, 153, 51))
                                .append(
                                        Component.text(spacingChatText.addSpacing("Combat:", 20), TextColor.color(128, 128, 128), TextDecoration.ITALIC),
                                        Component.text(playerCombatPoints + "\n", TextColor.color(50, 205, 50)))
                                .append(
                                        Component.text(spacingChatText.addSpacing("Construction:", 20), TextColor.color(128, 128, 128), TextDecoration.ITALIC),
                                        Component.text(playerConstructionPoints + "\n", TextColor.color(50, 205, 50)))
                                .append(
                                        Component.text(spacingChatText.addSpacing("Fishing:", 20), TextColor.color(128, 128, 128), TextDecoration.ITALIC),
                                        Component.text(playerFishingPoints + "\n", TextColor.color(50, 205, 50)))
                                .append(
                                        Component.text(spacingChatText.addSpacing("Mining:", 20), TextColor.color(128, 128, 128), TextDecoration.ITALIC),
                                        Component.text(playerMiningPoints + "\n", TextColor.color(50, 205, 50)))
                                .append(
                                        Component.text(spacingChatText.addSpacing("Res. Collecting:", 20), TextColor.color(128, 128, 128), TextDecoration.ITALIC),
                                        Component.text(playerResPoints + "\n", TextColor.color(50, 205, 50)))
                );
            }
        }

        return true;
    }
}
