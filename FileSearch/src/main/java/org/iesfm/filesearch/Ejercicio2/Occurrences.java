package org.iesfm.filesearch.Ejercicio2;

public class Occurrences {
    private int occurrenes;

    public Occurrences() {
        this.occurrenes = 0;
    }

    public void add(int n) {
        occurrenes += n;
    }

    public int getOccurrenes() {
        return occurrenes;
    }
}
