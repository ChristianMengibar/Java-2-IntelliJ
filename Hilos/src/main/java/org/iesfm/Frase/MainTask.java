package org.iesfm.Frase;

public class MainTask {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("hola" , 10));
        t1.start();
        Thread t2 = new Thread(new Task("adios" , 10));
        t2.start();
    }
}
