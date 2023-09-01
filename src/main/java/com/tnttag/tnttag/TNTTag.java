package com.tnttag.tnttag;

import com.tnttag.tnttag.Manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class TNTTag extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setupConfig(this);

        try {
            ConfigManager.setCountdown(45);
            ConfigManager.setRequiredPlayers(2);
            ConfigManager.setLobbySpawn(new Location(Bukkit.getWorld("world"), 4, 5, 12, 155.3f, 123.2f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
