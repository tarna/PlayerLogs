package me.tarna.playerlogs.lib;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String formatMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String LocationToText(Location l) {
        return "X:" + l.getX() + " Y: " + l.getY() + " Z: " + l.getZ() + " World: " + l.getWorld().getName();
    }

    public static void LogMessage(String name, String message) {
        try{
            File dataFolder = PlayerLogs.instance.getDataFolder();
            if(!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File saveTo = new File(dataFolder,name + ".log");
            if(!saveTo.exists()) {
                saveTo.createNewFile();
            }

            String pattern = "dd MM yyyy HH:mm:ss";
            SimpleDateFormat date = new SimpleDateFormat(pattern);
            String dateString = date.format(new Date());

            FileWriter fw = new FileWriter(saveTo, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("[" + dateString + "] " + message);
            pw.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
