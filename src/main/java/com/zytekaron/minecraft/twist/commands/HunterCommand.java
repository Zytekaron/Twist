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

public class HunterCommand extends CommandAPICommand {
    private final PlayerManager playerManager;

    public HunterCommand(Twist twist) {
        super("hunter");
        withPermission("twist.command.hunter");
        withShortDescription("Set a player to be a hunter");
        withArguments(new PlayerArgument("players"));
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
                .content(Twist.PREFIX + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " is now a hunter")
                .asComponent();
        Bukkit.broadcast(text);

        this.playerManager.setType(player, PlayerType.HUNTER);
    }
}
