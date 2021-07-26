package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class JoinListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        if(!main.getConfig().getBoolean("join")) return;
        String msg = e.getPlayer().getName() + " joined the server";
        LogMessage("join", msg);

    }
}
