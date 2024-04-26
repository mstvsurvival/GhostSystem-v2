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

    public static String prefix = "§7[§bGhostSystem§7] ";
    public static String noperm = "§7[§bGhostSystem§7] Dazu hast du keine Rechte ";
    public static String console = "§7[§bGhostSystem§7] §cDu musst ein Spieler sein umd dies Auszuführen! ";
    public static String use = "§7[§bGhostSystem§7] $cBitte benutze ";
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
        getCommand("kopf").setExecutor(new KopfCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("msg").setExecutor(new MSGCommand());
        getCommand("xpevent").setExecutor(new EventCommand());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ConnectionListener(), (Plugin)this);
        pm.registerEvents(new AntiSpamPlugin(), (Plugin)this);

    }

    @Override
    public void onDisable() {

    }
}
