package dev.jayjaytee.reegocraft.commands;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class UpgradeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                for (ItemStack item : player.getInventory().getContents()) {
                    if (item == null) {
                        continue;
                    }
                    if (item.getType() == Material.DIAMOND_PICKAXE) {
                        NBTItem nbt = new NBTItem(item);
                        if (nbt.getBoolean("upgradeToken")) {
                            if(!player.getInventory().getItemInMainHand().equals(item)) {
                                ItemStack hand = player.getInventory().getItemInMainHand();
                                switch(player.getInventory().getItemInMainHand().getType()){
                                    case WOODEN_HOE:
                                        hand.setType(Material.STONE_HOE);
                                        break;
                                    case STONE_HOE:
                                        hand.setType(Material.IRON_HOE);
                                        break;
                                    case IRON_HOE:
                                        hand.setType(Material.GOLDEN_HOE);
                                        break;
                                    case GOLDEN_HOE:
                                        hand.setType(Material.DIAMOND_HOE);
                                        break;
                                    case WOODEN_AXE:
                                        hand.setType(Material.STONE_AXE);
                                        break;
                                    case STONE_AXE:
                                        hand.setType(Material.IRON_AXE);
                                        break;
                                    case IRON_AXE:
                                        hand.setType(Material.GOLDEN_AXE);
                                        break;
                                    case GOLDEN_AXE:
                                        hand.setType(Material.DIAMOND_AXE);
                                        break;
                                    case WOODEN_SHOVEL:
                                        hand.setType(Material.STONE_SHOVEL);
                                        break;
                                    case STONE_SHOVEL:
                                        hand.setType(Material.IRON_SHOVEL);
                                        break;
                                    case IRON_SHOVEL:
                                        hand.setType(Material.GOLDEN_SHOVEL);
                                        break;
                                    case GOLDEN_SHOVEL:
                                        hand.setType(Material.DIAMOND_SHOVEL);
                                        break;
                                    case WOODEN_PICKAXE:
                                        hand.setType(Material.STONE_PICKAXE);
                                        break;
                                    case STONE_PICKAXE:
                                        hand.setType(Material.IRON_PICKAXE);
                                        break;
                                    case IRON_PICKAXE:
                                        hand.setType(Material.GOLDEN_PICKAXE);
                                        break;
                                    case GOLDEN_PICKAXE:
                                        hand.setType(Material.DIAMOND_PICKAXE);
                                        break;
                                    case WOODEN_SWORD:
                                        hand.setType(Material.STONE_SWORD);
                                        break;
                                    case STONE_SWORD:
                                        hand.setType(Material.IRON_SWORD);
                                        break;
                                    case IRON_SWORD:
                                        hand.setType(Material.GOLDEN_SWORD);
                                        break;
                                    case GOLDEN_SWORD:
                                        hand.setType(Material.DIAMOND_SWORD);
                                        break;
                                    default:
                                        player.sendMessage("§cYou cannot upgrade that item!");
                                        return true;
                                }
                                player.sendMessage("§aYou've upgraded your tool!");
                                item.setAmount(item.getAmount() - 1);
                                player.updateInventory();
                                return true;
                            }else{
                                player.sendMessage("§cYou cannot upgrade that item!");
                                return true;
                            }
                        }
                    }
                }
                player.sendMessage("§cYou don't have a upgrade token in your inventory!");
                return true;
            }else{
                player.sendMessage("§cYou must have a item in your hand to execute that command!");
            }
        }else{
            sender.sendMessage("§cYou must be a player to execute that command!");
        }
        return false;
    }
}
