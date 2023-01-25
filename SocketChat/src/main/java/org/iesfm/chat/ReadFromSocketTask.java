package org.iesfm.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadFromSocketTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(ReadFromSocketTask.class);

    private Socket socket;

    public ReadFromSocketTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            log.error("Error al leer del socket", e);
        }
    }
}
