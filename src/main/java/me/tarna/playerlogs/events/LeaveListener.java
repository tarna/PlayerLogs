package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class LeaveListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnLeave(PlayerQuitEvent e) {
        if(!main.getConfig().getBoolean("leave")) return;
        String msg = e.getPlayer().getName() + " left the server";
        LogMessage("leave", msg);

    }
}
