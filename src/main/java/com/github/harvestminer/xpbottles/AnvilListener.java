package com.github.harvestminer.xpbottles;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilListener implements Listener
{
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerSneaking(PlayerToggleSneakEvent event) {
        Player p = event.getPlayer();
        if (!event.isSneaking())
            return;

        Location loc = p.getLocation().subtract(0, 1, 0);

        if (loc.getBlock().getType() != Material.ANVIL &&
                loc.getBlock().getType() != Material.CHIPPED_ANVIL &&
                loc.getBlock().getType() != Material.DAMAGED_ANVIL)
            return;

        if (p.getTotalExperience() <= 0) {
            p.sendMessage("§cYou don't have any experience to bottle!");
            return;
        }

        p.giveExp(-7);

        ItemStack bottle = new ItemStack(Material.EXPERIENCE_BOTTLE);

        var leftover = p.getInventory().addItem(bottle);

        if (!leftover.isEmpty())
            p.getWorld().dropItemNaturally(p.getLocation(), bottle);
    }
}
