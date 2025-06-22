/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Admin
 */
public class Clean {
    public static GUI State1(Player player){
        GUI gui = new GUI(player, 131, 54, "ꐽ");
        return gui;
    }

    public static void State2(GUI gui) {
        gui.setState(2);
        gui.success("clean");
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
