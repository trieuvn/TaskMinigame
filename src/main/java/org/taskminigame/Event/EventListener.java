package org.taskminigame.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Controller.*;
import org.taskminigame.Model.GUI;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerSelect(GUIClickEvent event){
        //event.setCancelled(true);
        GUI gui = event.getGui();
        Inventory inventory = gui.getInventory();
        if (inventory != null) {
            //Navigation
            if (gui.getType() == 125 && gui.getState() != -1) {
                Player player = (Player) event.getOriginalEvent().getWhoClicked();
                event.getOriginalEvent().setCancelled(true);
                player.updateInventory();
                ItemStack item = event.getClickedItem();
                int slot = event.getRawSlot();
                if (item == null && ((slot > 23 && slot < 27) || (slot > 32 && slot < 36) || (slot > 41 && slot < 45))) {
                    Reactor.onClick(gui,slot);
                }
            }
            //Navigation
            if (gui.getType() == 117 && gui.getState() == 1) {
                if (event.getRawSlot() != 0) {
                    ItemStack item = event.getOriginalEvent().getCursor();
                    if (event.getRawSlot() == 31){
                        if (Navigation.checkCursor(item)){
                            gui.setState(0);
                            Navigation.done(gui);
                        }
                    }
                }else{
                    event.getOriginalEvent().setCancelled(true);
                }
            }
            
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

    @EventHandler
    public void onPlayerSelect(InventoryCloseEvent event){
        ItemStack item = event.getPlayer().getItemOnCursor();
        if (item == null) return ;
        if (Navigation.checkCursor(item)){
            event.getPlayer().setItemOnCursor(null);
        }
    }
}
