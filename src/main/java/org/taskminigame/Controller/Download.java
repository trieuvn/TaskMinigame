/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Controller;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.taskminigame.Model.GUI;

import static org.taskminigame.View.Download.*;

/**
 *
 * @author Admin
 */
public class Download {
    public static void open(Player player){
        GUI gui = State1(player);
        player.openInventory(gui.getInventory());
    }

    public static void startDownload(GUI gui) {
        // Gọi State2 ngay lập tức
        State2(gui);

        // Tạo biến đếm số lần lặp
        final int[] counter = {0};
        final int maxRuns = 8;

        // Tạo BukkitRunnable để lặp addElement 5 lần
        new BukkitRunnable() {
            @Override
            public void run() {
                // Gọi addElement
                addElement(gui);

                // Tăng bộ đếm
                counter[0]++;

                // Hủy task sau 5 lần lặp
                if (counter[0] >= maxRuns) {
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(gui.getClass()), 10L, 10L); // Bắt đầu sau 10 ticks, lặp mỗi 10 ticks
    }
}
