package com.zytekaron.minecraft.twist.commands;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import org.bukkit.command.CommandSender;

public class HunterChatCommand extends CommandAPICommand {
    private final PlayerManager playerManager;

    public HunterChatCommand(Twist twist) {
        super("hunterchat");
        withAliases("hchat", "h");
        withShortDescription("Send a message to all the hunters and spectators");
        withArguments(new GreedyStringArgument("message"));
        executes(this::run);
        register();

        this.playerManager = twist.getPlayerManager();
    }

    public void run(CommandSender sender, Object[] args) {
        var text = (String) args[0];

        playerManager.getHunters()
                .forEach(player -> sender.sendMessage("§c[Hunters] §r<" + sender.getName() + "> " + text));
        playerManager.getSpectators()
                .forEach(player -> sender.sendMessage("§c[Hunters] §r<" + sender.getName() + "> " + text));
    }
}
