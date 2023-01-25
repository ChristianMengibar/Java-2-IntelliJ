package org.iesfm.transferenciaDatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class WriteToFile implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(WriteToFile.class);

    private Socket socket;
    private File file;

    public WriteToFile(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

                String line;
                while ((line = reader.readLine()).equals(":end")) {
                    writer.write(line + "\n");
                }
            } catch (IOException e) {
                log.error("Error al leer del socket", e);
            }
        } catch (IOException e) {
            log.error("Error al leer del socket", e);
        }
    }
}