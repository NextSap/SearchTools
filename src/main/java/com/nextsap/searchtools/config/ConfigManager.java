package com.nextsap.searchtools.config;

import com.nextsap.searchtools.SearchTools;
import com.nextsap.searchtools.Settings;
import com.nextsap.searchtools.graphics.FrameManager;
import com.nextsap.searchtools.utils.Launcher;
import com.nextsap.searchtools.utils.Serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * A class to manage config
 */
public class ConfigManager {

    // Define attribute
    private CustomConfig config;

    /**
     * {@link ConfigManager} constructor
     */
    public ConfigManager() {
        getConfigFromFile();
    }

    /**
     * Update the config
     */
    public void update() {
        try {
            FileWriter myWriter = new FileWriter(Settings.getConfigPath());
            myWriter.write(Serializer.serialize(this.config));
            myWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the config from the file
     */
    public void getConfigFromFile() {
        try {
            File file = new File(Settings.getConfigPath());
            Scanner scanner = new Scanner(file);
            String content = null;
            while (scanner.hasNextLine())
                content = scanner.nextLine();

            if (content == null) {
                this.config = new CustomConfig();
                return;
            }

            this.config = (CustomConfig) Serializer.deserialize(content, CustomConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.config = new CustomConfig();
        }
    }

    public void askConfig(FrameManager frameManager) {
        Launcher launcher = null;

        while (launcher == null) {
            launcher = Launcher.fromName(frameManager.showAskLauncherDialog(Settings.getConfigName(), Settings.getAskLauncherMessage()));
            if (launcher == null) {
                frameManager.showErrorDialog(Settings.getConfigName(), Settings.getErrorLauncherMessage());
            }
        }

        SearchTools.getConfigManager().getConfig().setLauncher(launcher);
        SearchTools.getConfigManager().update();
    }

    public CustomConfig getConfig() {
        return config;
    }
}
