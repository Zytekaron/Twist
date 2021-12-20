package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.SneakEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;
import java.util.List;

public class SneakEvent implements Listener {
    private final List<SneakEventHandler> handlers;
    
    public SneakEvent() {
        this.handlers = new ArrayList<>();
    }
    
    public SneakEventHandler create() {
        var handler = new SneakEventHandler();
        this.handlers.add(handler);
        return handler;
    }
    
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        this.handlers.forEach(h -> h.run(event));
    }
}
