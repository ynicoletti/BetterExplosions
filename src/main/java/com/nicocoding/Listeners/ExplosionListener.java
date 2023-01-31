package com.nicocoding.Listeners;

import com.nicocoding.BetterExplosions;
import com.nicocoding.ExplosionMethods;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class ExplosionListener implements Listener {

    private BetterExplosions main;

    public ExplosionListener(BetterExplosions main) {
        this.main = main;
    }

    @EventHandler
    public void FlyingBlocksExplosion(EntityExplodeEvent e) {
        if (main.getConfig().getBoolean("Launchfirework") == true) {
            main.getExplosionMethods().LaunchFirework(e.blockList().get(1));
        }
        for (Block b : e.blockList()) {
            float x = (float) -3 + (float) (Math.random() * ((3 - -3) + 1));
            float y = (float) -2 + (float) (Math.random() * ((2 - -2) + 1));
            float z = (float) -3 + (float) (Math.random() * ((3 - -3) + 1));

            FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
            fb.setDropItem(false);
            fb.setVelocity(new Vector(x, y, z));
            if (b.getType() != Material.TNT) {
                b.setType(Material.AIR);
            }
        }
    }
}
