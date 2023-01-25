package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Scanner;

public class Main {


    public static Scanner sc = new Scanner(System.in);
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("¿que palabra quieres buscar?");
        while(sc.hasNext()) {
            String word = sc.nextLine();
            if(word.equals("exit")) {
                break;
            }
            SearchTask task = new SearchTask(word);
            Thread palabra = new Thread(task);
            palabra.start();
        }

    }
    

}
