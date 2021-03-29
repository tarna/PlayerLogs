package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    Log log;
    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnLeave(PlayerQuitEvent e) {
        if(!main.getConfig().getBoolean("leave")) return;
        String msg = e.getPlayer().getName() + " left the server";
        log = new Log("leave", msg);

    }
}
