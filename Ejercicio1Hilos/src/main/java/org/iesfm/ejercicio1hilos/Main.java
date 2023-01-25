package org.iesfm.ejercicio1hilos;

public class Main {

    //a.	Defina una tarea que dado un numero (n) y una frase (word), imprima la frase n veces y espera 1000 milisegundos entre cada print.
    //b.	Crea una clase principal que inicie dos threads con dos tareas distinas:
    //i.	N= 100, texto= hola
    //ii.	N= 50,  texto=adios

    public static void main(String[] args) {
        //Inicializamos los hilos correspondientes.
        Thread hola = new Thread(new TareaMostrarMensaje("Hola", 100));
        Thread adios = new Thread(new TareaMostrarMensaje("Adios", 50));

        //Ejecutamos los hilos correspondientes.
        hola.start();
        adios.start();
    }
}