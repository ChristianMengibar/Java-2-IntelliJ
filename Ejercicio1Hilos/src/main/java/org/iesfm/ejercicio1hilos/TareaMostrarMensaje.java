package org.iesfm.ejercicio1hilos;

public class TareaMostrarMensaje implements Runnable {

    //Creamos la variable mensaje y contador.
    private String mensaje;
    private int contador;

    //Hacemos el constructor de la variable mensaje y contador.

    public TareaMostrarMensaje(String mensaje, int contador) {
        this.mensaje = mensaje;
        this.contador = contador;
    }

    //Implementamos el metodo.
    @Override
    public void run() {
        //Hacemos el bucle for para que de una vuelta y nos diga el numero de veces que se quiere mostrar
        // lo que le pasemos por pantalla
        for (int i = 0; i < contador; i++) {
            //Hacemos try catch, le decimos lo que queremos mostrar por pantalla que es el mensaje, y le metemos
            // la pausa de 1000 que es lo que nos pide
            try {
                System.out.println(mensaje);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}