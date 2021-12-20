package com.zytekaron.minecraft.twist.commands;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import com.zytekaron.minecraft.twist.managers.PlayerType;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RunnerCommand extends CommandAPICommand {
    private final PlayerManager playerManager;

    public RunnerCommand(Twist twist) {
        super("runner");
        withPermission("twist.command.runner");
        withShortDescription("Set a player to be a runner");
        withArguments(new PlayerArgument("player"));
        executes(this::run);
        register();

        this.playerManager = twist.getPlayerManager();
    }

    public void run(CommandSender sender, Object[] args) {
        var player = (Player) args[0];

        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Could not find that player");
            return;
        }

        var text = Component.text()
                .content(Twist.PREFIX + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " is now a runner")
                .asComponent();
        Bukkit.broadcast(text);

        this.playerManager.setType(player, PlayerType.RUNNER);
    }
}
