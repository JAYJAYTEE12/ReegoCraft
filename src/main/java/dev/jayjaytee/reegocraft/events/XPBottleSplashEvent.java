package dev.jayjaytee.reegocraft.events;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

import static dev.jayjaytee.reegocraft.utils.ItemUtils.getRarity;

public class XPBottleSplashEvent implements Listener {
    @EventHandler
    public void onXPSplash(ProjectileLaunchEvent event){
        final Projectile projectile = event.getEntity();

        if(!(projectile instanceof ThrownExpBottle)){
            return;
        }
        final ProjectileSource player = projectile.getShooter();

        if(!(player instanceof Player)){
            return;
        }

        ItemStack item = ((Player) player).getInventory().getItemInMainHand();
        NBTItem nbt = new NBTItem(item);

        event.setCancelled(true);
        //((Player) player).sendMessage("§aYou have thrown a " + getRarity(nbt.getInteger("rarity")-1, false) + " XP bottle!");
        int xp = 10;
        if(nbt.getInteger("rarity")-1 == 1) { xp = 20; }
        if(nbt.getInteger("rarity")-1 == 2) { xp = 45; }
        if(nbt.getInteger("rarity")-1 == 3) { xp = 100; }
        ((Player) player).giveExpLevels(xp);
        ((Player) player).sendMessage("§a+ §f§l§o" + xp + " Levels");
        item.setAmount(item.getAmount() - 1);
        ((Player) player).updateInventory();
    }
}
