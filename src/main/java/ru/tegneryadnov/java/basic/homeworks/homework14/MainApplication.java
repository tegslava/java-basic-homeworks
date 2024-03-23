package ru.tegneryadnov.java.basic.homeworks.homework14;

public class MainApplication {
    public static void main(String[] args) {
        Double[] array = new Double[60_000_000];
        int maxThreadsCount = 1;
        ThreadsCalcArray.test(array, maxThreadsCount);
        array = new Double[60_000_000];
        maxThreadsCount = 4;
        ThreadsCalcArray.test(array, maxThreadsCount);
    }
}
