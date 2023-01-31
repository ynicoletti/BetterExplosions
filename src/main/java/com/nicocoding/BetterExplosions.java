package com.nicocoding;

import com.nicocoding.Listeners.BlockListener;
import com.nicocoding.Listeners.ExplosionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterExplosions extends JavaPlugin {


    /*

    DONE: Blocks flying around , tnt instant ignition, firework on explosion

Maybe to do:
1. Create random effects for explosions such as rain, snow, lightning, and fog.
2. Add a special crafting recipe for a creeper head that creates a bigger explosion with more force.
3. Introduce special blocks that can only be destroyed by explosions, such as obsidian.
4. Create a power-up system where players can collect items to enhance their explosions.
5. Add a potion effect when a player is close to an explosion.
6. Introduce a new type of TNT that can only be detonated by a certain item.
7. Allow players to set up their own TNT traps with custom triggers and effects.
8. Create a new type of TNT that has a random effect when it explodes.
9. Add a 'ground shake' effect when an explosion occurs.
10. Give players the ability to craft their own special firework rockets.
     */

    private ExplosionMethods em;
    private ExplosionListener explistener;

    @Override
    public void onEnable() {

        //config genereren
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        //Registreer events
        Bukkit.getPluginManager().registerEvents(new ExplosionListener(this),this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(),this);


        //Registreren van anderen classes

        em = new ExplosionMethods(this);
        explistener = new ExplosionListener(this);

    }

    public ExplosionMethods getExplosionMethods() { return em;}
    public ExplosionListener getExplosionListener() {return explistener;}


}
