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
public class Refuel {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,132,54,"ꑛ");
        return gui;
    }
}
