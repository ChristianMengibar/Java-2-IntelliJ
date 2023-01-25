package org.iesfm.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        try {
            log.info("Arrancando cliente...");
            Socket socket = new Socket("localhost", 4000);
            ChatApp app = new ChatApp(socket);
            app.startChatApp();
        } catch (IOException e) {
            log.error("Error al conectarse", e);
        }
    }
}
