package dev.jayjaytee.reegocraft.events;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import de.tr7zw.nbtapi.NBTItem;
import dev.jayjaytee.reegocraft.ReegoCraft;
import dev.jayjaytee.reegocraft.utils.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static dev.jayjaytee.reegocraft.items.CustomItems.*;
import static dev.jayjaytee.reegocraft.utils.ItemUtils.getRarity;
import static dev.jayjaytee.reegocraft.utils.NumberUtils.ChanceOf;


public class CratePlaceEvent implements Listener {
    ReegoCraft main;
    public CratePlaceEvent(ReegoCraft main) { this.main = main; }

    @EventHandler
    public void onPlaceCrate(BlockPlaceEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();

        ItemMeta handMeta = player.getInventory().getItemInMainHand().getItemMeta();
        ItemStack handStack = player.getInventory().getItemInMainHand();

        NBTItem nbt = new NBTItem(handStack);
        System.out.println(nbt);

        if(nbt.getString("crateType").equalsIgnoreCase("COMMON")){
            block.getLocation().getWorld().strikeLightningEffect(block.getLocation());

            Hologram holo = HologramsAPI.createHologram(main, block.getLocation().add(0.5D, 1.5D, 0.5D));
            Hologram h1 = HologramsAPI.createHologram(main, block.getLocation().add(2 + 0.5D, 3.5D, 0.5D));
            Hologram h2 = HologramsAPI.createHologram(main, block.getLocation().add(-2 + 0.5D, 3.5D, 0.5D));
            Hologram h3 = HologramsAPI.createHologram(main, block.getLocation().add( 0.5D, 3.5D, 2 + 0.5D));
            Hologram h4 = HologramsAPI.createHologram(main, block.getLocation().add( 0.5D, 3.5D, -2 + 0.5D));
            Hologram h5 = HologramsAPI.createHologram(main, block.getLocation().add( 0.5D, 4.5D, 0.5D));

            holo.appendTextLine("§f§l*§d§l*§f§l* §d§lREEGO CRATE: §f§nCommon Crate§f §f§l*§d§l*§f§l*");

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                @Override
                public void run() {
                    // 1
                    if(ChanceOf(50)){
                        h1.appendTextLine("§a1,000,000");
                        h1.appendItemLine(new ItemStack(Material.PAPER));
                    }else{
                        h1.appendTextLine("§a2,000,000");
                        h1.appendItemLine(new ItemStack(Material.PAPER));
                    }
                    block.getLocation().getWorld().strikeLightningEffect(h1.getLocation());

                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                        @Override
                        public void run() {
                            // 2
                            if(ChanceOf(50)){
                                h2.appendTextLine("§e1,000 Renown");
                                h2.appendItemLine(new ItemStack(Material.MAGMA_CREAM));
                            }else{
                                h2.appendTextLine("§e2,000 Renown");
                                h2.appendItemLine(new ItemStack(Material.MAGMA_CREAM));
                            }
                            block.getLocation().getWorld().strikeLightningEffect(h2.getLocation());

                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                @Override
                                public void run() {
                                    // 3
                                    if(ChanceOf(50)){
                                        h3.appendTextLine("§aRename 'n Item");
                                        h3.appendItemLine(new ItemStack(Material.SLIME_BALL));
                                        player.getInventory().addItem(RenameNItem(1));
                                    }else{
                                        h3.appendTextLine("§dUpgrade 'n Item");
                                        h3.appendItemLine(new ItemStack(Material.DIAMOND_PICKAXE));
                                        player.getInventory().addItem(UpgradeNItem(1));
                                    }
                                    block.getLocation().getWorld().strikeLightningEffect(h3.getLocation());

                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                        @Override
                                        public void run() {
                                            // 4
                                            int bottle = NumberUtils.RandomNumberBetween(0, 3);
                                            player.getInventory().addItem(xpBottle(1, bottle));
                                            h4.appendTextLine(getRarity(bottle, true) + "§l" + getRarity(bottle, false) + " §fExperience Bottle");
                                            h4.appendItemLine(new ItemStack(Material.EXPERIENCE_BOTTLE));
                                            block.getLocation().getWorld().strikeLightningEffect(h4.getLocation());

                                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                                @Override
                                                public void run() {
                                                    // 5
                                                    if(ChanceOf(50)){
                                                        h5.appendTextLine("§aVIP Rank");
                                                        h5.appendItemLine(new ItemStack(Material.EMERALD_BLOCK));
                                                    }else{
                                                        h5.appendTextLine("§bMVP Rank");
                                                        h5.appendItemLine(new ItemStack(Material.DIAMOND_BLOCK));
                                                    }
                                                    block.getLocation().getWorld().strikeLightningEffect(h5.getLocation());
                                                    block.getLocation().getWorld().strikeLightningEffect(h5.getLocation());

                                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            block.getLocation().getWorld().strikeLightningEffect(block.getLocation());
                                                            block.setType(Material.AIR);
                                                            holo.delete();
                                                            h1.delete();
                                                            h2.delete();
                                                            h3.delete();
                                                            h4.delete();
                                                            h5.delete();
                                                        }
                                                    }, 20* 3);
                                                }
                                            }, 20*3);
                                        }
                                    }, 20*3);
                                }
                            }, 20*3);
                        }
                    }, 20*3);
                }
            }, 20*3);
        }

    }
}