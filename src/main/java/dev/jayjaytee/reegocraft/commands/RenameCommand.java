package dev.jayjaytee.reegocraft.commands;

import de.tr7zw.nbtapi.NBTItem;
import dev.jayjaytee.reegocraft.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                player.sendMessage("§cIncorrect Usage: /rename (text...)");
            }else if(args.length > 0){
                for (ItemStack item : player.getInventory().getContents()) {
                    if(item == null) { continue; }
                    if (item.getType() == Material.SLIME_BALL) {
                        NBTItem nbt = new NBTItem(item);
                        if (nbt.getBoolean("renameToken")) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < args.length; i++) {
                                if (i != 0) {
                                    stringBuilder.append(" ").append(args[i]);
                                } else {
                                    stringBuilder.append(args[i]);
                                }
                            }
                            ItemStack hand = player.getInventory().getItemInMainHand();
                            ItemMeta handMeta = hand.getItemMeta();
                            handMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', stringBuilder.toString()));
                            hand.setItemMeta(handMeta);
                            item.setAmount(item.getAmount() - 1);
                            player.updateInventory();
                            player.sendMessage("§aYou set the item's display name to '" + stringBuilder.toString() + "'");
                            return true;
                        }
                    }
                }
                player.sendMessage("§cYou don't have a rename token in your inventory!");
                return true;
            }
        }else{
            sender.sendMessage("§cYou must be a player to execute that command!");
        }
        return false;
    }
}
