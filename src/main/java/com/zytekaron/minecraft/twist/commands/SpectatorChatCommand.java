package com.zytekaron.minecraft.twist.commands;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import org.bukkit.command.CommandSender;

public class SpectatorChatCommand extends CommandAPICommand {
    private final PlayerManager playerManager;

    public SpectatorChatCommand(Twist twist) {
        super("spectatorchat");
        withAliases("schat", "s");
        withShortDescription("Send a message to all the runners and spectators");
        withArguments(new GreedyStringArgument("message"));
        executes(this::run);
        register();

        this.playerManager = twist.getPlayerManager();
    }

    public void run(CommandSender sender, Object[] args) {
        var text = (String) args[0];

        playerManager.getSpectators()
                .forEach(player -> sender.sendMessage("§7[Spectators] §r<" + sender.getName() + "> " + text));
    }
}
