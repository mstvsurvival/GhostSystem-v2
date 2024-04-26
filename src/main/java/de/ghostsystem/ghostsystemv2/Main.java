package de.ghostsystem.ghostsystemv2;

import de.ghostsystem.ghostsystemv2.Commands.*;
import de.ghostsystem.ghostsystemv2.Listener.AntiSpamPlugin;
import de.ghostsystem.ghostsystemv2.Listener.ConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static String prefix = "§7[§3GhostSystem§7] ";
    public static String world = "CityBuild1";

    @Override
    public void onEnable() {
        instance = this;
        getCommand("gm0").setExecutor(new GamemodeSurvival());
        getCommand("gm1").setExecutor(new GamemodeCreative());
        getCommand("gm3").setExecutor(new GamemodeSpectator());
        getCommand("tc").setExecutor(new TeamChat());
        getCommand("ec").setExecutor(new EC());
        getCommand("report").setExecutor(new Report());
        getCommand("adminitems").setExecutor(new AdminItems());
        getCommand("support").setExecutor(new SupportCommand());
        getCommand("tc").setExecutor(new TeamChat());


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListener(), (Plugin)this);
        pluginManager.registerEvents(new AntiSpamPlugin(), (Plugin)this);

    }

    @Override
    public void onDisable() {

    }
}
