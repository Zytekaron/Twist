package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.BreakEventHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreakEvent implements Listener {
    private final Map<Material, BreakEventHandler> handlers;
    private final List<BreakEventHandler> allHandlers;
    
    public BreakEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public BreakEventHandler create() {
        var handler = new BreakEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public BreakEventHandler create(Material... materials) {
        var handler = new BreakEventHandler();
        for (var material : materials) {
            this.handlers.put(material, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        var material = event.getBlock().getType();
        
        var handler = this.handlers.get(material);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
