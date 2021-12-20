package com.zytekaron.minecraft.twist;

import com.zytekaron.minecraft.twist.commands.*;
import com.zytekaron.minecraft.twist.events.TwistOnlyJoinEvent;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Twist extends JavaPlugin {

    private void createHandlers() {
        // Create a twist here!
    }

    //////////////////////////////////////////
    /// Don't modify anything below here   ///
    /// unless you know what you're doing. ///
    //////////////////////////////////////////

    public static final String PREFIX = "§7[§6Twist§7] §e";
    private final PlayerManager playerManager;

    public Twist() {
        this.playerManager = new PlayerManager();
    }

    @Override
    public void onLoad() {
        var config = new CommandAPIConfig()
                .useLatestNMSVersion(true)
                .verboseOutput(false)
                .silentLogs(false);
        CommandAPI.onLoad(config);

        new ClearCommand(this);
        new HunterCommand(this);
        new HunterChatCommand(this);
        new ListCommand(this);
        new RemoveCommand(this);
        new RunnerCommand(this);
        new RunnerChatCommand(this);
        new SpectatorChatCommand(this);
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);

        this.registerEvents(new TwistOnlyJoinEvent(this));
        this.createHandlers();
    }

    @Override
    public void onDisable() {
    }

    private void registerEvents(Listener... listeners) {
        final PluginManager manager = this.getServer().getPluginManager();
        for (var listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }

    public PlayerManager getPlayerManager() {
        return this.playerManager;
    }
}
