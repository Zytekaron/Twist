package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;

public class BreakEventHandler {
    private final List<Consumer<BlockBreakEvent>> handlers;
    private final Random random;
    
    public BreakEventHandler() {
        this.handlers = new ArrayList<>();
        this.random = new Random();
    }
    
    public void run(BlockBreakEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public BreakEventHandler handle(Consumer<BlockBreakEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public BreakEventHandler cancel() {
        this.handlers.add(event -> event.setCancelled(true));
        return this;
    }
    
    public BreakEventHandler destroy() {
        this.handlers.add(event -> event.getBlock().setType(Material.AIR));
        return this;
    }
    
    public BreakEventHandler damage() {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            var inventory = player.getInventory();
            var item = inventory.getItemInMainHand();
            if (!EnchantmentTarget.TOOL.includes(item)) {
                return;
            }
            var meta = item.getItemMeta();
            var damageable = (Damageable) meta;
            if (damageable == null) {
                return;
            }
            damageable.setDamage(damageable.getDamage() + 1);
            item.setItemMeta(meta);
            if (damageable.getDamage() >= item.getType().getMaxDurability()) {
                inventory.clear(inventory.getHeldItemSlot());
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
            }
        });
        return this;
    }
    
    public BreakEventHandler drop(ItemStack... stacks) {
        this.handlers.add(event -> {
            var world = event.getBlock().getWorld();
            var location = event.getBlock().getLocation();
            for (var stack : stacks) {
                world.dropItemNaturally(location, stack);
            }
        });
        return this;
    }
    
    public BreakEventHandler dropRandom(ItemStack... stacks) {
        this.handlers.add(event -> {
            var world = event.getBlock().getWorld();
            var location = event.getBlock().getLocation();
            var i = this.random.nextInt(stacks.length);
            world.dropItemNaturally(location, stacks[i]);
        });
        return this;
    }
    
    public BreakEventHandler dropRandom(ItemStack[]... stacks) {
        ItemStack stack;
        this.handlers.add(event -> {
            var world = event.getBlock().getWorld();
            var location = event.getBlock().getLocation();
            var i = this.random.nextInt(stacks.length);
            var array = stacks[i];
            for (var item : array) {
                world.dropItemNaturally(location, item);
            }
        });
        return this;
    }
    
    public BreakEventHandler applyEffects(PotionEffect... effects) {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            for (var effect : effects) {
                player.addPotionEffect(effect);
            }
        });
        return this;
    }
    
    public BreakEventHandler applyRandomEffect(PotionEffect... effects) {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            var i = this.random.nextInt(effects.length);
            player.addPotionEffect(effects[i]);
        });
        return this;
    }
}
