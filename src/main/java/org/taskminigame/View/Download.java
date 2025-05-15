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
import org.taskminigame.Model.WiringHolder;

/**
 *
 * @author Admin
 */
public class Download {
    public static Inventory State1(Player player){
        Inventory gui = Bukkit.createInventory(new WiringHolder(player),54);
        ItemStack res = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = res.getItemMeta();
        meta.displayName(Component.text(""));
        meta.setCustomModelData(121);
        res.setItemMeta(meta);
        gui.setItem(0,res);
        return gui;
    }
}
