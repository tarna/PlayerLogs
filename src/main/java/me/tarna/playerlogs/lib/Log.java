package me.tarna.playerlogs.lib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    Plugin main = Bukkit.getPluginManager().getPlugin("PlayerLogs");

    public Log(String name, String message) {

        try{
            File dataFolder = main.getDataFolder();
            if(!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File saveTo = new File(dataFolder,name + ".log");
            if(!saveTo.exists()) {
                saveTo.createNewFile();
            }

            String pattern = "dd MMMMM yyyy HH:mm:ss";
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
