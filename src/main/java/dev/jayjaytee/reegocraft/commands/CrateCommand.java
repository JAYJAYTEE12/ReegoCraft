package dev.jayjaytee.reegocraft.commands;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static dev.jayjaytee.reegocraft.utils.CommandUtils.isInt;
import static dev.jayjaytee.reegocraft.utils.ItemUtils.createItem;

public class CrateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("reego.admin")) {
            if (args.length == 3) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target != null){
                    if(isInt(args[2])){

                        if(args[1].equalsIgnoreCase("common")){
                            ItemStack item = createItem(Material.ENDER_CHEST, Integer.parseInt(args[2]), "§f§l*§d§l*§f§l* §d§lREEGO CRATE: §f§nCommon Crate§f §f§l*§d§l*§f§l*", "§d§lUnlocked by §f§o" + target.getDisplayName(), " §d§lat §f§nmc.reego.org", " ", "§f§l§nSPECIAL REWARDS", "§f* VIP Rank", "§f* MVP Rank", " ", "§6§l§nTREASURE ITEMS", "§6* 1,000,000 - 2,000,000 In-game Cash", "§6* 1,000 - 2,000 Renown", "§6* Common Experience Bottle - Legendary Experience Bottle", " ", "§e§l§nITEM MODS", "§e* Rename 'n Item", "§e* Upgrade 'n Item", " ", "§cEnsure you have a lot of free space!", "§d§nPlace in an open area for best results!", "§7Hint: Place on ground");
                            NBTItem nbt = new NBTItem(item);
                            nbt.setString("crateType", "common");
                            item = nbt.getItem();
                            target.getInventory().addItem(item);
                            return true;
                        }else{
                            sender.sendMessage("§cThat crate doesn't exist! TYPES: Common");
                        }

                    }else{
                        sender.sendMessage("§cThe amount must be a number!");
                    }
                }else{
                    sender.sendMessage("§cThat player isn't online!");
                }
            } else {
                sender.sendMessage("§cIncorrect Usage! /crate (player) (type) (amount)");
            }
        }else{
            sender.sendMessage("§cYou must be at least admin rank or higher to execute this command!");
        }
        return true;
    }
    // /crate (player) (type) (amount)
}
