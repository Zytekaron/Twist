package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ConsumeEventHandler {
    private final List<Consumer<PlayerItemConsumeEvent>> handlers;
    
    public ConsumeEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(PlayerItemConsumeEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public ConsumeEventHandler handle(Consumer<PlayerItemConsumeEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public ConsumeEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
