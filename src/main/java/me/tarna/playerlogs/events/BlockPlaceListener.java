package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static me.tarna.playerlogs.lib.Util.LocationToText;
import static me.tarna.playerlogs.lib.Util.LogMessage;

public class BlockPlaceListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnPlace(BlockPlaceEvent e) {
        if(!main.getConfig().getBoolean("block-place")) return;
        Block b = e.getBlock();
        String msg = e.getPlayer().getName() + " placed " + b.getType() + " " + LocationToText(b.getLocation());
        LogMessage("block-place", msg);
    }
}
