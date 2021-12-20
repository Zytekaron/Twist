package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.InteractEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class InteractEvent implements Listener {
    private final List<InteractEventHandler> allHandlers;
    
    public InteractEvent() {
        this.allHandlers = new ArrayList<>();
    }
    
    public InteractEventHandler create() {
        var handler = new InteractEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        this.allHandlers.forEach(h -> h.run(event));
    }
}
