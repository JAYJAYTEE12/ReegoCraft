package dev.jayjaytee.reegocraft.managers;

import dev.jayjaytee.reegocraft.ReegoCraft;

import java.io.IOException;

public class SaveManager {

    ReegoCraft plugin;
    public SaveManager(ReegoCraft plugin) { this.plugin = plugin; }

    public void savePlayersFile(){
        try{
            plugin.getPlayerConfig().save(plugin.getPlayerFile());
            plugin.getServer().getConsoleSender().sendMessage("§aSuccessfully saved players.yml");
        }catch(IOException e){
            e.printStackTrace();
            plugin.getServer().getConsoleSender().sendMessage("§cThere was an error trying to save players.yml");
        }
    }
    public void savePlayerFilesLoop(){
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                savePlayersFile();
                savePlayerFilesLoop();
            }
        }, 20 * 600);
    }

}
