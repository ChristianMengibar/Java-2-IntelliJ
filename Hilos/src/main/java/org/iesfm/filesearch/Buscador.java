package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Buscador {
    private final static Logger log = LoggerFactory.getLogger(Buscador.class);


    public static int contador(String palabra) {
        int cuenta = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        "src/main/resources/el_quijote.txt"
                ))
        ) {
            String linea = reader.readLine();
            while (linea != null) {
                if (linea.contains(palabra)) {
                    cuenta++;
                }
                linea = reader.readLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return cuenta;
    }

}
