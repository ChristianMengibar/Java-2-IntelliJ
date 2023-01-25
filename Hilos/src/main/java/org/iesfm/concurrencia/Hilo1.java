package org.iesfm.concurrencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Hilo1 implements Runnable{

    private final static Logger log = LoggerFactory.getLogger(Hilo1.class);

    private Semaphore semaforo;
    private String mensaje1;
    private String mensaje2;

    public Hilo1(Semaphore semaforo, String mensaje1, String mensaje2) {
        this.semaforo = semaforo;
        this.mensaje1 = mensaje1;
        this.mensaje2 = mensaje2;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire(2);
            for (int i = 0; i < 10; i++) {
                System.out.println(mensaje1);
                    Thread.sleep(500);
            }
            semaforo.release(1);

            semaforo.acquire(2);
            for (int i = 0; i < 5; i++) {
                System.out.println(mensaje2);
                Thread.sleep(1000);
            }
            semaforo.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}