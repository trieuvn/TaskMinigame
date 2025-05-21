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
public class Garbage {
    //34 35 43 44
    public static GUI State1(Player player){
        GUI gui = new GUI(player,129,54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(129);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
        return gui;
    }

    public static void State2(GUI gui){
        gui.setState(2);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(130);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
    }

    public static void State3(GUI gui){
        if (gui.getState() != 2) return ;
        gui.setState(3);
        gui.success("garbage");
    }

    public static void setTrash(GUI gui, int loc){
        gui.getInventory().setItem(loc, Trash());
    }

    public static ItemStack Trash(){
        ItemStack trash = new ItemStack(Material.FEATHER);
        ItemMeta meta = trash.getItemMeta();
        meta.displayName(Component.text("Trash"));
        trash.setItemMeta(meta);
        return trash;
    }
}
