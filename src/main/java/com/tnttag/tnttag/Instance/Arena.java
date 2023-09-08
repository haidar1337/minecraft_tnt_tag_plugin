package com.tnttag.tnttag.Instance;

import com.tnttag.tnttag.GameState;
import com.tnttag.tnttag.Manager.ConfigManager;
import com.tnttag.tnttag.TNTTag;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private int id;
    private Location spawn;

    private List<UUID> players;
    private GameState state;
    private TNTTag main;
    private Game game;
private Countdown countdown;
    public Arena(TNTTag main, int id, Location spawn) {
        this.id = id;
        this.spawn = spawn;
        this.main = main;

        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(main, this);
        this.game = new Game(this, main);
    }


    public void start() {
        game.start();
    }

    public void reset() {
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(main, this);
        game = new Game(this, main);
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(this.getSpawn());

        if (this.getState() == GameState.RECRUITING && players.size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getSpawnLocation());
    }

    public int getId() {
        return id;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public GameState getState() {
        return state;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public World getWorld() {
        return spawn.getWorld();
    }

    public void sendTitle(String title, String subtitle) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendTitle(title, subtitle);
        }
    }
}
