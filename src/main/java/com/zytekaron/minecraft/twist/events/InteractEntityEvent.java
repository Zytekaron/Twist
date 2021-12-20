package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.InteractEntityEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class InteractEntityEvent implements Listener {
    private final List<InteractEntityEventHandler> allHandlers;
    
    public InteractEntityEvent() {
        this.allHandlers = new ArrayList<>();
    }
    
    public InteractEntityEventHandler create() {
        var handler = new InteractEntityEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent event) {
        this.allHandlers.forEach(h -> h.run(event));
    }
}
