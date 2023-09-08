package com.tnttag.tnttag.Manager;

import com.tnttag.tnttag.TNTTag;
import com.tnttag.tnttag.Utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Utility;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import sun.security.krb5.Config;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static FileConfiguration config;
    private static File file;

    public static void setupConfig(TNTTag main) {

        main.saveDefaultConfig();
        ConfigManager.config = main.getConfig();
        ConfigManager.file = new File(main.getDataFolder(), "config.yml");
    }


    public static int getCountdown() {
        return ConfigManager.config.getInt("countdown");
    }

    public static int getRequiredPlayers() {
        return ConfigManager.config.getInt("required-players");

    }

    public static int getExplosionCountdown() {
        return ConfigManager.config.getInt("explosion-countdown");
    }


    public static void setExplosionCountdown(int seconds) throws IOException {
        ConfigManager.config.set("explosion-countdown", seconds);
        Util.saveConfig(ConfigManager.config, file);
    }
    public static Location getSpawnLocation() {
        return new Location(Bukkit.getWorld("world"), ConfigManager.config.getDouble("lobby-spawn.x"), ConfigManager.config.getDouble("lobby-spawn.y"), ConfigManager.config.getDouble("lobby-spawn.z"), (float) ConfigManager.config.getDouble("lobby-spawn.yaw"), (float) ConfigManager.config.getDouble("lobby-spawn.pitch"));
    }

    public static void setCountdown(int seconds) throws IOException {
        ConfigManager.config.set("countdown", seconds);
        Util.saveConfig(ConfigManager.config, ConfigManager.file);
    }

    public static void setRequiredPlayers(int playersCount) throws IOException {
        ConfigManager.config.set("required-players", playersCount);
        Util.saveConfig(ConfigManager.config, ConfigManager.file);

    }

    public static void setLobbySpawn(Location location) throws IOException {

        ConfigManager.config.set("lobby-spawn.world", location.getWorld().getName());
        ConfigManager.config.set("lobby-spawn.x", location.getX());
        ConfigManager.config.set("lobby-spawn.y", location.getY());
        ConfigManager.config.set("lobby-spawn.z", location.getZ());
        ConfigManager.config.set("lobby-spawn.yaw", location.getYaw());
        ConfigManager.config.set("lobby-spawn.pitch", location.getPitch());
        Util.saveConfig(ConfigManager.config, ConfigManager.file);
}

}
