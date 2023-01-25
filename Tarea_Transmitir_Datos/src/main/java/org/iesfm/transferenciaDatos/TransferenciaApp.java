package org.iesfm.transferenciaDatos;

import java.io.File;
import java.net.Socket;


public class TransferenciaApp {

    private Socket socket;
    private File file;

    public TransferenciaApp(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    public void startChatApp() {

        Thread readThread = new Thread(new WriteToSocket(socket, file));
        Thread writeThread = new Thread(new WriteToFile(socket, file));

        readThread.start();
        writeThread.start();
    }
}