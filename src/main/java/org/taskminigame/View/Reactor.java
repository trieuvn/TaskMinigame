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
public class Reactor {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,125,54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(125);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
        return gui;
    }
    
    public static ItemStack getBlueDot(){
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(126);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack getNoLight(){
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(127);
        item.setItemMeta(meta);
        return item;
    }
    
    public static ItemStack getGreenLight(){
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(128);
        item.setItemMeta(meta);
        return item;
    }
}
