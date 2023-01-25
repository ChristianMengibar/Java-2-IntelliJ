package org.iesfm.Frase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
