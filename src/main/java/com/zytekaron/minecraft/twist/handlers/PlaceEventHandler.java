package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class PlaceEventHandler {
    private final List<Consumer<BlockPlaceEvent>> handlers;
    
    public PlaceEventHandler() {
        this.handlers = new ArrayList<>();
    }
    
    public void run(BlockPlaceEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public PlaceEventHandler handle(Consumer<BlockPlaceEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public PlaceEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
}
