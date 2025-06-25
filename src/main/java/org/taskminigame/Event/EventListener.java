package org.taskminigame.Event;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Controller.*;
import org.taskminigame.Model.GUI;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerSelect(GUIClickEvent event){
        event.setCancelled(true);
        GUI gui = event.getGui();
        Inventory inventory = gui.getInventory();
        if (inventory != null) {
            //Reactor
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
                if (event.getOriginalEvent().getSlotType() == InventoryType.SlotType.OUTSIDE) return ;
                ItemStack clickedItem = event.getClickedItem();
                ItemStack cursor = event.getOriginalEvent().getCursor();
                //check vị trí click trong rương
                if (Navigation.checkCursor(clickedItem) && event.getOriginalEvent().getInventory().getType() == InventoryType.CHEST && event.getRawSlot() < event.getOriginalEvent().getView().getTopInventory().getSize()){
                    event.getPlayer().setItemOnCursor(clickedItem);
                    event.getOriginalEvent().getInventory().setItem(event.getRawSlot(), null);
                }else if (clickedItem == null && Navigation.checkCursor(cursor) && event.getOriginalEvent().getInventory().getType() == InventoryType.CHEST && event.getRawSlot() < event.getOriginalEvent().getView().getTopInventory().getSize()){
                    event.getPlayer().setItemOnCursor(null);
                    event.getOriginalEvent().getInventory().setItem(event.getRawSlot(), cursor);
                }

                if (event.getRawSlot() == 31){
                    if (Navigation.checkCursor(cursor)){
                        gui.setState(0);
                        Navigation.done(gui);
                    }
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
                if (item != null) {
                    Clean.moveTrash(gui,item, event.getRawSlot());
                }
            }
        }
    }

    @EventHandler
    public void onPlayerCloseInventory(InventoryCloseEvent event){
        ItemStack item = event.getPlayer().getItemOnCursor();
        if (item == null) return ;
        if (Navigation.checkCursor(item)){
            event.getPlayer().setItemOnCursor(null);
        }

        HumanEntity player = event.getPlayer();
        Inventory playerInventory = player.getInventory();
        for (int i = 0; i < playerInventory.getSize(); i++) {
            ItemStack itemnav = playerInventory.getItem(i);
            if (item != null && Navigation.checkCursor(itemnav)) {
                playerInventory.setItem(i, null);
            }
        }
    }
}
