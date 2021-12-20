package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.ConsumeEventHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumeEvent implements Listener {
    private final Map<Material, ConsumeEventHandler> handlers;
    private final List<ConsumeEventHandler> allHandlers;
    
    public ConsumeEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public ConsumeEventHandler create() {
        var handler = new ConsumeEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public ConsumeEventHandler create(Material... materials) {
        var handler = new ConsumeEventHandler();
        for (var material : materials) {
            this.handlers.put(material, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        var item = event.getItem();
        var material = item.getType();
        
        var handler = this.handlers.get(material);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
