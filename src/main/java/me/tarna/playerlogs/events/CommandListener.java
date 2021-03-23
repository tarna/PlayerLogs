package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    Log log;

    @EventHandler
    public void OnCommand(PlayerCommandPreprocessEvent e) {

        String msg = e.getPlayer().getName() + " executed command " + e.getMessage();
        log = new Log("command", msg);

    }
}
