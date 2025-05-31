/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Material;
import static org.bukkit.Registry.MATERIAL;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.taskminigame.Model.GUI;

import static org.taskminigame.View.Reactor.*;

/**
 *
 * @author Admin
 */
public class Reactor {
    //9-12, 13-16
    public static void open(Player player){
        GUI gui = State1(player);
        Inventory inventory = gui.getInventory();
        //Khởi tạo 4 cham trang
        for (int i=9;i<13;i++){
            inventory.setItem(i, getNoLight());
        }
        for (int i=13;i<17;i++){
            inventory.setItem(i, getNoLight());
        }
        ArrayList<Integer> pointList = new ArrayList<Integer>();
        for (int i=0;i<4;i++){
            pointList.add(getRandomNumber());
        }
        gui.setItemLocations(pointList);
        
        player.openInventory(gui.getInventory());
    }
    
    public static void showNewPoint(GUI gui, Integer slot){
        Inventory inventory = gui.getInventory();
        inventory.setItem(slot, getBlueDot());
        inventory.setItem(slot, new ItemStack(Material.AIR));
        
    }
    
    public static void onClick(GUI gui, int loc){
        
    }
    
    /*
        19-21
        28-30
        37-39
    */
    public static int getRandomNumber() {
        // Định nghĩa các khoảng
        int[][] ranges = {
            {19, 21},
            {28, 30},
            {37, 39}
        };
        
        // Chọn ngẫu nhiên một khoảng
        int[] selectedRange = ranges[ThreadLocalRandom.current().nextInt(ranges.length)];
        int min = selectedRange[0];
        int max = selectedRange[1];
        
        // Sinh số ngẫu nhiên trong khoảng [min, max]
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
