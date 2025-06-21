/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Model.GUI;

import static org.taskminigame.View.Navigation.*;

/**
 *
 * @author Admin
 */
public class Navigation {
    public static void open(Player player){
        GUI gui = State1(player);
        int cursorLoc = getRandomNumber();
        setCursor(gui, cursorLoc);
        
        player.openInventory(gui.getInventory());
    }
    
    public static boolean checkCursor(ItemStack item){
        if (item == null) return false;
        if (item.getItemMeta() == null) return false;
        if (!item.getItemMeta().hasCustomModelData()) return false;
        if (isCursor(item))
            return true;
        return false;
    }
    
    public static void done(GUI gui){
        gui.success("navigation");
    }
    
    /*
        12-14
        20-24
        29-33
        38-42
        48-50
    */
    public static int getRandomNumber() {
        // Định nghĩa các khoảng
        int[][] ranges = {
            {12, 14},
            {20, 24},
            {29, 30},{32, 33},
            {38, 42},
            {48, 50}
        };
        
        // Chọn ngẫu nhiên một khoảng
        int[] selectedRange = ranges[ThreadLocalRandom.current().nextInt(ranges.length)];
        int min = selectedRange[0];
        int max = selectedRange[1];
        
        // Sinh số ngẫu nhiên trong khoảng [min, max]
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
