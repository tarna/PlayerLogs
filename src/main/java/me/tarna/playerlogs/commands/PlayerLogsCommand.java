package me.tarna.playerlogs.commands;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerLogsCommand implements CommandExecutor {

    PlayerLogs main = PlayerLogs.instance;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args[0].equalsIgnoreCase("reload")) {
            main.reloadConfig();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayerLogs has been reloaded!"));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cVersion: &e1.1.0"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cAuthor: &e_Tarna_"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cSite: &ehttps://github.com/tarna/PlayerLogs"));
            sender.sendMessage(" ");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c/playerlogs reload &0- &eReloads PlayerLogs Config"));
        }

        return true;
    }
}
