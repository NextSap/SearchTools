package com.nextsap.searchtools.intializer;

import com.nextsap.searchtools.Settings;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/*
    The initializer class
 */
public class Initializer {

    /**
     * {@link Initializer} constructor
     *
     * @return {@link Boolean} initialized or not
     */
    public boolean initialize() {
        try {
            createFolder();
            createFile();
            downloadImage();
            downloadIcon();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Create data files of the program
     */
    private void createFile() {
        try {
            File config = new File(Settings.getConfigPath());

            if (!config.exists()) {
                config.createNewFile();
                System.out.println("Le fichier 'Config.txt' a bien été créé.");
            } else
                System.out.println("Le fichier 'Config.txt' existe déjà.");

        } catch (Exception e) {
            System.out.println("Une erreur est survenue : ");
            e.printStackTrace();
        }
    }

    /**
     * Create the folder of the program
     */
    private void createFolder() {
        File file = new File(Settings.getFolderPath());

        if (!file.exists()) {
            file.mkdir();
            System.out.println("Le répertoire a bien été créé.");
            return;
        }

        System.out.println("Le répertoire existe déjà.");
    }

    /**
     * Download the image from the web
     */
    private void downloadImage() {
        File file = new File(Settings.getImagePath());
        if (!file.exists()) {
            try {
                URL url = new URL("https://nextsap.s-ul.eu/EiRVGBxI");
                FileOutputStream fos = new FileOutputStream(Settings.getImagePath());
                fos.write(getByteFromURL(url));
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Download the icon from the web
     */
    private void downloadIcon() {
        File file = new File(Settings.getIconPath());
        if (!file.exists()) {
            try {
                URL url = new URL("https://nextsap.s-ul.eu/y0HxJ2yU");
                FileOutputStream fos = new FileOutputStream(Settings.getIconPath());
                fos.write(getByteFromURL(url));
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] getByteFromURL(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "NING/1.0");
        InputStream bufferedReader = new BufferedInputStream(urlConnection.getInputStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n;
        while (-1 != (n = bufferedReader.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        bufferedReader.close();
        return out.toByteArray();
    }
}
