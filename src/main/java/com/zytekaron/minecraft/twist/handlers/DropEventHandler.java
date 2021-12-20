package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DropEventHandler {
    private final List<Consumer<PlayerDropItemEvent>> handlers;
    
    public DropEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(PlayerDropItemEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public DropEventHandler handle(Consumer<PlayerDropItemEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public DropEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
