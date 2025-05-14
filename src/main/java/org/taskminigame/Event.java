package org.taskminigame;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Model.WiringHolder;

import static org.taskminigame.Controller.Wiring.done;

public class Event implements Listener {
    @EventHandler
    public void onPlayerSelect(InventoryClickEvent event){

        Inventory inventory = event.getClickedInventory();
        if (inventory != null && inventory.getHolder() instanceof WiringHolder){
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            player.updateInventory();
            ItemStack item = event.getCurrentItem();
            //Mở hộp thoại message
            if (item == null && event.getRawSlot() == 31) {
                done(inventory);
            }

        }
    }
}
