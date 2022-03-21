package me.guimenus.guimenus;

import org.bukkit.plugin.java.JavaPlugin;

public final class Guimenus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Gui(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
