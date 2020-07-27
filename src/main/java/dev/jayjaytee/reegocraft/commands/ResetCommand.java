package dev.jayjaytee.reegocraft.commands;

import dev.jayjaytee.reegocraft.ReegoCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    ReegoCraft plugin;
    public ResetCommand(ReegoCraft plugin) { this.plugin = plugin; }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender.hasPermission("reego.admin") && sender instanceof Player){
            plugin.getPlayerConfig().set(player.getUniqueId().toString(), null);
            player.sendMessage("§aDeleted!");
        }
        return false;
    }
}
