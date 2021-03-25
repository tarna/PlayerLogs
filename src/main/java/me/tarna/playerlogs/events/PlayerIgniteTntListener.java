package me.tarna.playerlogs.events;

import me.tarna.playerlogs.lib.Log;
import me.tarna.playerlogs.lib.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerIgniteTntListener implements Listener {

    Util util = new Util();
    Log log;

    @EventHandler
    public void PlayerTntIgnite(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        assert b != null;
        if(b.getType() == Material.TNT) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                String msg = p.getName() + " ignited tnt at location " + util.LocationToText(b.getLocation());
                log = new Log("tnt-ignite", msg);
            }
        }
    }
}
