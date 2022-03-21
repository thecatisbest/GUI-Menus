package me.guimenus.guimenus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui implements Listener {
    private Inventory gui;

    public void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.GREEN + "Menu");

        ItemStack item = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "This is a button");
        item.setItemMeta(meta);

        gui.setItem(2,item);

        p.openInventory(gui);

    }

    @EventHandler
    public void guiClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().equals(gui)) {
            return;
        }

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        switch(e.getSlot()) {
            case 2: {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "You clicked the button!");
                break;
            }
        }
    }

    @EventHandler
    public void openGuiEvent(PlayerDropItemEvent e) {
        openNewGui(e.getPlayer());
    }
}
