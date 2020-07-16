package dev.jayjaytee.reegocraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.jayjaytee.reegocraft.items.CustomItems.RenameNItem;
import static dev.jayjaytee.reegocraft.utils.CommandUtils.isInt;

public class ReegoItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("reego.admin")) {
            if (args.length == 3) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target != null){
                    if(isInt(args[2])){

                        if(args[1].equalsIgnoreCase("rename")){
                            sender.sendMessage("§aSuccess!");
                            target.sendMessage("§aYou've been given a RENAME 'N ITEM (x" + args[2] + ")");
                            target.getInventory().addItem(RenameNItem(Integer.parseInt(args[2])));
                            return true;
                        }else{
                            sender.sendMessage("§cThat item doesn't exist! TYPES: test");
                        }

                    }else{
                        sender.sendMessage("§cThe amount must be a number!");
                    }
                }else{
                    sender.sendMessage("§cThat player isn't online!");
                }
            } else {
                sender.sendMessage("§cIncorrect Usage! /reegoitems (player) (type) (amount)");
            }
        }else{
            sender.sendMessage("§cYou must be at least admin rank or higher to execute this command!");
        }
        return true;
    }
}
