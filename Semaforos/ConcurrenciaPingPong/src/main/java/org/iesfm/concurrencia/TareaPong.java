package org.iesfm.concurrencia;

import java.util.concurrent.Semaphore;

public class TareaPong implements Runnable {

    private String mensaje;
    private Semaphore semaforo1;
    private Semaphore semaforo2;

    public TareaPong(String mensaje, Semaphore semaforo1, Semaphore semaforo2) {
        this.mensaje = mensaje;
        this.semaforo1 = semaforo1;
        this.semaforo2 = semaforo2;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                semaforo2.acquire();
                System.out.println(mensaje);
                semaforo1.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}