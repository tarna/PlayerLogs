package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class CommandListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnCommand(PlayerCommandPreprocessEvent e) {
        if(!main.getConfig().getBoolean("commands")) return;
        if(main.getConfig().getList("player-blacklist").contains(e.getPlayer().getUniqueId())) return;
        if(main.getConfig().getList("command-blacklist").contains(e.getMessage())) return;
        String msg = e.getPlayer().getName() + " executed command " + e.getMessage();
        LogMessage("command", msg);

    }
}
