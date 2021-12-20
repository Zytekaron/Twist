package com.zytekaron.minecraft.twist.utils;

import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public class Materials {
    public static final RecipeChoice.MaterialChoice PLANKS;
    
    static {
        PLANKS = new RecipeChoice.MaterialChoice(
                Material.ACACIA_PLANKS,
                Material.BIRCH_PLANKS,
                Material.CRIMSON_PLANKS,
                Material.DARK_OAK_PLANKS,
                Material.JUNGLE_PLANKS,
                Material.OAK_PLANKS,
                Material.SPRUCE_PLANKS,
                Material.WARPED_PLANKS
        );
    }
}
