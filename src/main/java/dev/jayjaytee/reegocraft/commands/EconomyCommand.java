package dev.jayjaytee.reegocraft.commands;

import dev.jayjaytee.reegocraft.ReegoCraft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.jayjaytee.reegocraft.utils.CommandUtils.isFloat;

public class EconomyCommand implements CommandExecutor {
    ReegoCraft plugin;
    public EconomyCommand(ReegoCraft plugin) { this.plugin = plugin; }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("reego.admin")){
            sender.sendMessage("§cYou must be at least admin rank or higher to execute this command!");
            return true;
        }
        if(args.length != 3){
            sender.sendMessage("§cIncorrect Usage! /eco (player) (set/add/remove) (amount)");
            return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if(target == null){
            sender.sendMessage("§cThat player isn't online!");
            return true;
        }
        if(isFloat(args[2])){
            sender.sendMessage("§cThe amount must be a number!");
            return true;
        }
        if(args[1].equalsIgnoreCase("set")){
            plugin.getPlayerConfig().set(target.getUniqueId().toString() + ".Balance", Float.parseFloat(args[2]));
            sender.sendMessage("§aYou've set " + target.getDisplayName() + "'s Balance to $" + args[2]);
        }else if(args[1].equalsIgnoreCase("add")){
            double amount = (float) plugin.getPlayerConfig().getDouble(target.getUniqueId().toString() + ".Balance") + Float.parseFloat(args[2]);
            plugin.getPlayerConfig().set(target.getUniqueId().toString() + ".Balance", amount);
            sender.sendMessage("§aYou've given " + target.getDisplayName() + " $" + args[2]);
        }else if(args[1].equalsIgnoreCase("remove")){
            double amount = (float) plugin.getPlayerConfig().getDouble(target.getUniqueId().toString() + ".Balance") - Float.parseFloat(args[2]);
            plugin.getPlayerConfig().set(target.getUniqueId().toString() + ".Balance", amount);
            sender.sendMessage("§aYou've deducted $" + args[2] + " from " + target.getDisplayName() + "'s Balance");
        }
        return true;
    }
}
