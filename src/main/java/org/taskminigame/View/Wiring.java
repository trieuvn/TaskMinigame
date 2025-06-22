package org.taskminigame.View;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;

public class Wiring {
    public static GUI State1(Player player){
        GUI gui = new GUI(player,119,54,"ꑜ");
        return gui;
    }

    public static void State2(GUI gui){
        gui.getPlayer().getOpenInventory().setTitle("ꑝ");
    }
}
