package com.nextsap.searchtools.utils;

public enum Launcher {
    AZLAUNCHER("AzLauncher","\\AppData\\Roaming\\.az-client\\logs\\"),
    BADLION("BadlionClient","\\AppData\\Roaming\\.minecraft\\logs\\blclient\\minecraft\\"),
    LUNAR("LunarClient","\\.lunarclient\\offline\\multiver\\logs\\"),
    MINECRAFT("Minecraft","\\AppData\\Roaming\\.minecraft\\logs\\");

    private final String name;
    private final String path;

    Launcher(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return System.getProperty("user.home") + path;
    }

    public static Launcher fromName(String name) {
        for (Launcher launcher : Launcher.values()) {
            if (launcher.name.equalsIgnoreCase(name)) {
                return launcher;
            }
        }
        return null;
    }
}
