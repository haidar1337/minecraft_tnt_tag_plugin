package com.tnttag.tnttag.Commands;

import com.tnttag.tnttag.Manager.ArenaConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ArenaCommand extends Command{


    // arena create id
    // arena delete id
    // arena list
    // arena join id
    // arena leave
    //

    public ArenaCommand() {
        super("arena", new String[]{"arn"}, "none", "arena commands");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            return;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            if (args[0].equalsIgnoreCase("create") && args[1] != null) {

                try {
                    Integer.parseInt(args[1]);
                } catch (Exception e) {
                    player.sendMessage("Invalid id");
                    return;
                }
                try {
                    ArenaConfigManager.createArena(Integer.parseInt(args[1]), Bukkit.getWorld(player.getUniqueId()).getName(), player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                player.sendMessage("Succesfully created arena with " + args[1]);
            } else if (args[0].equalsIgnoreCase("delete")) {

            } else if (args[0].equalsIgnoreCase("list")) {

            } else if (args[0].equalsIgnoreCase("join")) {

            } else if (args[0].equalsIgnoreCase("leave")) {

            } else {
                //sendmessage
            }
        }

    }
}
