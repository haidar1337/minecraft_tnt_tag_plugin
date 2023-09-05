package com.tnttag.tnttag.Manager;

import com.tnttag.tnttag.Instance.Arena;
import com.tnttag.tnttag.TNTTag;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {

    private List<Arena> arenas = new ArrayList<>();

    public ArenaManager(TNTTag main) {

        FileConfiguration config = ArenaConfigManager.getArenaConfig();

        for (String arn : config.getConfigurationSection("arenas.").getKeys(false)) {
            arenas.add(new Arena(main,
                    Integer.parseInt(arn), ArenaConfigManager.getArenaSpawn(arn)));
        }
    }

    public Arena getArena(Player player) {

        for (Arena arena : this.arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;

    }

    public Arena getArena(int id) {
        for (Arena arena : this.arenas) {
            if (arena.getId() == id) {
                return arena;
            }
        }
        return null;

    }


}
