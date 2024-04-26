package de.ghostsystem.ghostsystemv2.Commands;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSurvival implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.gm1")) {
                if (args.length == 0) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                    p.sendMessage(Main.prefix + " Dein Gamemode wurde auf Survival gesetzt");
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.gm1.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(Main.prefix +  " Dein Gamemode wurde auf Survival gesetzt");
                            p.sendMessage( Main.prefix + " Du hast den Spieler in Survival gesetzt");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                        }
                    } else {
                        p.sendMessage( Main.prefix + " Usage: /gm <0,1,3>  <player>");
                    }
                }
            } else {
                p.sendMessage(Main.prefix + " Dazu hast du keine Rechte");
            }
        }
        return false;
    }
}

