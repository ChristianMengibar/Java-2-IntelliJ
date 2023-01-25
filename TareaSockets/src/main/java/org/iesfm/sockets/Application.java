package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.Socket;

public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    private Socket socket;
    private File file;

    public Application(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    public void invokeThreads () {
        Thread thread1 = new Thread(new Task1(socket, file));
        Thread thread2 = new Thread(new Task2(socket, file));

        thread1.start();
        thread2.start();
    }
}