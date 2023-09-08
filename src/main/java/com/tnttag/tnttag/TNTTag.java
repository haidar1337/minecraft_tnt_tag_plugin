package com.tnttag.tnttag;

import com.tnttag.tnttag.Commands.ArenaCommand;
import com.tnttag.tnttag.Commands.ConfigCommand;
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
        new ConfigCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
