package dev.jayjaytee.reegocraft;

import dev.jayjaytee.reegocraft.commands.CrateCommand;
import dev.jayjaytee.reegocraft.commands.ReegoItemsCommand;
import dev.jayjaytee.reegocraft.commands.RenameCommand;
import dev.jayjaytee.reegocraft.commands.UpgradeCommand;
import dev.jayjaytee.reegocraft.events.CratePlaceEvent;
import dev.jayjaytee.reegocraft.events.CustomItemsPreventionEvent;
import dev.jayjaytee.reegocraft.events.XPBottleSplashEvent;
import dev.jayjaytee.reegocraft.managers.SaveManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ReegoCraft extends JavaPlugin {

    private File playerFile = new File(getDataFolder(), "players.yml");
    private FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);
    private final SaveManager saveManager = new SaveManager(this);

    @Override
    public void onEnable() {
        if(!playerFile.exists()) { saveResource("players.yml", false); }
        saveManager.savePlayerFilesLoop();

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        saveManager.savePlayersFile();
    }

    private void registerCommands(){
        getCommand("crate").setExecutor(new CrateCommand());
        getCommand("reegoitems").setExecutor(new ReegoItemsCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("upgrade").setExecutor(new UpgradeCommand());
    }
    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new CratePlaceEvent(this), this);
        getServer().getPluginManager().registerEvents(new XPBottleSplashEvent(), this);
        getServer().getPluginManager().registerEvents(new CustomItemsPreventionEvent(), this);
    }

    public FileConfiguration getPlayerConfig() { return playerConfig; }
    public File getPlayerFile() { return playerFile; }

    public SaveManager getSaveManager() { return saveManager; }
}
