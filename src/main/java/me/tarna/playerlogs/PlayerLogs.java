package me.tarna.playerlogs;

import me.tarna.playerlogs.events.*;
import me.tarna.playerlogs.lib.Log;
import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerLogs extends JavaPlugin {

    Log log;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        loadBStats();

        getLogger().info("PlayerLogs Enabled!");

        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();

        if(config.getBoolean("block-break")) {pm.registerEvents(new BlockBreakListener(), this);}
        if(config.getBoolean("block-place")) {pm.registerEvents(new BlockPlaceListener(), this);}
        if(config.getBoolean("join")) {pm.registerEvents(new JoinListener(), this);}
        if(config.getBoolean("leave")) {pm.registerEvents(new LeaveListener(), this);}
        if(config.getBoolean("chat")) {pm.registerEvents(new ChatListener(), this);}
        if(config.getBoolean("commands")) {pm.registerEvents(new CommandListener(), this);}
        if(config.getBoolean("tnt-ignite")) {pm.registerEvents(new PlayerIgniteTntListener(), this);}
        if(config.getBoolean("world-change")) {pm.registerEvents(new WorldChangeListener(), this);}

        if(config.getBoolean("server-start")) {log = new Log("server-status", "Server Started!");}

    }

    @Override
    public void onDisable() {

        getLogger().info("PlayerLogs Disabled!");
        if(config.getBoolean("server-start")) {log = new Log("server-status", "Server Closed!");}

    }

    public void loadBStats() {
        int pluginId = 10760;
        Metrics metrics = new Metrics(this, pluginId);
    }

}
