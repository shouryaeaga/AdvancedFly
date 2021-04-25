package com.shazzy.fly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {

    private Main main;

    public flyCommand(Main main)
    {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = main.getConfig().getString("prefix");
        if (label.equalsIgnoreCase("fly")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(prefix + "Console can now fly! Yay!");
                return true;
            }
            Player player = (Player)sender;
            if (args.length == 0) {
                if (player.hasPermission("fly.use")) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.disability")));
                        return true;
                    }
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.ability")));
                        return true;
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("permission-message")));
                }
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (player.hasPermission("fly.use.others")) {
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.not-online")));
                    } else {
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.disability")));
                            return true;
                        }
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.ability")));
                            return true;
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + main.getConfig().getString("messages.permission-message")));
                }
            }
            return true;
        }
        return true;
    }
}
