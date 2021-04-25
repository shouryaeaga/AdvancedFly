package com.shazzy.fly;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        registerCommands();
        System.out.println("Ultimate fly plugin successfully enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Ultimate fly plugin successfully disabled!");
    }

    public void registerCommands(){
        this.getCommand("flyreload").setExecutor(new flyReload(this));
        this.getCommand("fly").setExecutor(new flyCommand(this));
    }


}
