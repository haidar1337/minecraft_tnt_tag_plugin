package com.tnttag.tnttag.Manager;

import com.tnttag.tnttag.Arena;
import com.tnttag.tnttag.GameState;
import org.bukkit.ChatColor;

public class Game {

    private Arena arena;

    public Game(Arena arena) {
        this.arena = arena;
    }

    public void start() {
        arena.setState(GameState.STARTED);
        arena.sendMessage(ChatColor.GOLD + "Game has started!");

        // complete game logic

    }

}
