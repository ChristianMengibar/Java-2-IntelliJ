package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PomReader {

    private static Logger log = LoggerFactory.getLogger(BufferedReadExample.class);

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("pom.xml"))) {
            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line).append("/n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
