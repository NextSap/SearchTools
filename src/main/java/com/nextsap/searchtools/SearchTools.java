package com.nextsap.searchtools;

import com.nextsap.searchtools.config.ConfigManager;
import com.nextsap.searchtools.graphics.frames.DefaultFrame;
import com.nextsap.searchtools.intializer.Initializer;

public class SearchTools {

    private static ConfigManager configManager;

    public static void main(String[] args) {
        boolean setup = new Initializer().initialize();
        if (!setup) System.exit(0);

        configManager = new ConfigManager();

        DefaultFrame frame = new DefaultFrame();
        frame.show();

        if(!configManager.getConfig().isConfig()){
            configManager.askConfig(frame);
            configManager.getConfig().setConfig(true);
            configManager.update();
        }
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
