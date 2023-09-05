package com.tnttag.tnttag.Instance;

import com.tnttag.tnttag.GameState;
import com.tnttag.tnttag.Manager.ConfigManager;
import com.tnttag.tnttag.TNTTag;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private TNTTag main;
    private Arena arena;
    private int countdownSeconds;

    public Countdown(TNTTag main, Arena arena) {
        this.main = main;
        this.arena = arena;
        this.countdownSeconds = ConfigManager.getCountdown();
    }

    public void start() {
        arena.setState(GameState.COUNTDOWN);
        runTaskTimer(main, 0, 20);
    }


    @Override
    public void run() {
        if (countdownSeconds == 0) {
            cancel();
            arena.start();
            return;
        }

        if (countdownSeconds <= 10 || countdownSeconds % 10 == 0) {
            arena.sendMessage(ChatColor.BLUE + "The game will start in " + countdownSeconds + "second" + (countdownSeconds == 1 ? "" : 's'));
        }
    }
}
