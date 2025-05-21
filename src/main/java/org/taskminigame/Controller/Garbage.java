/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.Material;
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
        player.openInventory(gui.getInventory());
        int[] locList = getRandomLocation(7);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : locList){
            setTrash(gui, i);
            arrayList.add(i);
        }
        gui.setItemLocations(arrayList);
        gui.setAmount(7);
    }

    public static void startCleaning(GUI gui){
        State2(gui);

        new BukkitRunnable() {
            @Override
            public void run() {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (Integer i : gui.getItemLocations()){
                    moveTrash(gui, Trash(), i);
                    arrayList.add(i+9);
                }
                gui.setItemLocations(arrayList);
                if (gui.getAmount() == 0) {
                    State3(gui);
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(gui.getClass()), 10L, 10L);
    }

    public static void moveTrash(GUI gui, ItemStack item, int loc) {
        Inventory inventory = gui.getInventory();
        // Kiểm tra item và vị trí hợp lệ
        if (item == null || item.getType() == Material.AIR || loc < 0 || loc >= inventory.getSize()) {
            return;
        }

        // Kiểm tra vị trí đặc biệt (1, 10, 19, 28, 37, 46)
        if (loc > 44 && loc < 51) {
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
                State3(gui);
            }
            return;
        }

        // Lấy ô bên duoi
        ItemStack leftItem = inventory.getItem(loc + 9);

        if (item.getAmount() > 1) {
            // Nếu stack > 1, tách 1 item
            ItemStack singleItem = new ItemStack(item.getType(), 1);
            // Giảm stack hiện tại đi 1
            item.setAmount(item.getAmount() - 1);
            inventory.setItem(loc, item);

            if (leftItem != null && leftItem.getType() == item.getType() && leftItem.getAmount() < leftItem.getMaxStackSize()) {
                // Nếu ô bên trái có item cùng loại và chưa đầy stack, cộng thêm 1
                leftItem.setAmount(leftItem.getAmount() + 1);
                inventory.setItem(loc + 9, leftItem);
            } else if (leftItem == null || leftItem.getType() == Material.AIR) {
                // Nếu ô bên trái trống, đặt item tách ra vào đó
                inventory.setItem(loc + 9, singleItem);
            }
        } else {
            // Nếu stack = 1, di chuyển toàn bộ item sang trái
            if (leftItem != null && leftItem.getType() == item.getType() && leftItem.getAmount() < leftItem.getMaxStackSize()) {
                // Nếu ô bên trái có item cùng loại và chưa đầy stack, cộng thêm 1
                leftItem.setAmount(leftItem.getAmount() + 1);
                inventory.setItem(loc + 9, leftItem);
                inventory.setItem(loc, new ItemStack(Material.AIR));
            } else if (leftItem == null || leftItem.getType() == Material.AIR) {
                // Nếu ô bên trái trống, di chuyển item sang đó
                inventory.setItem(loc + 9, item);
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
