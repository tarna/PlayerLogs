package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    Log log;
    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnCommand(PlayerCommandPreprocessEvent e) {
        if(!main.getConfig().getBoolean("commands")) return;
        String msg = e.getPlayer().getName() + " executed command " + e.getMessage();
        log = new Log("command", msg);

    }
}
