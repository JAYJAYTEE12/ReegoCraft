package dev.jayjaytee.reegocraft.commands;

import dev.jayjaytee.reegocraft.ReegoCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {
    ReegoCraft plugin;
    public BalanceCommand(ReegoCraft plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cYou must be a player to execute that command!");
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage("§fYour account balance: §a$" + (float) plugin.getPlayerConfig().getDouble(player.getUniqueId().toString() + ".Balance"));
        return true;
    }
}
