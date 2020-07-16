package dev.jayjaytee.reegocraft.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {
    public static ItemStack createItem(Material itemMaterial, int amount, String displayString, String... loreString){
        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(itemMaterial, amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayString));
        for(String s : loreString){
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
