package com.nicocoding;

import com.nicocoding.Listeners.BlockListener;
import com.nicocoding.Listeners.ExplosionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterExplosions extends JavaPlugin {

    private ExplosionMethods em;
    private ExplosionListener explistener;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ExplosionListener(this),this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(),this);


        //Registreren van anderen classes

        em = new ExplosionMethods(this);
        explistener = new ExplosionListener(this);

    }

    public ExplosionMethods getExplosionMethods() { return em;}
    public ExplosionListener getExplosionListener() {return explistener;}


}
