package com.zytekaron.minecraft.twist.events;

import com.zytekaron.minecraft.twist.handlers.DropEventHandler;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropEvent implements Listener {
    private final Map<Material, DropEventHandler> handlers;
    private final List<DropEventHandler> allHandlers;
    
    public DropEvent() {
        this.handlers = new HashMap<>();
        this.allHandlers = new ArrayList<>();
    }
    
    public DropEventHandler create() {
        var handler = new DropEventHandler();
        this.allHandlers.add(handler);
        return handler;
    }
    
    public DropEventHandler create(Material... materials) {
        var handler = new DropEventHandler();
        for (var material : materials) {
            this.handlers.put(material, handler);
        }
        return handler;
    }
    
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        var item = event.getItemDrop();
        var stack = item.getItemStack();
        var material = stack.getType();
        
        var handler = this.handlers.get(material);
        if (handler != null) {
            handler.run(event);
        }
        this.allHandlers.forEach(h -> h.run(event));
    }
}
