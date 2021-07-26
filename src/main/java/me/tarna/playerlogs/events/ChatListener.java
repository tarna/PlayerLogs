package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class ChatListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e) {
        if(!main.getConfig().getBoolean("chat")) return;
        String msg = e.getPlayer().getName() + ": " + e.getMessage();
        LogMessage("chat", msg);
    }
}
