package dev.jayjaytee.reegocraft.items;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
        String display = "Common";
        String displayColor = "&f";
        if(type==1) { display = "Uncommon"; displayColor = "&a"; }
        if(type==2) { display = "Epic"; displayColor = "&d"; }
        if(type==3) { display = "Legendary"; displayColor = "&6"; }
        ItemStack item = new ItemStack(Material.EXPERIENCE_BOTTLE, amount);
        ItemMeta meta = item.getItemMeta();
    }
}
