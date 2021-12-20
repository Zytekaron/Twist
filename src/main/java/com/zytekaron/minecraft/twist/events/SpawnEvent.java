package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.SpawnEventHandler;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpawnEvent implements Listener {
    private final Map<EntityType, SpawnEventHandler> handlers;
    private final List<SpawnEventHandler> allHandlers;
    
    public SpawnEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public SpawnEventHandler create() {
        var handler = new SpawnEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public SpawnEventHandler create(EntityType... entities) {
        var handler = new SpawnEventHandler();
        for (var entity : entities) {
            this.handlers.put(entity, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        var entity = event.getEntityType();
        
        var handler = this.handlers.get(entity);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
