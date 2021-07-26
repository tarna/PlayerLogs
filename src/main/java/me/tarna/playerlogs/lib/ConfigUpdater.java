package me.tarna.playerlogs.lib;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigUpdater {

    String version;
    PlayerLogs plugin;

    public ConfigUpdater(PlayerLogs plugin, String version) {
        this.plugin = plugin;
        this.version = version;
        if(!isLatest()) update();
    }

    public boolean isLatest() {
        return this.plugin.getDescription().getVersion().equalsIgnoreCase(this.version);
    }

    public void update() {
        File configFile = new File(this.plugin.getDataFolder(), "config,yml");
        FileConfiguration config = this.plugin.getConfig();
        boolean ServerStart = config.getBoolean("server-start");
        boolean ServerStop = config.getBoolean("server-stop");
        boolean BlockPlace = config.getBoolean("block-place");
        boolean BlockBreak = config.getBoolean("block-break");
        boolean Join = config.getBoolean("join");
        boolean Leave = config.getBoolean("leave");
        boolean Chat = config.getBoolean("chat");
        boolean Commands = config.getBoolean("commands");
        boolean WorldChange = config.getBoolean("world-change");
        boolean deleted = configFile.delete();
        if(deleted) {
            this.plugin.saveDefaultConfig();
            this.plugin.reloadConfig();
        }else {
            Bukkit.getLogger().warning("Config failed to update");
        }
    }

}
