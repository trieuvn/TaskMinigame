package org.taskminigame.Controller;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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

import static org.bukkit.Bukkit.getServer;
import static org.taskminigame.View.Wiring.State1;
import static org.taskminigame.View.Wiring.State2;

public class Wiring {
    public static void open(Player player){
        Inventory gui = State1(player);
        player.openInventory(gui);
    }

    public static void done(Inventory gui){
        State2(gui);
    }
}
