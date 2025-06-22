/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.taskminigame.Model.GUI;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.taskminigame.View.Download.addElement;
import static org.taskminigame.View.Garbage.*;

/**
 *
 * @author Admin
 */
public class Garbage {
    public static void open(Player player){
        GUI gui = State1(player);
        int[] locList = getRandomLocation(7);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : locList){
            setTrash(gui, i);
            arrayList.add(i);
        }
        gui.setItemLocations(arrayList);
        gui.setAmount(7);
        
        player.openInventory(gui.getInventory());
    }

    public static void startCleaning(GUI gui){
        Player player = gui.getPlayer();
        player.playSound(player.getLocation(), "minecraft:garbage_start", SoundCategory.MASTER, 1.0f, 1.0f);
        State2(gui);
        Inventory inventory = gui.getInventory();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!gui.getPlayer().getOpenInventory().getTopInventory().equals(inventory)) {
                    cancel(); // Cancel task if inventory is closed
                    return;
                }
                boolean res = moveTrash(gui);
                if (res){
                    gui.success("garbage");
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(gui.getClass()), 10L, 10L);
    }

    public static boolean moveTrash(GUI gui) {
        //empty = true
        Inventory inventory = gui.getInventory();
        ArrayList<Integer> locList = gui.getItemLocations();
        ArrayList<Integer> newLocList = new ArrayList<>();

        for (Integer itemLoc : locList){
            inventory.setItem(itemLoc,null);
            itemLoc+=9;
            if (itemLoc > 53) continue;
            newLocList.add(itemLoc);
            inventory.setItem(itemLoc,Trash());
        }
        gui.setItemLocations(newLocList);
        if (newLocList.isEmpty())   return true;
        return false;
    }

    public static int[] getRandomLocation(int size){
        // Kiểm tra size hợp lệ
        if (size < 0 || size > 35) {
            throw new IllegalArgumentException("Size must be between 0 and 35");
        }

        // Tạo danh sách tất cả số có thể
        ArrayList<Integer> numbers = new ArrayList<>();
        int[][] ranges = {
                {1, 5}, {9, 14}, {18, 23}, {27, 32}, {36, 42}, {45, 51}
        };
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                numbers.add(i);
            }
        }

        // Chọn size số ngẫu nhiên không trùng nhau
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            // Chọn một chỉ số ngẫu nhiên từ danh sách
            int randomIndex = ThreadLocalRandom.current().nextInt(numbers.size());
            // Lấy số tại chỉ số đó và gán vào kết quả
            result[i] = numbers.remove(randomIndex); // Xóa để tránh trùng
        }

        return result;
    }
}
