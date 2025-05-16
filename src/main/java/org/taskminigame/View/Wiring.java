package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;

public class Wiring {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,119,54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(119);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
        return gui;
    }

    public static void State2(GUI gui){
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(120);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
    }
}
