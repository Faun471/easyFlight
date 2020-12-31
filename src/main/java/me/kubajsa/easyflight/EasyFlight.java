package me.kubajsa.easyflight;

import me.kubajsa.easyflight.commands.EasyFlightCommand;
import me.kubajsa.easyflight.commands.FlyCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyFlight extends JavaPlugin {

    public static String version = "1.3";
    public static Boolean isBeta = false;

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("easyflight").setExecutor(new EasyFlightCommand());


        //Init config

        FlyUtils utils = new FlyUtils(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Easy Flight Enabled");
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Version: " + version);
        if (isBeta){getServer().getConsoleSender().sendMessage("§bEasyFlight: §cWarning: Running a beta version, expect bugs!");} //Warning message if isBeta is true
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Easy Flight Disabled");
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Version: " + version);
    }
}
