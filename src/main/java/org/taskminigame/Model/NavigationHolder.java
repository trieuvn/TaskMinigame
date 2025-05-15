package org.taskminigame.Model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class NavigationHolder implements InventoryHolder {
    private final Player player;

    public NavigationHolder(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
