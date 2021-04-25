package com.shazzy.fly;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class flyReload implements CommandExecutor {

    private final Main main;

    public flyReload(Main main)
    {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = main.getConfig().getString("prefix");
        if (sender.hasPermission("fly.reload")){
            main.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bADVANCED FLY&7] &aSuccessfully reloaded configuration file!"));

        }else{
            sender.sendMessage(main.getConfig().getString("permission-message"));
            return true;
        }

        return true;
    }
}
