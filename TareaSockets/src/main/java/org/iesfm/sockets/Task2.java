package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Task2 implements Runnable{

    private final static Logger log = LoggerFactory.getLogger(Task2.class);

    private Socket socket;
    private File file;

    public Task2(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); //true, escribe mas de una linea.
            String line;
            String end = ":end";
            while ((line = reader.readLine()).equals(end)) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
