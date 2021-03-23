package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    Log log;

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {

        String msg = e.getPlayer().getName() + " joined the server";
        log = new Log("join", msg);

    }
}
