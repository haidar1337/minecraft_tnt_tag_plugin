package com.tnttag.tnttag.Commands;

import com.tnttag.tnttag.Manager.ConfigManager;
import com.tnttag.tnttag.Utility.Util;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ConfigCommand extends Command{


    // config required-players int
    // config explosion-countdown int
    // config countdown int
    // config lobby-spawn (sets to current player location)

    private int number;

    public ConfigCommand() {
        super("config", new String[]{"configure"}, "tnttag.admin", "configuration command");
        this.number = -1;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) return;

        Player player = (Player) sender;

        if (args.length > 0) {
            if (args.length == 2) {
                number = Util.parseInt(args[1]);
            }

            if (args[0].equalsIgnoreCase("required-players") && args.length == 2) {
                if (number == -1 || number <= 1) return;
                try {
                    ConfigManager.setRequiredPlayers(number);
                    player.sendMessage("Required players set to " + number);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (args[0].equalsIgnoreCase("explosion-countdown") && args.length == 2) {
                if (number == -1 || number <= 15) return;
                try {
                    ConfigManager.setExplosionCountdown(number);
                    player.sendMessage("Explosion countdown set to " + number);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (args[0].equalsIgnoreCase("countdown") && args.length == 2) {
                if (number == -1 || number < 15) return;
                try {
                    ConfigManager.setCountdown(number);
                    player.sendMessage("Countdown set to " + number);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (args[0].equalsIgnoreCase("lobby-spawn")) {
                Location location = player.getLocation();
                try {
                    ConfigManager.setLobbySpawn(location);
                    player.sendMessage("Lobby spawn set to current location");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                player.sendMessage("No such command");
            }
        }

    }
}
