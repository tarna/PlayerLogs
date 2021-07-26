package me.tarna.playerlogs;

import me.tarna.playerlogs.commands.PlayerLogsCommand;
import me.tarna.playerlogs.events.*;
import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public final class PlayerLogs extends JavaPlugin {

    FileConfiguration config = getConfig();
    public static PlayerLogs instance;

    @Override
    public void onEnable() {

        instance = this;

        loadBStats();

        getLogger().info("PlayerLogs Enabled!");

        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();

        getCommand("playerlogs").setExecutor(new PlayerLogsCommand());

        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new LeaveListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new CommandListener(), this);
        pm.registerEvents(new WorldChangeListener(), this);

        if(config.getBoolean("server-start")) {LogMessage("server-status", "Server Started!");}

    }

    @Override
    public void onDisable() {

        getLogger().info("PlayerLogs Disabled!");
        if(config.getBoolean("server-start")) {LogMessage("server-status", "Server Closed!");}

    }

    public void loadBStats() {
        int pluginId = 10760;
        Metrics metrics = new Metrics(this, pluginId);
    }

}
