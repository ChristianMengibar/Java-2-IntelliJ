package org.iesfm.filesearch.Ejercicio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//    1. Haz un programa que:
//        a. Defina una tarea que dado un numero (n) y una frase (word), imprima la frase n veces y espera 1000 milisegundos entre cada print.
//        b. Crea una clase principal que inicie dos threads con dos tareas distinas:
//            i. N= 100, texto= hola
//            ii. N= 50,  texto=adios

public class Task implements Runnable{

    private final static Logger log = LoggerFactory.getLogger(Task.class);

    private String word;
    private long numero;

    public Task(String word, long numero) {
        this.word = word;
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 0; i < numero; i++) {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            log.info(word);
        }

    }
}