package de.ghostsystem.ghostsystemv2.Commands;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class EC implements CommandExecutor {

    ArrayList<UUID> enderchest = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.ec")) {
                if (args.length == 0) {
                    p.openInventory(p.getEnderChest());
                    p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 5, 5);
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.ec.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                p.openInventory(target.getEnderChest());
                                p.sendMessage(Main.prefix + " Du guckst nun in die Enderchest des Spielers");
                                enderchest.contains(p.getUniqueId());
                                p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 5, 5);
                            } else {
                                p.sendMessage(Main.prefix + " Dieser Spieler ist nicht Online");
                            }
                        } else {
                            p.sendMessage(Main.prefix +" Dazu hast du keine Rechte");
                        }
                    } else {
                        p.sendMessage(Main.prefix + " Usage: /ec <player>");
                    }
                }
            } else {
                p.sendMessage( Main.prefix + " Dazu hast du keine Rechte");
            }
        }
        return false;
    }
}
