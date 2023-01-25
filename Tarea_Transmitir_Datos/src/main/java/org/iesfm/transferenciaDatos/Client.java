package org.iesfm.transferenciaDatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 4000);
            log.info("Type the path where you want to create your file");
            String filePathName = scan.nextLine();
            File filePath = new File(filePathName);
            if (filePath.exists()) {
                log.info("The path was found");
                log.info("Type the name of your new file");
                String fileName = scan.nextLine();
                File file = new File(filePath + "/" + fileName + ".txt");
                if (file.exists()) {
                    log.info("The file already exists");
                } else {
                    file.createNewFile();
                    log.info("Your file has been created");
                    log.info("Launching client...");

                    TransferenciaApp transferenciaApp = new TransferenciaApp(socket, file);
                    transferenciaApp.startChatApp();
                }
            } else {
                log.info("ERROR:The path wasn't found");
            }
        } catch (IOException e) {
            log.error("Error while connection", e);
        }
    }
}