package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import me.tarna.playerlogs.lib.Util;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    Util util = new Util();
    Log log;

    @EventHandler
    public void OnBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        String msg = e.getPlayer().getName() + " broke " + b.getType().toString() + " " + util.LocationToText(b.getLocation());
        log = new Log("block-break", msg);
    }
}
