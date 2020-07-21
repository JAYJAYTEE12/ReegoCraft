package dev.jayjaytee.reegocraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.jayjaytee.reegocraft.items.CustomItems.*;
import static dev.jayjaytee.reegocraft.utils.CommandUtils.isInt;
import static dev.jayjaytee.reegocraft.utils.ItemUtils.getRarity;

public class ReegoItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("reego.admin")) {
            if(args.length >= 3) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (isInt(args[2])) {

                        if (args.length == 3) {
                            if (args[1].equalsIgnoreCase("rename")) {
                                sender.sendMessage("§aSuccess!");
                                target.sendMessage("§aYou've been given a RENAME 'N ITEM (x" + args[2] + ")");
                                target.getInventory().addItem(RenameNItem(Integer.parseInt(args[2])));
                                return true;
                            } else if (args[1].equalsIgnoreCase("upgrade")) {
                                sender.sendMessage("§aSuccess!");
                                target.sendMessage("§aYou've been given a UPGRADE 'N ITEM (x" + args[2] + ")");
                                target.getInventory().addItem(UpgradeNItem(Integer.parseInt(args[2])));
                                return true;
                            } else {
                                sender.sendMessage("§cThat item doesn't exist! TYPES: rename, upgrade");
                            }
                        } else {
                            sender.sendMessage("§cIncorrect Usage! /reegoitems (player) (type) (amount)");
                        }
                        if (args.length == 4) {
                            if (isInt(args[3])) {
                                if (args[1].equalsIgnoreCase("xp")) {
                                    sender.sendMessage("§aSuccess!");
                                    target.sendMessage("§aYou've been given a XP BOTTLE (x" + args[2] + ") (" + getRarity(Integer.parseInt(args[3]), false) + ")");
                                    target.getInventory().addItem(xpBottle(Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                                    return true;
                                } else {
                                    sender.sendMessage("§cThat item doesn't exist! TYPES: xp");
                                }
                            } else {
                                sender.sendMessage("§cThe rarity must be a number!");
                            }
                        } else {
                            sender.sendMessage("§cIncorrect Usage! /reegoitems (player) (type) (amount) (rarity)");
                        }

                    } else {
                        sender.sendMessage("§cThe amount must be a number!");
                    }
                } else {
                    sender.sendMessage("§cThat player isn't online!");
                }
            }else{
                sender.sendMessage("§cIncorrect Usage! /reegoitems (player) (type) (amount) [rarity]");
            }
        } else {
            sender.sendMessage("§cYou must be at least admin rank or higher to execute this command!");
        }
        return true;
    }
}
