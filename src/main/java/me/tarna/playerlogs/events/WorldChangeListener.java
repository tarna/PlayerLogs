package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import me.tarna.playerlogs.lib.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeListener implements Listener {

    Log log;
    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void PlayerWorldChange(PlayerChangedWorldEvent e) {
        if(!main.getConfig().getBoolean("world-change")) return;
        Player p = e.getPlayer();
        String w = p.getWorld().getName();

        String msg = p.getName() + " changed worlds to " + w;
        log = new Log("word-change", msg);

    }
}
