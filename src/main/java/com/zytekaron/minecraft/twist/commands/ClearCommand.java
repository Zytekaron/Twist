package com.zytekaron.minecraft.twist.commands;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ClearCommand extends CommandAPICommand {
    private final PlayerManager playerManager;

    public ClearCommand(Twist twist) {
        super("clear");
        withPermission("twist.command.clear");
        withShortDescription("Clear all player roles for Twist");
        executes(this::run);
        register();

        this.playerManager = twist.getPlayerManager();
    }

    public void run(CommandSender sender, Object[] args) {
        playerManager.clear();

        sender.sendMessage(ChatColor.GREEN + "Cleared all players");
    }
}
