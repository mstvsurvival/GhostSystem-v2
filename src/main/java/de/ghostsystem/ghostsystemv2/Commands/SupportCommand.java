package de.ghostsystem.ghostsystemv2.Commands;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.imageio.stream.ImageInputStream;

public class SupportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage(Main.prefix + "§cDu musst ein Spieler sein um dies Auszuführen");
        } else {
            if (args.length == 0) {
                p.sendMessage(Main.prefix + "§cBitte warte... Ein Supporter wird gerufen");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.hasPermission("ghostsys.support")) {
                        p.sendMessage(Main.prefix + "§cDer Spieler " + p.getName() + " §chat um Support gebeten.");
                    }
                }
            } else {
                p.sendMessage(Main.prefix + "§cUsage: /support");
            }
        }
        return false;
    }
}
