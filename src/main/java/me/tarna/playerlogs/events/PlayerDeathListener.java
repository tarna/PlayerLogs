package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static me.tarna.playerlogs.lib.Util.LogMessage;

public class PlayerDeathListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if(!main.getConfig().getBoolean("player-death")) return;
        Player attacker = e.getEntity().getKiller();
        Player victim = e.getEntity();
        String msg = victim.getName() + " was killed by " + attacker.getName();
        LogMessage("player-death", msg);
    }

}
