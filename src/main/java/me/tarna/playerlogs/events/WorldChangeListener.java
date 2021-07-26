package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class WorldChangeListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void PlayerWorldChange(PlayerChangedWorldEvent e) {
        if(!main.getConfig().getBoolean("world-change")) return;
        Player p = e.getPlayer();
        String w = p.getWorld().getName();

        String msg = p.getName() + " changed worlds to " + w;
        LogMessage("word-change", msg);

    }
}
