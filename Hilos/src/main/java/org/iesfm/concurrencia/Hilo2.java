package org.iesfm.concurrencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Hilo2 implements Runnable{

    private final static Logger log = LoggerFactory.getLogger(Hilo2.class);

    private String mensajeFinal;
    private Semaphore semaforo;

    public Hilo2(String mensajeFinal, Semaphore semaforo) {
        this.mensajeFinal = mensajeFinal;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire(1);
            System.out.println(mensajeFinal);
            semaforo.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}