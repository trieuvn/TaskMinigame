/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
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
        for (int i=0;i<6;i++){
            setTrash(gui, getRandomLocation());
        }
        player.openInventory(gui.getInventory());
        gui.getInventory().isEmpty()
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
