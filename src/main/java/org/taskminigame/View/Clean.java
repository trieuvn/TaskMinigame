/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;

/**
 *
 * @author Admin
 */
public class Clean {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,131,54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(131);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
        return gui;
    }

    public static void setTrash(GUI gui, int loc){
        gui.getInventory().setItem(loc, Trash());
    }

    public static ItemStack Trash(){
        ItemStack trash = new ItemStack(Material.APPLE);
        ItemMeta meta = trash.getItemMeta();
        meta.displayName(Component.text("Trash"));
        trash.setItemMeta(meta);
        return trash;
    }
}
