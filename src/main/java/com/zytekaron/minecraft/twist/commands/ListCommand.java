package com.zytekaron.minecraft.twist.commands;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ListCommand extends CommandAPICommand {
    private final PlayerManager playerManager;
    
    public ListCommand(Twist twist) {
        super("list");
        withShortDescription("List players roles for the Twist game");
        executes(this::run);
        register();

        this.playerManager = twist.getPlayerManager();
    }

    public void run(CommandSender sender, Object[] args) {
        sender.sendMessage(ChatColor.GOLD + "================");

        var runners = this.playerManager.getRunners();
        if (runners.size() == 0) {
            sender.sendMessage(ChatColor.GREEN + "Runners: " + ChatColor.GRAY + "None");
        } else {
            sender.sendMessage(ChatColor.GREEN + "Runners:");
            runners.forEach(player -> sender.sendMessage("- " + ChatColor.YELLOW + player.getName()));
        }

        var hunters = this.playerManager.getHunters();
        if (hunters.size() == 0) {
            sender.sendMessage(ChatColor.RED + "Hunters: " + ChatColor.GRAY + "None");
        } else {
            sender.sendMessage(ChatColor.RED + "Hunters:");
            hunters.forEach(player -> sender.sendMessage("- " + ChatColor.YELLOW + player.getName()));
        }

        var spectators = this.playerManager.getSpectators();
        if (spectators.size() > 0) {
            sender.sendMessage(ChatColor.GRAY + "Spectators:");
            spectators.forEach(player -> sender.sendMessage("- " + ChatColor.YELLOW + player.getName()));
        }
        sender.sendMessage(ChatColor.GOLD + "================");
    }
}
