package org.taskminigame.Event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.taskminigame.Model.GUI;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Kiểm tra xem inventory có phải là của GUI không
        if (event.getInventory().getHolder() instanceof GUI) {
            GUI gui = (GUI) event.getInventory().getHolder();
            // Tạo và gọi sự kiện GUIClickEvent
            GUIClickEvent guiClickEvent = new GUIClickEvent(event, gui);
            Bukkit.getPluginManager().callEvent(guiClickEvent);

            // Đồng bộ trạng thái hủy giữa hai sự kiện
            event.setCancelled(guiClickEvent.isCancelled());
        }
    }
}
