package com.tnttag.tnttag.Utility;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Util {




    public static void saveConfig(FileConfiguration config, File file) throws IOException {
        config.save(file);
    }

    public static int parseInt(String id) {
        int num;

        try {
             num = Integer.parseInt(id);
        } catch (Exception e) {
            return -1;
        }

        return num;
    }
}
