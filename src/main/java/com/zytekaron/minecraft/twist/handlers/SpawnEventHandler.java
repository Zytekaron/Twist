package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class SpawnEventHandler {
    private final List<Consumer<EntitySpawnEvent>> handlers;
    
    public SpawnEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(EntitySpawnEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public SpawnEventHandler handle(Consumer<EntitySpawnEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public SpawnEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
