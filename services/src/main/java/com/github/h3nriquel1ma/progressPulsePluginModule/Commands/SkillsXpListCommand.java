package com.github.h3nriquel1ma.progressPulsePluginModule.Commands;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.SelectManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Models.PlayerData;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Queries.DatabasePlayerDataSelect;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

// Comando que retorna o XP das skills do jogador.
public class SkillsXpListCommand implements CommandExecutor {

    private final SelectManager databasePlayerDataSelect;
    private final LogUtil<String> loggerPlugin;

    public SkillsXpListCommand(Plugin plugin) {
        this.databasePlayerDataSelect = new DatabasePlayerDataSelect(plugin);
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            String playerId = player.getUniqueId().toString();
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
                                .append(
                                        Component.text("-------------------------------------\n", TextColor.color(255, 153, 51))
                                )
                                .content(playerName + " Skills \n")
                                .color(TextColor.color(255, 153, 51))
                                .append(
                                        Component.text(playerCombatPoints, TextColor.color(50, 205, 50)),
                                        Component.text("     Combat" + "\n", TextColor.color(128, 128, 128), TextDecoration.ITALIC)
                                        )
                                .append(
                                        Component.text(playerConstructionPoints, TextColor.color(50, 205, 50)),
                                        Component.text("     Construction" + "\n", TextColor.color(128, 128, 128), TextDecoration.ITALIC)
                                        )
                                .append(
                                        Component.text(playerFishingPoints, TextColor.color(50, 205, 50)),
                                        Component.text("     Fishing" + "\n", TextColor.color(128, 128, 128), TextDecoration.ITALIC)
                                        )
                                .append(
                                        Component.text(playerMiningPoints, TextColor.color(50, 205, 50)),
                                        Component.text("     Mining" + "\n", TextColor.color(128, 128, 128), TextDecoration.ITALIC)
                                        )
                                .append(
                                        Component.text(playerResPoints, TextColor.color(50, 205, 50)),
                                        Component.text("     Resourcing", TextColor.color(128, 128, 128), TextDecoration.ITALIC)
                                        )
                                .append(
                                        Component.text("\n-------------------------------------", TextColor.color(255, 153, 51))
                                )
                );
            } else {
                loggerPlugin.printErr("Error: playerData is null!");
            }
        }

        return true;
    }
}
