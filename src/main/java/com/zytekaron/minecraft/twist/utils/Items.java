package com.zytekaron.minecraft.twist.utils;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Items {
    public static final ItemStack AIR = new ItemStack(Material.AIR);
    
    public static final ItemStack LOG = new ItemStack(Material.OAK_LOG);
    public static final ItemStack GAPPLE = new ItemStack(Material.GOLDEN_APPLE);
    public static final ItemStack EGAPPLE = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
    public static final ItemStack STEAK = new ItemStack(Material.COOKED_BEEF);
    public static final ItemStack PORKCHOP = new ItemStack(Material.COOKED_PORKCHOP);
    public static final ItemStack BOOK = new ItemStack(Material.BOOK);
    public static final ItemStack OBSIDIAN = new ItemStack(Material.OBSIDIAN);
    public static final ItemStack ELYTRA = new ItemStack(Material.ELYTRA);
    public static final ItemStack BLAZE_ROD = new ItemStack(Material.BLAZE_ROD);
    public static final ItemStack BLAZE_POWDER = new ItemStack(Material.BLAZE_POWDER);
    public static final ItemStack ENDERPEARL = new ItemStack(Material.ENDER_PEARL);
    public static final ItemStack EYE_OF_ENDER = new ItemStack(Material.ENDER_EYE);
    
    public static final ItemStack COAL = new ItemStack(Material.COAL);
    public static final ItemStack IRON = new ItemStack(Material.IRON_INGOT);
    public static final ItemStack GOLD = new ItemStack(Material.GOLD_INGOT);
    public static final ItemStack LAPIS = new ItemStack(Material.LAPIS_LAZULI);
    public static final ItemStack REDSTONE = new ItemStack(Material.REDSTONE);
    public static final ItemStack EMERALD = new ItemStack(Material.EMERALD);
    public static final ItemStack DIAMOND = new ItemStack(Material.DIAMOND);
    public static final ItemStack NETHERITE = new ItemStack(Material.NETHERITE_INGOT);
    
    public static final ItemStack COAL_BLOCK = new ItemStack(Material.COAL_BLOCK);
    public static final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
    public static final ItemStack GOLD_BLOCK = new ItemStack(Material.GOLD_BLOCK);
    public static final ItemStack LAPIS_BLOCK = new ItemStack(Material.LAPIS_BLOCK);
    public static final ItemStack REDSTONE_BLOCK = new ItemStack(Material.REDSTONE_BLOCK);
    public static final ItemStack EMERALD_BLOCK = new ItemStack(Material.EMERALD_BLOCK);
    public static final ItemStack DIAMOND_BLOCK = new ItemStack(Material.DIAMOND_BLOCK);
    public static final ItemStack NETHERITE_BLOCK = new ItemStack(Material.NETHERITE_BLOCK);
    
    public static final ItemStack STONE_PICKAXE = new ItemStack(Material.STONE_PICKAXE);
    public static final ItemStack STONE_AXE = new ItemStack(Material.STONE_AXE);
    public static final ItemStack STONE_SHOVEL = new ItemStack(Material.STONE_SHOVEL);
    public static final ItemStack STONE_HOE = new ItemStack(Material.STONE_HOE);
    public static final ItemStack[] STONE_TOOLS = { Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE };
    
    public static final ItemStack IRON_HELMET = new ItemStack(Material.IRON_HELMET);
    public static final ItemStack IRON_CHEST = new ItemStack(Material.IRON_CHESTPLATE);
    public static final ItemStack IRON_LEGS = new ItemStack(Material.IRON_LEGGINGS);
    public static final ItemStack IRON_BOOTS = new ItemStack(Material.IRON_BOOTS);
    public static final ItemStack[] IRON_ARMOR = { Items.IRON_HELMET, Items.IRON_CHEST, Items.IRON_LEGS, Items.IRON_BOOTS };
    
    public static final ItemStack IRON_PICKAXE = new ItemStack(Material.IRON_PICKAXE);
    public static final ItemStack IRON_AXE = new ItemStack(Material.IRON_AXE);
    public static final ItemStack IRON_SHOVEL = new ItemStack(Material.IRON_SHOVEL);
    public static final ItemStack IRON_HOE = new ItemStack(Material.IRON_HOE);
    public static final ItemStack[] IRON_TOOLS = { Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE };
    
    public static final ItemStack GOLD_HELMET = new ItemStack(Material.GOLDEN_HELMET);
    public static final ItemStack GOLD_CHEST = new ItemStack(Material.GOLDEN_CHESTPLATE);
    public static final ItemStack GOLD_LEGS = new ItemStack(Material.GOLDEN_LEGGINGS);
    public static final ItemStack GOLD_BOOTS = new ItemStack(Material.GOLDEN_BOOTS);
    public static final ItemStack[] GOLD_ARMOR = { Items.GOLD_HELMET, Items.GOLD_CHEST, Items.GOLD_LEGS, Items.GOLD_BOOTS };
    
    public static final ItemStack GOLD_PICKAXE = new ItemStack(Material.GOLDEN_PICKAXE);
    public static final ItemStack GOLD_AXE = new ItemStack(Material.GOLDEN_AXE);
    public static final ItemStack GOLD_SHOVEL = new ItemStack(Material.GOLDEN_SHOVEL);
    public static final ItemStack GOLD_HOE = new ItemStack(Material.GOLDEN_HOE);
    public static final ItemStack[] GOLD_TOOLS = { Items.GOLD_PICKAXE, Items.GOLD_AXE, Items.GOLD_SHOVEL, Items.GOLD_HOE };
    
    public static final ItemStack DIAMOND_HELMET = new ItemStack(Material.DIAMOND_HELMET);
    public static final ItemStack DIAMOND_CHEST = new ItemStack(Material.DIAMOND_CHESTPLATE);
    public static final ItemStack DIAMOND_LEGS = new ItemStack(Material.DIAMOND_LEGGINGS);
    public static final ItemStack DIAMOND_BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
    public static final ItemStack[] DIAMOND_ARMOR = { Items.DIAMOND_HELMET, Items.DIAMOND_CHEST, Items.DIAMOND_LEGS, Items.DIAMOND_BOOTS };
    
    public static final ItemStack DIAMOND_PICKAXE = new ItemStack(Material.DIAMOND_PICKAXE);
    public static final ItemStack DIAMOND_AXE = new ItemStack(Material.DIAMOND_AXE);
    public static final ItemStack DIAMOND_SHOVEL = new ItemStack(Material.DIAMOND_SHOVEL);
    public static final ItemStack DIAMOND_HOE = new ItemStack(Material.DIAMOND_HOE);
    public static final ItemStack[] DIAMOND_TOOLS = { Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE };
    
    public static final ItemStack NETHERITE_HELMET = new ItemStack(Material.NETHERITE_HELMET);
    public static final ItemStack NETHERITE_CHEST = new ItemStack(Material.NETHERITE_CHESTPLATE);
    public static final ItemStack NETHERITE_LEGS = new ItemStack(Material.NETHERITE_LEGGINGS);
    public static final ItemStack NETHERITE_BOOTS = new ItemStack(Material.NETHERITE_BOOTS);
    public static final ItemStack[] NETHERITE_ARMOR = { Items.NETHERITE_HELMET, Items.NETHERITE_CHEST, Items.NETHERITE_LEGS, Items.NETHERITE_BOOTS };
    
    public static final ItemStack NETHERITE_PICKAXE = new ItemStack(Material.NETHERITE_PICKAXE);
    public static final ItemStack NETHERITE_AXE = new ItemStack(Material.NETHERITE_AXE);
    public static final ItemStack NETHERITE_SHOVEL = new ItemStack(Material.NETHERITE_SHOVEL);
    public static final ItemStack NETHERITE_HOE = new ItemStack(Material.NETHERITE_HOE);
    public static final ItemStack[] NETHERITE_TOOLS = { Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE };
    
    public static final ItemStack OP_SWORD = new ItemStack(Material.NETHERITE_SWORD) {{
        addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
        addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_SWORD = new ItemStack(Material.DIAMOND_SWORD) {{
        addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 3);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_AXE = new ItemStack(Material.NETHERITE_AXE) {{
        addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_AXE = new ItemStack(Material.DIAMOND_AXE) {{
        addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_PICKAXE = new ItemStack(Material.NETHERITE_PICKAXE) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_PICKAXE = new ItemStack(Material.DIAMOND_PICKAXE) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_SHOVEL = new ItemStack(Material.NETHERITE_SHOVEL) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_SHOVEL = new ItemStack(Material.DIAMOND_SHOVEL) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_HOE = new ItemStack(Material.NETHERITE_HOE) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_HOE = new ItemStack(Material.DIAMOND_HOE) {{
        addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);
        addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_HELMET = new ItemStack(Material.NETHERITE_HELMET) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addUnsafeEnchantment(Enchantment.THORNS, 10);
        addUnsafeEnchantment(Enchantment.WATER_WORKER, 10);
        addUnsafeEnchantment(Enchantment.OXYGEN, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_HELMET = new ItemStack(Material.DIAMOND_HELMET) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        addUnsafeEnchantment(Enchantment.OXYGEN, 3);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_CHESTPLATE = new ItemStack(Material.NETHERITE_CHESTPLATE) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addUnsafeEnchantment(Enchantment.THORNS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_CHESTPLATE = new ItemStack(Material.DIAMOND_CHESTPLATE) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    public static final ItemStack OP_LEGGINGS = new ItemStack(Material.NETHERITE_LEGGINGS) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addUnsafeEnchantment(Enchantment.THORNS, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack OP_BOOTS = new ItemStack(Material.NETHERITE_BOOTS) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addUnsafeEnchantment(Enchantment.THORNS, 10);
        addUnsafeEnchantment(Enchantment.SOUL_SPEED, 10);
        addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 10);
        addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
        addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        addUnsafeEnchantment(Enchantment.MENDING, 10);
    }};
    public static final ItemStack COOL_BOOTS = new ItemStack(Material.DIAMOND_BOOTS) {{
        addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        addUnsafeEnchantment(Enchantment.SOUL_SPEED, 3);
        addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 3);
        addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        addUnsafeEnchantment(Enchantment.MENDING, 1);
    }};
    
    public static final ItemStack[] OP_ARMOR = { OP_HELMET, OP_CHESTPLATE, OP_LEGGINGS, OP_BOOTS };
    public static final ItemStack[] OP_TOOLS = { OP_SWORD, OP_AXE, OP_PICKAXE, OP_SHOVEL, OP_HOE };
    public static final ItemStack[] OP_KIT = (ItemStack[]) ArrayUtils.addAll(OP_ARMOR, OP_TOOLS);
    
    public static final ItemStack[] COOL_ARMOR = { COOL_HELMET, COOL_CHESTPLATE, COOL_LEGGINGS, COOL_BOOTS };
    public static final ItemStack[] COOL_TOOLS = { COOL_SWORD, COOL_AXE, COOL_PICKAXE, COOL_SHOVEL, COOL_HOE };
    public static final ItemStack[] COOL_KIT = (ItemStack[]) ArrayUtils.addAll(COOL_ARMOR, COOL_TOOLS);
}
