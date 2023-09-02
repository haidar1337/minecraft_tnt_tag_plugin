package com.tnttag.tnttag.Manager;

import com.tnttag.tnttag.TNTTag;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class ArenaConfigManager {

    private static File file;
    private static FileConfiguration arenaConfig;


    public static void setupArenaConfig(TNTTag tntTag) {

        if (!tntTag.getDataFolder().exists()) {
            tntTag.getDataFolder().mkdir();
        }

        ArenaConfigManager.file = new File(tntTag.getDataFolder(), "arenas.yml");

        try {
            ArenaConfigManager.arenaConfig.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        ArenaConfigManager.arenaConfig.createSection("arenas.");
        try {
            ArenaConfigManager.arenaConfig.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
