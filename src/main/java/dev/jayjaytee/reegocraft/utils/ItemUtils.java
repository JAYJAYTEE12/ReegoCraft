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
    public static String getRarity(int type, boolean getColor){
        String display = "Common";
        String displayColor = "§f";
        if(type==1) { display = "Uncommon"; displayColor = "§a"; }
        if(type==2) { display = "Epic"; displayColor = "§d"; }
        if(type==3) { display = "Legendary"; displayColor = "§6"; }
        if(!getColor) {
            return display;
        } else { return displayColor; }
    }
}
