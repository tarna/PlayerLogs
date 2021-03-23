package me.tarna.playerlogs.lib;

import org.bukkit.Location;

public class Util {

    public Util() {

    }

    public String LocationToText(Location l) {
        return "X:" + l.getX() + " Y: " + l.getY() + " Z: " + l.getZ() + " World: " + l.getWorld().getName();
    }

}
