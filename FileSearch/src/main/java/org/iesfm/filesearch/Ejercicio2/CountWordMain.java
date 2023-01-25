package org.iesfm.filesearch.Ejercicio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//    2. Haz un programa que usando FileUtils
//        a. Pida al usuario un directorio
//        b. Pida al usuario un texto a buscar
//        c. Por cada archivo en el directorio, crea una tarea que calcule el número de lineas en las que aparece el texto.
//        d. Al final suma todos las coincidencias de la búsqueda.

public class CountWordMain {

    private static Logger log = LoggerFactory.getLogger(CountWordMain.class);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Introduce un directorio");
        String folderPath = scanner.nextLine();
        log.info("Introduce una palabra a buscar");
        String word = scanner.nextLine();

        File folder = new File(folderPath);

        // Se cargan los archivos que cuelgan del directorio
        File[] files = folder.listFiles();
        // Por cada archivo se lanza un hilo que busca el texto en ese archivo
        List<Thread> threads = new LinkedList<>();
        // Este objeto va a ser usado por TODOS los hilos para guardar los resultados
        Occurrences occurrences = new Occurrences();
        // ARRANCAMOS LOS HILOS
        for (File file : files) {
            // Se crea la tarea que busca en el archivo file el texto word
            CountWordTask countWordTask = new CountWordTask(file, word, occurrences);
            // Creamos el thread asignándole la tarea
            Thread countWordThread = new Thread(countWordTask);
            // Arrancamos el thread
            countWordThread.start();
            threads.add(countWordThread);
        }
        // ESPERAMOS A QUE TODOS LOS HILOS HAYAN ACABADO
        for(Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("La palabra " + word +" aparece " + occurrences.getOccurrenes());
    }
}