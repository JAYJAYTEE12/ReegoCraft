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

                        if(args[1].equalsIgnoreCase("test")){
                            ItemStack item = createItem(Material.ENDER_CHEST, Integer.parseInt(args[2]), "&f&l*** &d&lTEST &6&lCRATE &f&l***");
                            NBTItem nbt = new NBTItem(item);
                            nbt.setString("crateType", "test");
                            item = nbt.getItem();
                            target.getInventory().addItem(item);
                            return true;
                        }else{
                            sender.sendMessage("§cThat crate doesn't exist! TYPES: test");
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
