package dev.jayjaytee.reegocraft;

import dev.jayjaytee.reegocraft.commands.CrateCommand;
import dev.jayjaytee.reegocraft.commands.ReegoItemsCommand;
import dev.jayjaytee.reegocraft.commands.RenameCommand;
import dev.jayjaytee.reegocraft.commands.UpgradeCommand;
import dev.jayjaytee.reegocraft.events.CratePlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReegoCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){
        getCommand("crate").setExecutor(new CrateCommand());
        getCommand("reegoitems").setExecutor(new ReegoItemsCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("upgrade").setExecutor(new UpgradeCommand());
    }
    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new CratePlaceEvent(this), this);
    }
}
