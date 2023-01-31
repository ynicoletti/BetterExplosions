package com.nicocoding;

import com.nicocoding.Listeners.ExplosionListener;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class ExplosionMethods {

   private BetterExplosions main;

   public ExplosionMethods (BetterExplosions main) {
       this.main = main;
   }


   public void LaunchFirework (Block b) {
       Firework fw = b.getWorld().spawn(b.getLocation(), Firework.class);
       FireworkMeta fwmeta = fw.getFireworkMeta();
       fwmeta.addEffect(FireworkEffect.builder()
               .withColor(Color.SILVER)
               .withColor(Color.RED)
               .with(FireworkEffect.Type.BALL_LARGE)
               .trail(true)
               .build());

       fwmeta.setPower(1);
       fw.setFireworkMeta(fwmeta);
   }
}
