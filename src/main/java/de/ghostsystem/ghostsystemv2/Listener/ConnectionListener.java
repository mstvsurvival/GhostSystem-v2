package de.ghostsystem.ghostsystemv2.Listener;

import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.teleport(new Location(Bukkit.getWorld(Main.world), 73, 63, -24, 0, 0));
        player.setHealth(20);
        player.setFoodLevel(20);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player= e.getPlayer();
        e.setQuitMessage(null);
    }

}
