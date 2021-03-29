package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import me.tarna.playerlogs.lib.Log;
import me.tarna.playerlogs.lib.Util;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    Util util = new Util();
    Log log;
    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnBreak(BlockBreakEvent e) {
        if(!main.getConfig().getBoolean("block-break")) return;
        Block b = e.getBlock();
        String msg = e.getPlayer().getName() + " broke " + b.getType().toString() + " " + util.LocationToText(b.getLocation());
        log = new Log("block-break", msg);
    }
}
