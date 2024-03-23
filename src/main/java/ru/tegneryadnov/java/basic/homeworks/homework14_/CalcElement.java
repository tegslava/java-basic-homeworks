package ru.tegneryadnov.java.basic.homeworks.homework14_;

/**
 *
 */
public class CalcElement {
    public static synchronized void calc(Double[] array, int i) {
        array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
    public static void calcNS(Double[] array, int i) {
        array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }

}
