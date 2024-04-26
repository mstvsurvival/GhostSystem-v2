package de.ghostsystem.ghostsystemv2.Commands;


import de.ghostsystem.ghostsystemv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class AdminItems implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("ghostsys.adminitems")) {
                Inventory inventory = Bukkit.createInventory(null, 27);
                ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
                ItemMeta meta = itemStack.getItemMeta();
                meta.setUnbreakable(true);
                meta.setDisplayName("§cOP-Schwert");
                meta.addEnchant(Enchantment.DAMAGE_ALL, 255, true);
                meta.addEnchant(Enchantment.FIRE_ASPECT, 255, true);
                meta.addEnchant(Enchantment.MENDING, 255, true);
                meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 255, true);
                itemStack.setItemMeta(meta);
                ItemStack itemStack2 = new ItemStack(Material.BOW);
                ItemMeta meta2 = itemStack2.getItemMeta();
                meta2.setUnbreakable(true);
                meta2.setDisplayName("§cOP-Bogen");
                meta2.addEnchant(Enchantment.ARROW_FIRE, 100, true);
                meta2.addEnchant(Enchantment.ARROW_KNOCKBACK, 100, true);
                meta2.addEnchant(Enchantment.MENDING, 100, true);
                meta2.addEnchant(Enchantment.ARROW_INFINITE, 100, true);
                itemStack2.setItemMeta(meta2);
                inventory.setItem(0, itemStack);
                inventory.setItem(1, itemStack2);
                player.openInventory(inventory);
                ItemStack itemStack3 = new ItemStack(Material.SNOWBALL);
                ItemMeta meta3 = itemStack3.getItemMeta();
                meta3.setUnbreakable(true);
                meta3.setDisplayName("§cSchneeball");
                meta3.addEnchant(Enchantment.ARROW_FIRE, 1, true);
                meta3.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
                meta3.addEnchant(Enchantment.MENDING, 100, true);
                itemStack3.setItemMeta(meta3);
                inventory.setItem(0, itemStack);
                inventory.setItem(1, itemStack2);
                inventory.setItem(2, itemStack3);
                player.openInventory(inventory);
                ItemStack itemStack4 = new ItemStack(Material.FIRE_CHARGE);
                ItemMeta meta4 = itemStack4.getItemMeta();
                meta4.setUnbreakable(true);
                meta4.setDisplayName("§cOP-FIRE_CHARGE");
                meta4.addEnchant(Enchantment.KNOCKBACK, 5, true);
                meta4.addEnchant(Enchantment.FIRE_ASPECT, 255, true);
                meta4.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                meta4.addEnchant(Enchantment.DURABILITY, 255, true);
                meta4.addEnchant(Enchantment.THORNS, 7, true);
                meta4.addEnchant(Enchantment.MENDING, 100, true);
                itemStack4.setItemMeta(meta4);
                inventory.setItem(0, itemStack);
                inventory.setItem(1, itemStack2);
                inventory.setItem(2, itemStack3);
                inventory.setItem(3, itemStack4);
                player.openInventory(inventory);
            } else {
                sender.sendMessage(Main.prefix + "Du musst ein Spieler sein!");
            }
            return false;
        }
        return false;
    }
}

