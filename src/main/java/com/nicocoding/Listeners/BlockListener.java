package com.nicocoding.Listeners;

import com.nicocoding.BetterExplosions;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class BlockListener implements Listener {

    private BetterExplosions main;

    @EventHandler
    public void PlacedTnt(BlockPlaceEvent e) {
        if (main.getConfig().getBoolean("Instantignition") == true) {
            Player p = e.getPlayer();
            if (e.getBlockPlaced().getType() == Material.TNT) {
                e.getBlock().setType(Material.AIR);
                e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
            }


        }
    }
}
