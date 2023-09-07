package com.tnttag.tnttag.Instance;

import com.tnttag.tnttag.Manager.ConfigManager;
import com.tnttag.tnttag.TNTTag;
import org.bukkit.scheduler.BukkitRunnable;

public class ExplosionCountdown extends BukkitRunnable {
    // need to get tagged players or PlayerManager
    private TNTTag main;
    private int countdownSeconds;

    public ExplosionCountdown(TNTTag main) {
        this.main = main;
        this.countdownSeconds = ConfigManager.getExplosionCountdown();
    }

    public void start() {

        runTaskTimer(main, 0, 20);

    }



    @Override
    public void run() {
        if (countdownSeconds == 0) {
            cancel();
            // kick tagged players from the arena
            return;
        }

        countdownSeconds--;
    }

}
