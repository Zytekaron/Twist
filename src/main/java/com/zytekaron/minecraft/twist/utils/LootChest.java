package com.zytekaron.minecraft.twist.utils;

import com.zytekaron.minecraft.twist.events.BreakEvent;
import com.zytekaron.minecraft.twist.events.PlaceEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LootChest {
    private final Random random;
    private final String name;
    private final List<Reward> rewards;
    
    public LootChest(String name, List<Reward> rewards) {
        this.random = ThreadLocalRandom.current();
        this.name = ChatColor.RESET + name;
        this.rewards = rewards;
    }
    
    public LootChest(String name, Reward... rewards) {
        this(name, new ArrayList<>(Arrays.asList(rewards)));
    }
    
    public ItemStack getItem() {
        var item = new ItemStack(Material.CHEST);
        return Utils.setName(item, this.name);
    }
    
    public ItemStack[] generate() {
        Collections.shuffle(this.rewards);
        var amount = this.random.nextInt(this.rewards.size()) + 1;
        var items = new ItemStack[amount];
        for (int i = 0; i < amount; i++) {
            items[i] = this.rewards.get(i).generate();
        }
        return items;
    }
    
    public void useHandlers(PlaceEvent placeEvent, BreakEvent breakEvent) {
        placeEvent.create()
                .handle(event -> {
                    if (event.getBlock().getType() != Material.CHEST) return;
                    
                    Chest chest = (Chest) event.getBlockPlaced().getState();
                    if (getName().equals(chest.getCustomName())) {
                        chest.getBlockInventory().addItem(generate());
                    }
                });
    
        breakEvent.create()
                .cancel()
                .damage()
                .handle(event -> {
                    if (event.getBlock().getType() != Material.CHEST) return;
                    
                    Location location = event.getBlock().getLocation();
                    Chest chest = (Chest) event.getBlock().getState();
                    if (getName().equals(chest.getCustomName())) {
                        Utils.drop(location, chest.getInventory().getContents());
                        Utils.drop(location, new ItemStack(Material.CHEST));
                    }
                })
                .destroy();
    }
    
    public String getName() {
        return this.name;
    }
}
