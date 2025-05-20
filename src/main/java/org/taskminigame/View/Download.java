/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;

/**
 *
 * @author Admin
 */
public class Download {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,121,54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(121);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
        gui.setAmount(0);
        return gui;
    }

    public static void State2(GUI gui){
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(122);
        res.setItemMeta(meta);
        gui.getInventory().setItem(0,res);
    }

    public static void addElement(GUI gui){
        if (gui.getAmount() > 6){
            gui.success();
        }
        //37 38 39 40 41 42 43
        Inventory inventory = gui.getInventory();
        //e1: start, end
        ItemStack e1 = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta e1meta = e1.getItemMeta();
        e1meta.displayName(Component.text(""));
        e1meta.setCustomModelData(123);
        e1.setItemMeta(e1meta);
        //e2: start, end
        ItemStack e2 = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta e2meta = e1.getItemMeta();
        e2meta.displayName(Component.text(""));
        e2meta.setCustomModelData(124);
        e2.setItemMeta(e2meta);

        if (gui.getAmount() == 0){
            inventory.setItem(37,e1);
        }
        if (gui.getAmount() == 1){
            inventory.setItem(38,e2);
        }
        if (gui.getAmount() == 2){
            inventory.setItem(39,e2);
        }
        if (gui.getAmount() == 3){
            inventory.setItem(40,e2);
        }
        if (gui.getAmount() == 4){
            inventory.setItem(41,e2);
        }
        if (gui.getAmount() == 5){
            inventory.setItem(42,e2);
        }
        if (gui.getAmount() == 6){
            inventory.setItem(43,e1);
        }

        gui.setAmount(gui.getAmount()+1);
    }
}
