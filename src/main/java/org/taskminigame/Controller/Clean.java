/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Model.GUI;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.taskminigame.View.Clean.State1;
import static org.taskminigame.View.Clean.setTrash;

/**
 *
 * @author Admin
 */
public class Clean {
    /*
        destination: 1, 10, 19, 28, 37, 46
        spawnable: 2-8, 11-17, 20-26, 29-35, 47-53
    */
    public static void open(Player player){
        GUI gui = State1(player);
        int[] locList = getRandomLocation(5);
        for (int i : locList){
            setTrash(gui, i);
        }
        player.openInventory(gui.getInventory());     
    }
    
    public static void moveTrash(Inventory inventory, ItemStack itemStack, int loc){
        ItemStack temp = itemStack;
        inventory.remove(itemStack);
        if (loc == 2 || loc == 11 || loc == 20 || loc == 29 || loc == 38 || loc == 47){
            return ;
        }
        inventory.setItem(loc-1,temp);

    }

    public static int[] getRandomLocation(int size){
        // Kiểm tra size hợp lệ
        if (size < 0 || size > 35) {
            throw new IllegalArgumentException("Size must be between 0 and 35");
        }

        // Tạo danh sách tất cả số có thể
        ArrayList<Integer> numbers = new ArrayList<>();
        int[][] ranges = {
                {2, 8}, {11, 17}, {20, 26}, {29, 35}, {47, 53}
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
