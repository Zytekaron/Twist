package com.zytekaron.minecraft.twist.handlers;

import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;
import java.util.function.Consumer;

public class SneakEventHandler {
    private final List<Consumer<PlayerToggleSneakEvent>> handlers;
    private final Random random;
    
    public SneakEventHandler() {
        this.handlers = new ArrayList<>();
        this.random = new Random();
    }
    
    public void run(PlayerToggleSneakEvent event) {
        this.handlers.stream()
                .filter(Objects::nonNull)
                .forEach(c -> c.accept(event));
    }
    
    public SneakEventHandler handle(Consumer<PlayerToggleSneakEvent> handler) {
        this.handlers.add(handler);
        return this;
    }
    
    public SneakEventHandler handle(boolean sneaking, Consumer<PlayerToggleSneakEvent> handler) {
        this.handlers.add(event -> {
            if (event.isSneaking() == sneaking) {
                handler.accept(event);
            }
        });
        return this;
    }
    
    public SneakEventHandler applyEffects(boolean sneaking, PotionEffect... effects) {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            if (event.isSneaking() != sneaking) {
                return;
            }
            for (var effect : effects) {
                player.addPotionEffect(effect);
            }
        });
        return this;
    }
    
    public SneakEventHandler applyRandomEffect(boolean sneaking, PotionEffect... effects) {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            if (event.isSneaking() != sneaking) {
                return;
            }
            var i = this.random.nextInt(effects.length);
            player.addPotionEffect(effects[i]);
        });
        return this;
    }
    
    public SneakEventHandler removeEffects(boolean sneaking, PotionEffectType... effects) {
        this.handlers.add(event -> {
            var player = event.getPlayer();
            if (event.isSneaking() != sneaking) {
                return;
            }
            for (var effect : effects) {
                player.removePotionEffect(effect);
            }
        });
        return this;
    }
    
    public SneakEventHandler removeEffects(boolean sneaking, PotionEffect... effects) {
        PotionEffectType[] types = Arrays.stream(effects)
                .map(PotionEffect::getType)
                .toArray(PotionEffectType[]::new);
        this.removeEffects(sneaking, types);
        return this;
    }
}
