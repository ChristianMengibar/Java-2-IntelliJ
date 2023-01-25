package org.iesfm.filesearch.Ejercicio3;

public class Accumulator {
    private int value = 0;

    public synchronized void inc() {
        value++;
        // value = 0
        // 1. Calcular la suma.
        // 2. Asigna el resultado a value.
        // H1 0 + 1 = 1  value = 1
        // H2                        1 + 1 = 2  value = 2
    }

    public int getValue() {
        return value;
    }
}
