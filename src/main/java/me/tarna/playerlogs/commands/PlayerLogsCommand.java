package me.tarna.playerlogs.commands;

import me.tarna.playerlogs.PlayerLogs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.tarna.playerlogs.lib.Util.formatMessage;

public class PlayerLogsCommand implements CommandExecutor {

    PlayerLogs main = PlayerLogs.instance;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args[0].equalsIgnoreCase("reload")) {
            main.reloadConfig();

            sender.sendMessage(formatMessage("&cPlayerLogs has been reloaded!"));
        }else {
            sender.sendMessage(formatMessage("&cVersion: &e1.1.0"));
            sender.sendMessage(formatMessage("&cAuthor: &e_Tarna_"));
            sender.sendMessage(formatMessage("&cSite: &ehttps://github.com/tarna/PlayerLogs"));
            sender.sendMessage(" ");
            sender.sendMessage(formatMessage("&c/playerlogs reload &0- &eReloads PlayerLogs Config"));
        }

        return true;
    }
}
