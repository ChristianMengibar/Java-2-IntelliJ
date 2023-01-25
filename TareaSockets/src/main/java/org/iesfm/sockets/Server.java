package org.iesfm.sockets;

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
            log.info("Introduce la ruta del fichero de texto: ");

            String path = scan.nextLine();
            File filePath = new File(path);

            if (filePath.exists()) {
                log.info("La ruta es existe.");

                log.info("Introduce el archivo: ");
                String file = scan.nextLine();

                File file1 = new File(filePath + "/" + file);
                if (file1.exists()) {
                    log.info("El archivo existe.");

                    ServerSocket serverSocket = new ServerSocket(4000);
                    Socket socket = serverSocket.accept();

                    Application application = new Application(socket, file1);
                    application.invokeThreads();
                } else {
                    log.info("El archivo no existe.");
                }
            } else {
                log.info("La ruta no se ha encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}