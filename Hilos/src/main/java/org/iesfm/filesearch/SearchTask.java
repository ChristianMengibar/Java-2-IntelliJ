package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchTask implements Runnable{

    private final static Logger log = LoggerFactory.getLogger(SearchTask.class);

    private String word;

    public SearchTask(String word) {
        this.word = word;
    }

    @Override
    public void run() {

        log.info("" + Buscador.contador(word));
    }
}
