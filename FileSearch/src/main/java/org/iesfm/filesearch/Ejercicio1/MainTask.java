package org.iesfm.filesearch.Ejercicio1;

public class MainTask {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("hola" , 100));
        t1.start();
        Thread t2 = new Thread(new Task("adios" , 50));
        t2.start();
    }
}