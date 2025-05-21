package org.taskminigame.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Controller.Clean;
import org.taskminigame.Controller.Download;
import org.taskminigame.Controller.Garbage;
import org.taskminigame.Controller.Wiring;
import org.taskminigame.Model.GUI;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerSelect(GUIClickEvent event){
        event.setCancelled(true);
        GUI gui = event.getGui();
        Inventory inventory = gui.getInventory();
        if (inventory != null) {
            //Wiring
            if (gui.getType() == 119 && gui.getState() == 1) {
                Player player = (Player) event.getOriginalEvent().getWhoClicked();
                event.getOriginalEvent().setCancelled(true);
                player.updateInventory();
                ItemStack item = event.getClickedItem();
                if (item == null && event.getRawSlot() == 31) {
                    Wiring.done(event.getGui());
                }
            }

            //Download
            if (gui.getType() == 121 && gui.getState() == 1) {
                Player player = (Player) event.getOriginalEvent().getWhoClicked();
                event.getOriginalEvent().setCancelled(true);
                player.updateInventory();
                ItemStack item = event.getClickedItem();
                //39 40 41
                if (item == null && (event.getRawSlot() == 39 || event.getRawSlot() == 40 || event.getRawSlot() == 41)) {
                    Download.startDownload(event.getGui());
                }
            }

            //Garbage
            if (gui.getType() == 129 && gui.getState() == 1) {
                Player player = (Player) event.getOriginalEvent().getWhoClicked();
                event.getOriginalEvent().setCancelled(true);
                player.updateInventory();
                ItemStack item = event.getClickedItem();
                //39 40 41
                if (item == null && (event.getRawSlot() == 34 || event.getRawSlot() == 35 || event.getRawSlot() == 43 || event.getRawSlot() == 44)) {
                    Garbage.startCleaning(event.getGui());
                }
            }

            //Clean
            if (gui.getType() == 131) {
                Player player = (Player) event.getOriginalEvent().getWhoClicked();
                event.getOriginalEvent().setCancelled(true);
                player.updateInventory();
                ItemStack item = event.getClickedItem();
                if (item != null && event.getRawSlot() != 0) {
                    Clean.moveTrash(gui,item, event.getRawSlot());
                }
            }
        }
    }
}
