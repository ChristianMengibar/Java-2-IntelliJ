package org.iesfm.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteToSocket implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(WriteToSocket.class);


    private Socket socket;
    private Scanner scanner;
    private String alias;

    public WriteToSocket(Socket socket, Scanner scanner, String alias) {
        this.socket = socket;
        this.scanner = scanner;
        this.alias = alias;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            String message = null;
            while(!":quit".equals(message)) {
                message = scanner.nextLine();
                writer.println(alias +": " + message);
                writer.flush();
            }
        } catch (IOException e) {
            log.error("Error al enviar mensaje", e);
        }
    }
}
