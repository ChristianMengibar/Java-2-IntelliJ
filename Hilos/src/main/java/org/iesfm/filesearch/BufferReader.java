package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class BufferReader {
    private final static Logger log = LoggerFactory.getLogger(BufferReader.class);
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        "src/main/resources/el_quijote.txt"
                ))
        ) {
            String line = reader.readLine();
            while (line != null ) {
                log.info(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
