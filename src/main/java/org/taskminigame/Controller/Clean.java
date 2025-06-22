/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Model.GUI;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.taskminigame.View.Clean.*;

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
        gui.setAmount(5);
        for (int i : locList){
            setTrash(gui, i);
        }
        player.openInventory(gui.getInventory());     
    }

    public static void moveTrash(GUI gui, ItemStack item, int loc) {
        Inventory inventory = gui.getInventory();
        Player player = gui.getPlayer();
        player.playSound(player.getLocation(), "minecraft:block.azalea_leaves.hit", SoundCategory.MASTER, 1.0f, 1.0f);
        // Kiểm tra item và vị trí hợp lệ
        if (item == null || item.getType() == Material.AIR || loc < 0 || loc >= inventory.getSize()) {
            return;
        }

        // Kiểm tra vị trí đặc biệt (1, 10, 19, 28, 37, 46)
        if (loc == 1 || loc == 10 || loc == 19 || loc == 28 || loc == 37 || loc == 46) {
            if (item.getAmount() > 1) {
                // Giảm stack đi 1
                item.setAmount(item.getAmount() - 1);
                inventory.setItem(loc, item);
            } else {
                // Nếu stack = 1, xóa item
                inventory.setItem(loc, new ItemStack(Material.AIR));
            }
            gui.setAmount(gui.getAmount()-1);
            if (gui.getAmount() == 0){
                State2(gui);
            }
            return;
        }

        // Lấy ô bên trái
        ItemStack leftItem = inventory.getItem(loc - 1);

        if (item.getAmount() > 1) {
            // Nếu stack > 1, tách 1 item
            ItemStack singleItem = new ItemStack(item.getType(), 1);
            // Giảm stack hiện tại đi 1
            item.setAmount(item.getAmount() - 1);
            inventory.setItem(loc, item);

            if (leftItem != null && leftItem.getType() == item.getType() && leftItem.getAmount() < leftItem.getMaxStackSize()) {
                // Nếu ô bên trái có item cùng loại và chưa đầy stack, cộng thêm 1
                leftItem.setAmount(leftItem.getAmount() + 1);
                inventory.setItem(loc - 1, leftItem);
            } else if (leftItem == null || leftItem.getType() == Material.AIR) {
                // Nếu ô bên trái trống, đặt item tách ra vào đó
                inventory.setItem(loc - 1, singleItem);
            }
        } else {
            // Nếu stack = 1, di chuyển toàn bộ item sang trái
            if (leftItem != null && leftItem.getType() == item.getType() && leftItem.getAmount() < leftItem.getMaxStackSize()) {
                // Nếu ô bên trái có item cùng loại và chưa đầy stack, cộng thêm 1
                leftItem.setAmount(leftItem.getAmount() + 1);
                inventory.setItem(loc - 1, leftItem);
                inventory.setItem(loc, new ItemStack(Material.AIR));
            } else if (leftItem == null || leftItem.getType() == Material.AIR) {
                // Nếu ô bên trái trống, di chuyển item sang đó
                inventory.setItem(loc - 1, item);
                inventory.setItem(loc, new ItemStack(Material.AIR));
            }
        }
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
