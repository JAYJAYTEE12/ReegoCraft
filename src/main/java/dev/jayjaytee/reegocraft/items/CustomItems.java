package dev.jayjaytee.reegocraft.items;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static dev.jayjaytee.reegocraft.utils.ItemUtils.getRarity;

public class CustomItems {
    public static ItemStack RenameNItem(int amount){
        ItemStack item = new ItemStack(Material.SLIME_BALL, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aRename 'n Item");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.LURE, 1, true);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Type /rename with me in your inventory");
        lore.add("§7to apply to an item!");
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbt = new NBTItem(item);
        nbt.setBoolean("renameToken", true);

        item = nbt.getItem();
        return item;
    }
    public static ItemStack UpgradeNItem(int amount){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dUpgrade 'n Item");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.LURE, 1, true);
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Type /upgrade with me in your inventory");
        lore.add("§7to apply to an item!");
        lore.add(" ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbt = new NBTItem(item);
        nbt.setBoolean("upgradeToken", true);

        item = nbt.getItem();
        return item;
    }
    public static ItemStack xpBottle(int amount, int type){
        ItemStack item = new ItemStack(Material.EXPERIENCE_BOTTLE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(getRarity(type, true) + "§l" + getRarity(type, false) + "§f XP Bottle");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7Smash it open to receive");
        lore.add("§7experience!");
        lore.add(" ");
        lore.add(getRarity(type, true) + "§l" + getRarity(type, false).toUpperCase());
        meta.setLore(lore);
        item.setItemMeta(meta);

        NBTItem nbt = new NBTItem(item);
        nbt.setInteger("rarity", type);

        item = nbt.getItem();
        return item;
    }
}
