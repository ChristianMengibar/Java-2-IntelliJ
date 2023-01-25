package org.iesfm.multithreading;

public class Main {
    public static void main(String[] args) {
        Runnable holas = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println("Hola");
                    try {
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        Runnable adios = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println("adios");
                    try {
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        Thread holasThread = new Thread(holas);
        Thread adiosThread = new Thread(adios);
        holasThread.start();
        adiosThread.start();
    }
}
