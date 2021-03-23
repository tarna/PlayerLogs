package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    Log log;

    @EventHandler
    public void OnLeave(PlayerQuitEvent e) {

        String msg = e.getPlayer().getName() + " left the server";
        log = new Log("leave", msg);

    }
}
