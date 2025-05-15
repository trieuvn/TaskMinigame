/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Model;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 *
 * @author Admin
 */
public class GUI {
    private Inventory inventory;
    private int state;
    
    public GUI(Player player, InventoryHolder owner, int slot){
        inventory = Bukkit.createInventory(new WiringHolder(player),54);
    }
}
