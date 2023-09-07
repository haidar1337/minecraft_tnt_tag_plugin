package com.tnttag.tnttag.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerHitListener implements Listener {

    // Do game logic here

    public void onPlayerHit(PlayerInteractEvent e) {

        if (e.getAction().isRightClick()) return;



    }
}
