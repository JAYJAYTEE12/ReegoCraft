package dev.jayjaytee.reegocraft.events;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemsPreventionEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        ItemStack hand = player.getInventory().getItemInMainHand();
        if(hand == null) { return; }
        NBTItem nbt = new NBTItem(hand);
        if (nbt.getBoolean("upgradeToken")) {
            event.setCancelled(true);
            player.sendMessage("§cYou cannot break blocks with this item!");
        }
    }
}
