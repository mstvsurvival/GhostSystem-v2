package de.ghostsystem.ghostsystemv2.Commands;


import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EventCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.prefix + " §cDu musst ein Spieler sein");
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("ghostsys.event")) {
            p.sendMessage(Main.noperm + " §cDazu hast du keine Rechte");
            return true;
        }
        if (args.length != 0) {
            p.sendMessage(Main.use + "/xpevent");
            return true;
        }
        for (int i = 0; i < 100; i++) {
            Entity bat = p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
            Entity xp = p.getWorld().spawnEntity(p.getLocation(), EntityType.THROWN_EXP_BOTTLE);
            bat.setPassenger(xp);
        }
        p.sendMessage(Main.prefix + " §aDer Eventschwarm wurde gespawnt");
        return true;
    }
}
