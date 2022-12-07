package com.nextsap.searchtools;

import java.awt.*;

public class Settings {

    public static String getConfigPath() {
        return System.getProperty("user.home") + "\\AppData\\Roaming\\.searchtools\\Config.txt";
    }

    public static String getFolderPath() {
        return System.getProperty("user.home") + "\\AppData\\Roaming\\.searchtools\\";
    }

    public static String getImagePath() {
        return System.getProperty("user.home") + "\\AppData\\Roaming\\.searchtools\\image.png";
    }

    public static String getIconPath() {
        return System.getProperty("user.home") + "\\AppData\\Roaming\\.searchtools\\icon.png";
    }

    public static String getVersion() {
        return " Version 1 ";
    }

    public static String getDefaultFrameName(){
        return "SearchTools";
    }

    public static String getBanPattern() {
        return " [CHAT] [Ban] Tu as sanctionn";
    }

    public static String getConfigName() {
        return "Configuration...";
    }

    public static Color getBackgroundColor() {
        return new Color(123, 123, 123);
    }

    public static String getErrorLauncherMessage() {
        return "Erreur: Vous devez choisir un launcher";
    }

    public static String getAskLauncherMessage(){
        return "Choisissez le launcher que vous utilisez :";
    }

    public static String getResponseTitle(){
        return "Résultat";
    }

    public static String getError() {
        return "Erreur";
    }

    public static String getErrorLengthPseudoMessage(){
        return "La longueur du pseudo doit être comprise entre 3 et 16";
    }

    public static String getEnterPseudo(){
        return "Entrez un pseudo :";
    }
}
