package org.iesfm.filesearch.Ejercicio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CountWordTask implements Runnable {

    private static Logger log = LoggerFactory.getLogger(CountWordTask.class);

    private File file;
    private String word;
    private Occurrences totalOccurrences;

    public CountWordTask(File file, String word, Occurrences occurences) {
        this.file = file;
        this.word = word;
        this.totalOccurrences = occurences;
    }

    @Override
    public void run() {
        FileUtils fileUtils = new FileUtils();
        int fileOccurrences = fileUtils.countTextOccurrences(file, word);
        totalOccurrences.add(fileOccurrences);
        log.info("En el archivo " + file.getName() + " aparece " + fileOccurrences);
    }
}
