package com.sqldata.testplugin.glass;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.sqldata.testplugin.Main;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import java.util.*;

public class GlassHandler implements Listener {
    public GlassHandler(Main plugin)  {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onBlockBreak(BlockDamageEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        Material[] glassMap = {
                Material.GLASS
                ,Material.WHITE_STAINED_GLASS
                ,Material.ORANGE_STAINED_GLASS
                ,Material.MAGENTA_STAINED_GLASS
                ,Material.LIGHT_BLUE_STAINED_GLASS
                ,Material.YELLOW_STAINED_GLASS
                ,Material.LIME_STAINED_GLASS
                ,Material.PINK_STAINED_GLASS
                ,Material.GRAY_STAINED_GLASS
                ,Material.LIGHT_GRAY_STAINED_GLASS
                ,Material.CYAN_STAINED_GLASS
                ,Material.PURPLE_STAINED_GLASS
                ,Material.BLUE_STAINED_GLASS
                ,Material.BROWN_STAINED_GLASS
                ,Material.GREEN_STAINED_GLASS
                ,Material.RED_STAINED_GLASS
                ,Material.BLACK_STAINED_GLASS
                ,Material.GLASS_PANE
                ,Material.WHITE_STAINED_GLASS_PANE
                ,Material.ORANGE_STAINED_GLASS_PANE
                ,Material.MAGENTA_STAINED_GLASS_PANE
                ,Material.LIGHT_BLUE_STAINED_GLASS_PANE
                ,Material.YELLOW_STAINED_GLASS_PANE
                ,Material.LIME_STAINED_GLASS_PANE
                ,Material.PINK_STAINED_GLASS_PANE
                ,Material.GRAY_STAINED_GLASS_PANE
                ,Material.LIGHT_GRAY_STAINED_GLASS_PANE
                ,Material.CYAN_STAINED_GLASS_PANE
                ,Material.PURPLE_STAINED_GLASS_PANE
                ,Material.BLUE_STAINED_GLASS_PANE
                ,Material.BROWN_STAINED_GLASS_PANE
                ,Material.GREEN_STAINED_GLASS_PANE
                ,Material.RED_STAINED_GLASS_PANE
                ,Material.BLACK_STAINED_GLASS_PANE
        };

        if (!Arrays.asList(glassMap).contains(block.getType())) {
            return;
        }
        ItemStack Pickaxes = player.getInventory().getItemInMainHand();

        Bukkit.getLogger().info(String.valueOf(Pickaxes.getType()));
        if (Pickaxes.getType() == Material.NETHERITE_PICKAXE) {
            if (Pickaxes.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS) && Pickaxes.getItemMeta().hasEnchant(Enchantment.DIG_SPEED)) {
                Bukkit.getLogger().info(String.valueOf(Pickaxes.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)));
                Bukkit.getLogger().info(String.valueOf(Pickaxes.getEnchantmentLevel(Enchantment.DIG_SPEED)));
                if (String.valueOf(Pickaxes.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)).equals("3")) {
                    if (String.valueOf(Pickaxes.getEnchantmentLevel(Enchantment.DIG_SPEED)).equals("5")) {
                        event.setInstaBreak(true);
                    }
                }
            }
        }
    }
}
