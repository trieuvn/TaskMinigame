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

import org.bukkit.SoundCategory;
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
    public static int[] btnMap = new int[45];
    //9-12, 13-16
    public static void open(Player player){
        /*
        state = -1: khong cho tuong tac
        amount = 1, 2, 3, 4 so luong player doan duoc
        */
        GUI gui = State1(player);
        gui.setState(-1);
        Inventory inventory = gui.getInventory();
        //Khởi tạo 4 cham trang
        for (int i=9;i<13;i++){
            inventory.setItem(i, getNoLight());
        }
        for (int i=14;i<18;i++){
            inventory.setItem(i, getNoLight());
        }
        ArrayList<Integer> pointList = new ArrayList<Integer>();
        for (int i=0;i<4;i++){
            pointList.add(getRandomNumber());
        }
        gui.setItemLocations(pointList);
        gui.setPlayerScore(0);
        
        player.openInventory(gui.getInventory());

        showNewPoint(gui);
    }
    
    public static void showNewPoint(GUI gui){
        /*
        state = -1: không cho tương tác
        amount = 1, 2, 3, 4 số lượng player đoán được
        */
        Integer amount = gui.getAmount();
        Inventory inventory = gui.getInventory();
        ArrayList<Integer> pointList = gui.getItemLocations();
        Player player = gui.getPlayer();

        // Đặt state thành -1 để khóa tương tác
        gui.setState(-1);

        // Sử dụng BukkitRunnable để tạo hiệu ứng delay
        new BukkitRunnable() {
            int index = 0;

            @Override
            public void run() {
                if (index < amount) {
                    inventory.setItem(pointList.get(index), getBlueDot());
                    player.playSound(player.getLocation(), "minecraft:reactor_click", SoundCategory.MASTER, 1.0f, 1.0f);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            inventory.setItem(pointList.get(index), new ItemStack(Material.AIR));
                            index++;
                        }
                    }.runTaskLater(JavaPlugin.getProvidingPlugin(gui.getClass()), 10);


                } else {
                    gui.setState(0);
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(gui.getClass()), 0L, 15L); // Chạy mỗi 0.75 giây (0.5s show + 0.25s nghỉ)
    }
    
    public static void onClick(GUI gui, int clickedLoc){
        if (gui.getState() == -1) return ;
        int loc = btnMap[clickedLoc];
        Player player = gui.getPlayer();
        player.playSound(player.getLocation(), "minecraft:reactor_click", SoundCategory.MASTER, 1.0f, 1.0f);
        Inventory inventory = gui.getInventory();
        inventory.setItem(clickedLoc, getClickedDot());
        new BukkitRunnable() {
            @Override
            public void run() {
                inventory.setItem(clickedLoc, new ItemStack(Material.AIR));
            }
        }.runTaskLater(JavaPlugin.getProvidingPlugin(gui.getClass()), 10);
        gui.setState(-1);
        Integer amount = gui.getAmount();
        //Inventory inventory = gui.getInventory();
        ArrayList<Integer> pointList = gui.getItemLocations();
        int score = gui.getPlayerScore();
        //Player chon sai
        if (pointList.get(score) != loc){
            gui.setPlayerScore(0);
            gui.setAmount(1);
            pointList = new ArrayList<Integer>();
            for (int i=0;i<4;i++){
                pointList.add(getRandomNumber());
            }
            gui.setItemLocations(pointList);
            //Khởi tạo lai 4 cham trang
            for (int i=9;i<13;i++){
                inventory.setItem(i, getNoLight());
            }
            for (int i=14;i<18;i++){
                inventory.setItem(i, getNoLight());
            }
            showNewPoint(gui);
            return;
        //Player chon dung
        }else{
            score++;
            inventory.setItem(score+13, getGreenLight());
            //Dung 1 dot
            if (score == amount){
                //Dung toan bo chu ky
                if (amount == 4){
                    gui.setState(-1);
                    inventory.setItem(12, getGreenLight());
                    gui.success("reactor");
                    return ;
                }
                //Hoan thanh 1 chu ky
                gui.setAmount(amount+1);
                gui.setPlayerScore(0);
                for (int i=14;i<18;i++){
                    inventory.setItem(i, getNoLight());
                }
                inventory.setItem(amount+8, getGreenLight());
                showNewPoint(gui);
            //Dung binh thuong
            }else{
                gui.setPlayerScore(score);
                gui.setState(0);
            }
        }
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

    public static void createBtnMap(){
        btnMap[24] = 19;
        btnMap[25] = 20;
        btnMap[26] = 21;
        btnMap[33] = 28;
        btnMap[34] = 29;
        btnMap[35] = 30;
        btnMap[42] = 37;
        btnMap[43] = 38;
        btnMap[44] = 39;
    }
}
