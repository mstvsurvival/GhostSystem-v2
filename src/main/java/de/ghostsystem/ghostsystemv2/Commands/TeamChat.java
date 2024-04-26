package de.ghostsystem.ghostsystemv2.Commands;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.teamchat")) {

                if (args.length >= 1) {
                    String msg = "";
                    for (int i = 0; i < args.length; i++) {
                        msg = msg+args[i]+ " ";
                    }
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("ghostsys.seeteamchat")) {
                            all.sendMessage(Main.prefix + " §7" + msg);
                        }
                    }
                } else {
                    p.sendMessage(Main.prefix + " §cUsage: /teamchat <message>");
                }
            } else {
                p.sendMessage(Main.prefix + " §cDer Chat ist nur für Teammitglieder");
            }
        }
        return false;
    }
}