package dev.jayjaytee.reegocraft.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public static int remove(Inventory inventory, Material mat, int amount)
    {
        ItemStack[] contents = inventory.getContents();
        int removed = 0;
        for (int i = 0; i < contents.length; i++) {
            ItemStack item = contents[i];

            if (item == null || !item.getType().equals(mat)) {
                continue;
            }

            int remove = item.getAmount() - amount - removed;

            if (removed > 0) {
                removed = 0;
            }

            if (remove <= 0) {
                removed += Math.abs(remove);
                contents[i] = null;
            } else {
                item.setAmount(remove);
            }
        }
        return removed;
    }
}
