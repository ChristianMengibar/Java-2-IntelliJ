package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {

            Socket socket = new Socket("LocalHost", 4000);

            log.info("Introduce la ruta del fichero de texto: ");

            String path = scan.nextLine();
            File filePath = new File(path);

            if (filePath.exists()) {
                log.info("La ruta es existe.");

                log.info("Introduce el nombre del nuevo archivo: ");
                String file = scan.nextLine();

                File file1 = new File(filePath + "/" + file);

                if (file1.exists()) {
                    log.info("El archivo existe.");
                } else {
                    file1.createNewFile();
                    log.info("El archivo se ha creado correctamente.");

                    Application application = new Application(socket, file1);
                    application.invokeThreads();
                }
            } else {
                log.info("La ruta no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}