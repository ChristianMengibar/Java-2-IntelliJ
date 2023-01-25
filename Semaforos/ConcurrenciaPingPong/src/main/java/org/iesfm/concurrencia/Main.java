package org.iesfm.concurrencia;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore pingSemaphore = new Semaphore(2);
        Semaphore pongSemaphore = new Semaphore(1);

        Thread mensaje = new Thread(new TareaPing("ping", pingSemaphore, pongSemaphore));
        Thread semaforo = new Thread(new TareaPong("pong", pingSemaphore, pongSemaphore));

        try {
            pongSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mensaje.start();
        semaforo.start();

        try {
            pingSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}