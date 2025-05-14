package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.WiringHolder;

public class Wiring {
    public static Inventory State1(Player player){
        Inventory gui = Bukkit.createInventory(new WiringHolder(player),54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(119);
        res.setItemMeta(meta);
        gui.setItem(0,res);
        return gui;
    }

    public static void State2(Inventory gui){
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(120);
        res.setItemMeta(meta);
        gui.setItem(0,res);
    }
}
