package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TextFinder {

    private static Logger log = LoggerFactory.getLogger(BufferedReadExample.class);

    public static int Find(String text) throws IOException {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/el_quijote.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(text)) {
                    counter++;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            log.error("", e);
        }
        return counter;
    }
}