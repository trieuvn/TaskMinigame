package org.taskminigame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;
import static org.taskminigame.Controller.Wiring.open;

public final class TaskMinigame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Event(),this);
        getCommand("sus").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender){

            //Cac lenh 3 từ
            if (args.length == 2) {
                if (args[0].equals("wiring")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    open(targetPlayer);
                }
            }
        }
        return true;
    }
}
