package com.nextsap.searchtools.loader;

import com.nextsap.searchtools.SearchTools;
import com.nextsap.searchtools.Settings;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.zip.GZIPInputStream;

public class Loader {

    public static String searchBannedPlayer(String player) throws IOException {
        File logsFolder = new File(SearchTools.getConfigManager().getConfig().getLauncher().getPath());

        if (!logsFolder.isDirectory()) {
            throw new FileNotFoundException(logsFolder.getAbsolutePath());
        }

        File[] files = logsFolder.listFiles();
        Collections.reverse(Arrays.asList(files));

        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }

            boolean compress = file.getName().endsWith(".gz");

            try (InputStream inputStream = new FileInputStream(file);
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(compress ? new GZIPInputStream(inputStream) : inputStream))) {

                String line;



                while ((line = reader.readLine()) != null) {
                    if (line.contains(Settings.getBanPattern())) {
                        // [00:46:18] [Client Thread/INFO]: [CHAT] [Ban] Tu as sanctionné [A-Za-z0-9_]+ \(à vie\)
                        String pseudo = line.split(" ")[8];

                        if (!pseudo.equalsIgnoreCase(player)) continue;

                        String date = file.getName().split("\\.")[0].substring(0, file.getName().split("\\.")[0].length() - 2);

                        if (file.getName().equals("latest.log"))
                            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(file.lastModified()));

                        date = date + " à " + line.split(" ")[0].substring(1).replace("]", "");

                        return "Tu as banni " + player + " le " + date;
                    }
                }
            } catch (EOFException e) {
                System.err.println("Error with file " + file.getName());
                e.printStackTrace();
            }
        }
        return "Tu n'as pas banni " + player;
    }
}
