package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class MobSpawnEventHandler {
    private final List<Consumer<CreatureSpawnEvent>> handlers;
    
    public MobSpawnEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(CreatureSpawnEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public MobSpawnEventHandler handle(Consumer<CreatureSpawnEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public MobSpawnEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
