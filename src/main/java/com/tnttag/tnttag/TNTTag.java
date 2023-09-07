package com.tnttag.tnttag;

import com.tnttag.tnttag.Commands.ArenaCommand;
import com.tnttag.tnttag.Manager.ArenaConfigManager;
import com.tnttag.tnttag.Manager.ArenaManager;
import com.tnttag.tnttag.Manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class TNTTag extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setupConfig(this);
        ArenaConfigManager.setupArenaConfig(this);
        arenaManager = new ArenaManager(this);
        new ArenaCommand(this);

        try {
            // implement commands for those
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

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
