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
        State2(gui);

        final int[] counter = {0};
        final int maxRuns = 8;

        new BukkitRunnable() {
            @Override
            public void run() {
                addElement(gui);

                counter[0]++;

                if (counter[0] >= maxRuns) {
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(gui.getClass()), 10L, 10L);
    }
}
