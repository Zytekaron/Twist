package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.PlaceEventHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceEvent implements Listener {
    private final Map<Material, PlaceEventHandler> handlers;
    private final List<PlaceEventHandler> allHandlers;
    
    public PlaceEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public PlaceEventHandler create() {
        var handler = new PlaceEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public PlaceEventHandler create(Material... materials) {
        var handler = new PlaceEventHandler();
        for (var material : materials) {
            this.handlers.put(material, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        var material = event.getBlockPlaced().getType();
        
        var handler = this.handlers.get(material);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
