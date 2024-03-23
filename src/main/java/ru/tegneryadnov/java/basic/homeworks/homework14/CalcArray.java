package ru.tegneryadnov.java.basic.homeworks.homework14;


public class CalcArray {
    /**
     * Заполняет массив данными, рассчитанными по заданной формуле
     *
     * @param array массив Double,
     * @param count количество рассчитываемых элементов (count<=array.length)
     * @startPos позиция в массиве, с которой начать заливку данных (0<=startPos< array.length)
     */
    public void calcFillArray(Double[] array, int startPos, int count) {
        for (int i = startPos; i < startPos + count; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            try {
                Thread.sleep(0, 1);
                //wait();
            } catch (InterruptedException e) {
                System.out.printf("Поток %s прерван.", Thread.currentThread().getName());
            }
        }
    }
}
