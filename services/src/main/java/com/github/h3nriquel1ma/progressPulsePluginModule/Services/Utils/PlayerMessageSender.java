package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.MessageUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;

public class PlayerMessageSender implements MessageUtil {

    @Override
    public void sendMessage(Player player, int playerPoints, String itemName) {
        player.sendMessage(
                Component.text()
                        .content("Congrats! ")
                        .color(TextColor.color(50, 205, 50))
                        .decoration(TextDecoration.BOLD, true)
                        .append(
                                Component.text("You reached level ", TextColor.color(255, 255, 0)),
                                Component.text(playerPoints, TextColor.color(173, 216, 230)),
                                Component.text(" and received ", TextColor.color(255, 255, 0)),
                                Component.text(itemName, TextColor.color(255, 215, 0)),
                                Component.text("!", TextColor.color(255, 255, 0))
                        )
        );
    }

    @Override
    public void sendMessageWithQuantity(Player player, int playerPoints, String itemName, int itemQuantity) {
        player.sendMessage(
                Component.text()
                        .content("Congrats! ")
                        .color(TextColor.color(50, 205, 50))
                        .decoration(TextDecoration.BOLD, true)
                        .append(
                                Component.text("You reached level ", TextColor.color(255, 255, 0)),
                                Component.text(playerPoints, TextColor.color(173, 216, 230)),
                                Component.text(" and received ", TextColor.color(255, 255, 0)),
                                Component.text("x" + itemQuantity + " ", TextColor.color(40, 40, 40)),
                                Component.text(itemName, TextColor.color(255, 215, 0)),
                                Component.text("!", TextColor.color(255, 255, 0))
                        )
        );
    }
}
