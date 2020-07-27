package dev.jayjaytee.reegocraft.events;

import dev.jayjaytee.reegocraft.ReegoCraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    ReegoCraft plugin;
    public PlayerJoinEvent(ReegoCraft plugin) { this.plugin = plugin; }

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("§aREEGO CRAFT: Beta version 0.0.1");
        if(!plugin.getPlayerConfig().isSet(player.getUniqueId().toString())){
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Balance", 0);
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Renown", 0);
        }
        player.sendMessage("§a$" + plugin.getPlayerConfig().getDouble(player.getUniqueId().toString() + ".Balance"));
        player.sendMessage("§e" + plugin.getPlayerConfig().getInt(player.getUniqueId().toString() + ".Renown"));
    }
}
