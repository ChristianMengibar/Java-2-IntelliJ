package org.iesfm.transferenciaDatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class WriteToSocket implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(WriteToSocket.class);

    private Socket socket;
    private File file;

    public WriteToSocket(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                    writer.flush();
                }
                writer.println(":end");
                writer.flush();
            } catch (IOException e) {
                log.error("Error al enviar mensaje", e);
            }
        } catch (IOException e) {
            log.error("Error al enviar mensaje", e);
        }
    }
}