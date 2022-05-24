package com.sqldata.testplugin;

import com.sqldata.testplugin.glass.GlassHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new GlassHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
