/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.taskminigame.Model.GUI;

import static org.taskminigame.View.Clean.State1;

/**
 *
 * @author Admin
 */
public class Clean {
    public static void open(Player player){
        GUI gui = State1(player);
        player.openInventory(gui.getInventory());
    }
}
