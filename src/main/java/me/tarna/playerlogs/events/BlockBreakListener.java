package me.tarna.playerlogs.events;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static me.tarna.playerlogs.lib.Util.LocationToText;
import static me.tarna.playerlogs.lib.Util.LogMessage;

public class BlockBreakListener implements Listener {

    PlayerLogs main = PlayerLogs.instance;

    @EventHandler
    public void OnBreak(BlockBreakEvent e) {
        if(!main.getConfig().getBoolean("block-break")) return;
        Block b = e.getBlock();
        String msg = e.getPlayer().getName() + " broke " + b.getType() + " " + LocationToText(b.getLocation());
        LogMessage("block-break", msg);
    }
}
