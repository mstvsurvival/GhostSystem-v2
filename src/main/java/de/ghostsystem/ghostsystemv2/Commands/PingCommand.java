package de.ghostsystem.ghostsystemv2.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Dieser Befehl kann nur von Spielern verwendet werden.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.GREEN + "Pong! Du wurdest gepingt.");
        } else {
            String targetPlayerName = args[0];
            Player targetPlayer = player.getServer().getPlayer(targetPlayerName);

            if (targetPlayer != null) {
                targetPlayer.sendMessage(ChatColor.GREEN + "Du wurdest von " + player.getName() + " gepingt.");
                player.sendMessage(ChatColor.GREEN + "Du hast " + targetPlayer.getName() + " gepingt. Der Spieler hat " + player.getPing() + "§cms");
            } else {
                player.sendMessage(ChatColor.RED + "Spieler '" + targetPlayerName + "' wurde nicht gefunden.");
            }
        }

        return true;
    }
}
