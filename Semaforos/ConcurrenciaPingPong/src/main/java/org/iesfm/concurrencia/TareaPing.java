package org.iesfm.concurrencia;

import java.util.concurrent.Semaphore;

public class TareaPing implements Runnable {

    private String mensaje;
    private Semaphore semaforo1;
    private Semaphore semaforo2;

    public TareaPing(String mensaje, Semaphore semaforo1, Semaphore semaforo2) {
        this.mensaje = mensaje;
        this.semaforo1 = semaforo1;
        this.semaforo2 = semaforo2;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                semaforo1.acquire();
                System.out.println(mensaje);
                semaforo2.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}