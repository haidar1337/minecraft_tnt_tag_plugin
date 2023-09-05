package com.tnttag.tnttag.Manager;

import com.tnttag.tnttag.TNTTag;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
            ArenaConfigManager.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        arenaConfig = YamlConfiguration.loadConfiguration(file);

        System.out.println(arenaConfig.getConfigurationSection("arenas."));

        if (arenaConfig.getConfigurationSection("arenas.") == null) {
            arenaConfig.createSection("arenas");
        }

        try {
            ArenaConfigManager.arenaConfig.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileConfiguration getArenaConfig() {
        return arenaConfig;
    }

    public static void createArena(int id, String world, double x, double y, double z, float yaw, float pitch) {
        arenaConfig.createSection("arenas." + id);
        arenaConfig.set("arenas." + id, id);
        arenaConfig.set("arenas." + id + ".world", world);
        arenaConfig.set("arenas." + id + ".x", x);
        arenaConfig.set("arenas." + id + ".y", y);
        arenaConfig.set("arenas." + id + ".z", z);
        arenaConfig.set("arenas." + id + ".yaw", yaw);
        arenaConfig.set("arenas." + id + ".pitch", pitch);

    }

    public static void deleteArena(int id) {
        arenaConfig.set("arenas." + id, null);
    }
}
