package de.ghostsystem.ghostsystemv2.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class AntiSpamPlugin implements Listener {

    private final Map<String, Integer> messageCounts = new HashMap<>();
    private final int maxMessages = 5; // Anzahl der maximalen Nachrichten, bevor ein Spieler gekickt wird
    private final int kickThreshold = 3; // Anzahl der Nachrichten, bevor ein Spieler gekickt wird

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        // Überprüfen, ob der Spieler die Erlaubnis zum Überspringen der Spam-Überprüfung hat
        if (player.hasPermission("antispam.bypass"))
            return;

        int messageCount = messageCounts.getOrDefault(playerName, 0);
        if (messageCount >= maxMessages) {
            player.kickPlayer("Du wurdest wegen Spam gekickt!");
            return;
        } else if (messageCount >= kickThreshold) {
            player.sendMessage("Du wirst gekickt, wenn du weiterhin spamst!");
        }

        messageCounts.put(playerName, messageCount + 1);
    }
}



