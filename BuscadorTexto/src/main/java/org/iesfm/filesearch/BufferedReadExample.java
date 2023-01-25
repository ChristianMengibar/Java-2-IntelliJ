package org.iesfm.filesearch;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReadExample {

    private static Logger log = LoggerFactory.getLogger(BufferedReadExample.class);

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/el_quijote.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                log.info(line);
                reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}