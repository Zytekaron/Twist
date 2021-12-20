package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.DamageEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DamageEvent implements Listener {
    private final Map<EntityDamageEvent.DamageCause, DamageEventHandler> handlers;
    private final List<DamageEventHandler> allHandlers;
    
    public DamageEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public DamageEventHandler create() {
        var handler = new DamageEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public DamageEventHandler create(EntityDamageEvent.DamageCause... causes) {
        var handler = new DamageEventHandler();
        for (var cause : causes) {
            this.handlers.put(cause, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void oNDamage(EntityDamageEvent event) {
        var cause = event.getCause();
        
        var handler = this.handlers.get(cause);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
