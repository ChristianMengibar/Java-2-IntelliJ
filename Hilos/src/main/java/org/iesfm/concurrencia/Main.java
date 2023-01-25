package org.iesfm.concurrencia;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(2);

        Thread saludo = new Thread(new Hilo1(semaforo, "Hola mundo", "Adios"));
        Thread despedida = new Thread(new Hilo2("Ya ha saludado", semaforo));

        saludo.start();
        despedida.start();

        try {
            saludo.join();
            despedida.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TERMINADO");
    }
}