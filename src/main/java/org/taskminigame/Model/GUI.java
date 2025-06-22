/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.taskminigame.Model;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GUI implements InventoryHolder{
    private Inventory inventory;

    private Integer shift = -8;
    private final Player player;
    private int state;
    private int type;

    private int amount;

    private ArrayList<Integer> itemLocations;

    private int playerScore;

    private String title;

    public GUI(Player player, int type, int slot, String title) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        this.title = miniMessage.deserialize("<shift:"+shift.toString()+">"+title).color(NamedTextColor.WHITE).toString();
        inventory = Bukkit.createInventory(this, slot, miniMessage.deserialize("<shift:"+shift.toString()+">"+title).color(NamedTextColor.WHITE));
        this.player = player;
        this.type = type;
        this.state = 1;
        this.amount = 1;
    }

    public void setTitle(String title){
        title = "<shift:"+shift.toString()+">§f"+title;
        this.title = title;
        player.getOpenInventory().setTitle(this.title);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArrayList<Integer> getItemLocations() {
        return itemLocations;
    }

    public void setItemLocations(ArrayList<Integer> itemLocations) {
        this.itemLocations = itemLocations;
    }

    public void success(String task){
        // Phát âm thanh SUCCESS
        //player.playSound(player.getLocation(), "minecraft:welcome", SoundCategory.MASTER, 1.0f, 1.0f);
        //player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ce call " + task + "_task %player_name%=" + player.getName());

        // Tạo cooldown 2 giây và thực thi lệnh console
        new BukkitRunnable() {
            @Override
            public void run() {
                inventory.close();
            }
        }.runTaskLater(JavaPlugin.getProvidingPlugin(this.getClass()), 40L); // 40 ticks = 2 giây
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
