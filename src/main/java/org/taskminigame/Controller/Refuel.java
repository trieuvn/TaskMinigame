/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.entity.Player;
import org.taskminigame.Model.GUI;
import org.taskminigame.View.Clean;


/**
 *
 * @author Admin
 */
public class Refuel {
    public static void open(Player player){
        GUI gui = Clean.State1(player);
        player.openInventory(gui.getInventory());
    }
}
