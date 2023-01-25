package org.iesfm.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        try {
            log.info("Arrancando servidor.");
            ServerSocket ss = new ServerSocket(4000);
            log.info("Esperando conexión...");
            Socket socket = ss.accept();
            ChatApp app = new ChatApp(socket);
            app.startChatApp();
        } catch (BindException e) {
            log.error("El puerto 4000 ya está en uso", e);
        } catch (IOException e) {
            log.error("Error inesperado", e);
        }
    }
}
