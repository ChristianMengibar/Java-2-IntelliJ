package org.iesfm.transferenciaDatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private final static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            log.info("Type the file path ");
            String filePathName = scan.nextLine();
            File filePath = new File(filePathName);
            if (filePath.exists()) {
                log.info("The path was found");
                log.info("Type the name of your file");
                String fileName = scan.nextLine();
                File file = new File(filePath + "/" + fileName + ".txt");
                if (file.exists()) {
                    log.info("The file was found");
                    log.info("Launching server.");
                    log.info("waiting for connection...");

                    ServerSocket ss = new ServerSocket(4000);
                    Socket socket = ss.accept();

                    TransferenciaApp transferenciaApp = new TransferenciaApp(socket, file);
                    transferenciaApp.startChatApp();
                } else {
                    log.info("ERROR: The file wasn't found in the path");
                }
            } else {
                log.info("ERROR:The path wasn't found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}