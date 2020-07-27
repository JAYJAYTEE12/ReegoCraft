package dev.jayjaytee.reegocraft.commands;

import dev.jayjaytee.reegocraft.ReegoCraft;
import dev.jayjaytee.reegocraft.managers.SaveManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SaveCommand implements CommandExecutor {
    ReegoCraft plugin;
    public SaveCommand(ReegoCraft plugin) { this.plugin = plugin; }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("reego.admin")){
            plugin.getSaveManager().savePlayersFile();
            sender.sendMessage("§aSaved!");
        }
        return false;
    }
}
