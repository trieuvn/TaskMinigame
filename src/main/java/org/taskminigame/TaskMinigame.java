package org.taskminigame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;
import org.taskminigame.Controller.Clean;
import org.taskminigame.Controller.Clean;
import org.taskminigame.Controller.Download;
import org.taskminigame.Controller.Garbage;
import org.taskminigame.Controller.Navigation;
import org.taskminigame.Controller.Reactor;
import org.taskminigame.Controller.Refuel;
import org.taskminigame.Controller.Wiring;

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
                    Wiring.open(targetPlayer);
                }
                
                if (args[0].equals("clean")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Clean.open(targetPlayer);
                }
                
                if (args[0].equals("download")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Download.open(targetPlayer);
                }
                
                if (args[0].equals("garbage")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Garbage.open(targetPlayer);
                }
                
                if (args[0].equals("navigation")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Navigation.open(targetPlayer);
                }
                
                if (args[0].equals("reactor")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Reactor.open(targetPlayer);
                }
                
                if (args[0].equals("refuel")){
                    String targetPlayerName = args[1];
                    Player targetPlayer = getServer().getPlayer(targetPlayerName);
                    if (targetPlayer == null)
                        return true;
                    Refuel.open(targetPlayer);
                }
            }
            
        }
        return true;
    }
}
