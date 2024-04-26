package de.ghostsystem.ghostsystemv2.Commands;


import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import sun.jvm.hotspot.opto.MachSafePointNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Report implements CommandExecutor, TabCompleter {

    File file = new File("plugins/ghostsystem", "reports.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for (Player onlinePlayer : player.getWorld().getPlayers()) {
                    completions.add(onlinePlayer.getName());
                }
            }
        } else if (args.length == 2) {
            completions.add("Hacking");
            completions.add("Spamming");
            completions.add("Scamming");
            completions.add("TeamBeleidigungen");
            completions.add("Beleidigung");
        }

        return completions;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage(Main.prefix + " §cDu musst ein Spieler sein");
        } else {
            if (args.length > 1) {
                Player toReport = Bukkit.getPlayer(args[0]);
                if (toReport.hasPermission("ghostsys.report.ignore")) {
                    p.sendMessage(Main.prefix + " §cDu darfst kein Teammitglied Reporten.");
                    return false;
                }
                if (toReport != null) {
                    if (args[1].equalsIgnoreCase("Hacking")) {
                        p.sendMessage(Main.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.hasPermission("ghostsys.report.notify")) {
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                all.sendMessage(Main.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                all.sendMessage(Main.prefix + "§avon: §c" + p.getName());
                                all.sendMessage(Main.prefix + "§aGrund: §cHacking");
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            }
                        }
                    }
                    if (args[1].equalsIgnoreCase("Spamming")) {
                        p.sendMessage(Main.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.hasPermission("ghostsys.report.notify")) {
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                all.sendMessage(Main.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                all.sendMessage(Main.prefix + "§avon: §c" + p.getName());
                                all.sendMessage(Main.prefix + "§aGrund: §cSpamming");
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            }
                        }
                    }
                    if (args[1].equalsIgnoreCase("Scamming")) {
                        p.sendMessage(Main.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.hasPermission("ghostsys.report.notify")) {
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                all.sendMessage(Main.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                all.sendMessage(Main.prefix + "§avon: §c" + p.getName());
                                all.sendMessage(Main.prefix + "§aGrund: §cScamming");
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            }
                        }
                        if (args[1].equalsIgnoreCase("Beleidigen")) {
                            p.sendMessage(Main.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                if (all.hasPermission("ghostsys.report.notify")) {
                                    all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                    all.sendMessage(Main.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                    all.sendMessage(Main.prefix + "§avon: §c" + p.getName());
                                    all.sendMessage(Main.prefix + "§aGrund: §cSpamming");
                                    all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                }
                            }
                        }
                    }
                    if (args[1].equalsIgnoreCase("TeamBeleidigungen")) {
                        p.sendMessage(Main.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.hasPermission("ghostsys.report.notify")) {
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                all.sendMessage(Main.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                all.sendMessage(Main.prefix + "§avon: §c" + p.getName());
                                all.sendMessage(Main.prefix + "§aGrund: §cSpamming");
                                all.sendMessage(Main.prefix + "§7[]=========§cGhostReport§7=========[]");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            }
                        }
                    }

                    try {
                        cfg.save(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    p.sendMessage(Main.prefix + "§cUsage: /report <name> <grund>");
                }
            } else {
                p.sendMessage(Main.prefix + "§cUsage: /report <name> <grund>");
            }
        }

        return false;
    }
}



