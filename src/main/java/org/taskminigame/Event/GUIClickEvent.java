package org.taskminigame.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.taskminigame.Model.GUI;

public class GUIClickEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final GUI gui;
    private final int slot;
    private final int rawSlot;
    private final ItemStack clickedItem;
    private final ClickType clickType;
    private boolean cancelled;
    private final InventoryClickEvent originalEvent;

    public GUIClickEvent(InventoryClickEvent event, GUI gui) {
        this.player = (Player) event.getWhoClicked();
        this.gui = gui;
        this.slot = event.getSlot();
        this.rawSlot = event.getRawSlot();
        this.clickedItem = event.getCurrentItem();
        this.clickType = event.getClick();
        this.cancelled = event.isCancelled();
        this.originalEvent = event;
    }

    public Player getPlayer() {
        return player;
    }

    public GUI getGui() {
        return gui;
    }

    public int getSlot() {
        return slot;
    }

    public ItemStack getClickedItem() {
        return clickedItem;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public InventoryClickEvent getOriginalEvent() {
        return originalEvent;
    }

    public int getRawSlot() {
        return rawSlot;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
        this.originalEvent.setCancelled(cancelled);
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}