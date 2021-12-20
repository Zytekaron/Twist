package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.Twist;
import com.zytekaron.minecraft.twist.managers.PlayerManager;
import com.zytekaron.minecraft.twist.managers.PlayerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TwistOnlyJoinEvent implements Listener {
    private final PlayerManager playerManager;
    
    public TwistOnlyJoinEvent(Twist twist) {
        this.playerManager = twist.getPlayerManager();
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        this.playerManager.setType(player, PlayerType.SPECTATOR);
    }
}
