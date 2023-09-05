package com.tnttag.tnttag.Utility;

import com.tnttag.tnttag.Manager.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Util {




    public static void saveConfig(FileConfiguration config, File file) throws IOException {
        config.save(file);
    }
}
