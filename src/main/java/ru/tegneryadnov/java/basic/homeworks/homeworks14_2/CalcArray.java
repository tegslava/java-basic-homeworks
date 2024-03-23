package ru.tegneryadnov.java.basic.homeworks.homeworks14_2;


public class CalcArray {
    /**
     * Рассчитывает строку массива, по заданной формуле
     * *
     *
     * @param array массив Double
     * @param i     индекс строки
     * @param count
     */
    public synchronized void calcElement(Double[] array, int i, int count) {
        array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
}
