package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    Log log;

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e) {
        String msg = e.getPlayer().getName() + ": " + e.getMessage();
        log = new Log("chat", msg);
    }
}
