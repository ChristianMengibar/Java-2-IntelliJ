package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Task1 implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(Task1.class);

    private Socket socket;
    private File file;

    public Task1(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                printWriter.println(line);
                printWriter.flush();
            }
            printWriter.println(":end");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}