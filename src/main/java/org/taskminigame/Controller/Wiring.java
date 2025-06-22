package org.taskminigame.Controller;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.taskminigame.Model.GUI;

import static org.taskminigame.View.Wiring.*;

public class Wiring {
    public static void open(Player player){
        GUI gui = State1(player);
        player.openInventory(gui.getInventory());
    }

    public static void done(GUI gui){
        if (gui.getState() == 1){
            Player player = gui.getPlayer();
            player.playSound(player.getLocation(), "minecraft:wiring_switch", SoundCategory.MASTER, 1.0f, 1.0f);
            State2(gui);
            gui.setState(2);

            gui.success("wiring");
        }
    }
}
