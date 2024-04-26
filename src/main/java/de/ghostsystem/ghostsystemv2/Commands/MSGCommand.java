package de.ghostsystem.ghostsystemv2.Commands;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {
    private Main plugin;
    String message = "";

    public MSGCommand(){
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length >= 2) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target != null) {

                for (int i = 1; i < args.length; i++) {
                    message = message + args[i] + " ";

                }
                p.sendMessage("§c " + p.getName() + " §a-> " + target.getName() + " §8>>> " + message);
                target.sendMessage("§c " + target.getName() + " §a-> " + p.getName() + " §8>>> " + message);
                message = "";

            } else {
                p.sendMessage(Main.prefix + "Dieser Spieler ist nicht Online");
            }
        }
        return false;
    }
}
