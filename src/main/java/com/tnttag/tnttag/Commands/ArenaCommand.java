package com.tnttag.tnttag.Commands;

import com.tnttag.tnttag.Instance.Arena;
import com.tnttag.tnttag.Manager.ArenaConfigManager;
import com.tnttag.tnttag.Manager.ArenaManager;
import com.tnttag.tnttag.TNTTag;
import com.tnttag.tnttag.Utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ArenaCommand extends Command{

    private TNTTag main;
    private int id;

    // arena create id
    // arena delete id
    // arena list
    // arena join id
    // arena leave
    //

    public ArenaCommand(TNTTag main) {
        super("arena", new String[]{"arn"}, "none", "arena commands");
        this.main = main;
        this.id = -1;
    }


    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            return;
        }

        Player player = (Player) sender;

        if (args.length != 0) {
            if (args.length == 2) {
                this.id = Util.parseInt(args[1]);
            }
            if (args[0].equalsIgnoreCase("create") && args.length == 2) {

                if (id == -1 || id <= 0) return;

                if (main.getArenaManager().getArena(id) != null) {
                    player.sendMessage("There already exists an arena with id " + id);
                }

                try {
                    Location spawn = new Location(Bukkit.getWorld(player.getLocation().getWorld().getName()), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                    Arena arena = new Arena(main, id, spawn);
                    ArenaConfigManager.createArena(arena);
                    ArenaManager.addArena(arena);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                player.sendMessage("Succesfully created arena with " + id);
            } else if (args[0].equalsIgnoreCase("delete") && args.length == 2) {

                    if (main.getArenaManager().getArena(id) != null) {
                        try {
                            ArenaConfigManager.deleteArena(id);
                            ArenaManager.deleteArena(main.getArenaManager().getArena(id));
                            player.sendMessage("Successfully deleted arena");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        player.sendMessage("No arena with id " + id);
                }

            } else if (args[0].equalsIgnoreCase("list")) {
                for (Arena arena : main.getArenaManager().getArenas()) {
                    player.sendMessage("Arena " + arena.getId());
                }
            } else if (args[0].equalsIgnoreCase("join")) {
                if (main.getArenaManager().getArena(id) != null) {
                    main.getArenaManager().getArena(id).addPlayer(player);
                } else {
                    player.sendMessage("No arena with id " + id);
                }
            } else if (args[0].equalsIgnoreCase("leave")) {
                for (Arena arena : main.getArenaManager().getArenas()) {
                    if (arena.getPlayers().contains(player.getUniqueId())) {
                        arena.removePlayer(player);
                        player.sendMessage("Left arena");
                        return;
                    }
                }
            } else {
                player.sendMessage("invalid usage");
            }
        }

    }
}
