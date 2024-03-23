package ru.tegneryadnov.java.basic.homeworks.homework14;

import ru.tegneryadnov.java.basic.homeworks.homework14_.FillArrayByFormula;

public class MainApplication {
    private static Double[] array;
    public static void main(String[] args) {
        Double[] array = new Double[60_000_000];
        ThreadsCalcArray.createAndStartThreadsCalc(array, 1);
        System.out.println();
        System.out.println("Для контроля, первые 50 элементов массива:");
        ThreadsCalcArray.showArray(array, 0, 50);
        System.out.println();
        System.out.println("Для контроля, последние 50 элементов массива:");
        ThreadsCalcArray.showArray(array, array.length - 50, 50);
        array = new Double[60_000_000];
        ThreadsCalcArray.createAndStartThreadsCalc(array, 4);
        System.out.println("Для контроля, первые 50 элементов массива:");
        ThreadsCalcArray.showArray(array, 0, 50);
        System.out.println();
        System.out.println("Для контроля, последние 50 элементов массива:");
        ThreadsCalcArray.showArray(array, array.length - 50, 50);
    }
}
