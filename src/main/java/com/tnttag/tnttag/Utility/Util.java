package com.tnttag.tnttag.Utility;

import com.tnttag.tnttag.Manager.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Util {




    public static void saveConfig(FileConfiguration config, File file) throws IOException {
        config.save(file);
    }

    public static int parseId(String id) {
        int newId;

        try {
             newId = Integer.parseInt(id);
        } catch (Exception e) {
            return -1;
        }

        return newId;
    }
}
