package com.zytekaron.minecraft.twist.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class Reward {
    private final ItemStack item;
    private final Material material;
    private final int min;
    private final int max;
    
    public Reward(ItemStack item) {
        this(item, null, 0, 0);
    }
    
    public Reward(Material material) {
        this(null, material, 1, 1);
    }
    
    public Reward(Material material, int count) {
        this(null, material, count, count);
    }
    
    private Reward(ItemStack item, Material material, int min, int max) {
        this.item = item;
        this.material = material;
        this.min = min;
        this.max = max;
    }
    
    public ItemStack generate() {
        if (item != null) return item;
        
        var amount = ThreadLocalRandom.current().nextInt(max - min + 1) + min;
        return new ItemStack(material, amount);
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public int getMin() {
        return min;
    }
    
    public int getMax() {
        return max;
    }
}
