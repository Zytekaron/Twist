package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DamageEventHandler {
    private final List<Consumer<EntityDamageEvent>> handlers;
    
    public DamageEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(EntityDamageEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public DamageEventHandler handle(Consumer<EntityDamageEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public DamageEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
