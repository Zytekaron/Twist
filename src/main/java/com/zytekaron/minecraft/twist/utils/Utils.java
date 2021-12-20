package com.zytekaron.minecraft.twist.utils;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Utils {
    public static void drop(Location location, ItemStack... items) {
        World world = location.getWorld();
        if (world == null) {
            return;
        }
        for (ItemStack item : items) {
            if (item == null) continue;
            world.dropItemNaturally(location, item);
        }
    }

    public static void applyEffect(Player player, PotionEffectType type, int duration, int amplifier) {
        PotionEffect effect = new PotionEffect(type, duration, amplifier);
        player.addPotionEffect(effect);
    }

    public static ItemStack[] combineStacks(ItemStack[]... stacks) {
        return Stream.of(stacks)
                .flatMap(Stream::of)
                .toArray(ItemStack[]::new);
    }

    public static ItemStack getMainHand(Player player) {
        return player.getInventory().getItemInMainHand();
    }

    public static void setMainHand(Player player, ItemStack item) {
        player.getInventory().setItemInMainHand(item);
    }

    public static ItemStack getOffHand(Player player) {
        return player.getInventory().getItemInOffHand();
    }

    public static void setOffHand(Player player, ItemStack item) {
        player.getInventory().setItemInOffHand(item);
    }

    public static String getName(ItemStack item) {
        var meta = item.getItemMeta();
        if (meta == null) {
            throw new RuntimeException("Invalid item: no meta");
        }

        var text = getTextDisplay(item);
        if (text == null) {
            throw new RuntimeException("Invalid item: no text component");
        }

        return text.content();
    }

    public static ItemStack setName(ItemStack item, String name) {
        var text = getTextDisplay(item);
        if (text != null) {
            text.content(name);
        }

        return item;
    }

    @Nullable
    public static TextComponent getTextDisplay(ItemStack item) {
        var meta = item.getItemMeta();
        if (meta == null) return null;

        return (TextComponent) meta.displayName();
    }

    public static Player getPlayer(Entity entity) {
        if (entity instanceof Player) {
            return (Player) entity;
        }
        return null;
    }

    public static ItemStack createPotion(PotionEffectType effectType, int duration, int amplifier, boolean ambient, boolean particles) {
        return createRawPotion(Material.POTION, effectType, duration * 20, amplifier, ambient, particles);
    }

    public static ItemStack createSplashPotion(PotionEffectType effectType, int duration, int amplifier, boolean ambient, boolean particles) {
        return createRawPotion(Material.SPLASH_POTION, effectType, duration * 20, amplifier, ambient, particles);
    }

    public static ItemStack createLingeringPotion(PotionEffectType effectType, int duration, int amplifier, boolean ambient, boolean particles) {
        return createRawPotion(Material.LINGERING_POTION, effectType, duration * 20, amplifier, ambient, particles);
    }

    public static ItemStack createRawPotion(Material potionType, PotionEffectType effectType, int duration, int amplifier, boolean ambient, boolean particles) {
        ItemStack item = new ItemStack(potionType);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        if (meta == null) {
            throw new RuntimeException("Invalid item type; meta is null");
        }

        var text = getTextDisplay(item);
        if (text != null) {
            text.content(ChatColor.RESET + effectType.getName());
        }

        meta.addCustomEffect(new PotionEffect(effectType, duration, amplifier, ambient, particles), true);
        meta.setColor(effectType.getColor());

        item.setItemMeta(meta);
        return item;
    }
}
