package com.tnttag.tnttag.Instance;

import com.tnttag.tnttag.GameState;
import com.tnttag.tnttag.TNTTag;
import org.bukkit.ChatColor;

public class Game {

    private Arena arena;
    private ExplosionCountdown explosionCountdown;
    private TNTTag main;

    public Game(Arena arena, TNTTag main) {
        this.arena = arena;
        this.main = main;
        this.explosionCountdown = new ExplosionCountdown(main);
    }

    public void start() {
        arena.setState(GameState.STARTED);
        arena.sendMessage(ChatColor.GOLD + "Game has started!");

        // complete game logic
        explosionCountdown.start();



    }

}
