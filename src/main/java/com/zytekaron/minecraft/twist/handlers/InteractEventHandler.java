package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class InteractEventHandler {
    private final List<Consumer<PlayerInteractEvent>> handlers;
    
    public InteractEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(PlayerInteractEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public InteractEventHandler handle(Consumer<PlayerInteractEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public InteractEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
