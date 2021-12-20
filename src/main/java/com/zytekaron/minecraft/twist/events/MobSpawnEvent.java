package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.MobSpawnEventHandler;
import com.zytekaron.minecraft.twist.handlers.SpawnEventHandler;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobSpawnEvent implements Listener {
    private final Map<EntityType, MobSpawnEventHandler> handlers;
    private final List<MobSpawnEventHandler> allHandlers;
    
    public MobSpawnEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public MobSpawnEventHandler create() {
        var handler = new MobSpawnEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public MobSpawnEventHandler create(EntityType... entities) {
        var handler = new MobSpawnEventHandler();
        for (var entity : entities) {
            this.handlers.put(entity, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        var entity = event.getEntityType();
        
        var handler = this.handlers.get(entity);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
