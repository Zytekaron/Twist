package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class InteractEntityEventHandler {
    private final List<Consumer<PlayerInteractEntityEvent>> handlers;
    
    public InteractEntityEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(PlayerInteractEntityEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public InteractEntityEventHandler handle(Consumer<PlayerInteractEntityEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public InteractEntityEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
