package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    Log log;
    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e) {
        if(!main.getConfig().getBoolean("chat")) return;
        String msg = e.getPlayer().getName() + ": " + e.getMessage();
        log = new Log("chat", msg);
    }
}
