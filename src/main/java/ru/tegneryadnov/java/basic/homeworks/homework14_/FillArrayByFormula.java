package ru.tegneryadnov.java.basic.homeworks.homework14_;

import java.util.ArrayList;
import java.util.List;

public class FillArrayByFormula {
    private static Double[] array;
    private int numberOfThreads;
    private final String defaultName = "Поток #";
    private int startPos;
    private int count;
    public List<Thread> thrds;

    private List<Thread> getArrayOfThreads() {
        List<Thread> thrds = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            startPos = startPos + count * i;
            thrds.add(
                    new Thread(() -> {
                        System.out.printf("Начал работу %s\n", Thread.currentThread().getName());
                        long timeStart = System.currentTimeMillis() / 1000;
                        for (int j = startPos; j < startPos + count; j++) {
                            CalcElement.calc(array, j);
                        }
                        long timeStop = System.currentTimeMillis() / 1000;
                        System.out.printf("%s отработал за %d сек.\n", Thread.currentThread().getName(), timeStop - timeStart);
                    }, defaultName + i + 1)
            );
        }
        return thrds;
    }

    public FillArrayByFormula(Double[] array, int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.array = array;
        count = array.length / numberOfThreads;
        thrds = getArrayOfThreads();
    }

    public static FillArrayByFormula createAndStart(int size, int numberOfThreads) {
        FillArrayByFormula fillArrayByFormula = new FillArrayByFormula(new Double[size], numberOfThreads);
        //System.out.printf("Начал работу %s\n", t.getName());
        fillArrayByFormula.thrds.forEach(Thread::start);
        return fillArrayByFormula;
    }

    public static void showArray(/*Double[] array,*/ int startPos, int count) {
/*        if(startPos > array.length) {
            System.out.println("Неверно задана позиция начала показа");
            return;
        }*/
        for (int i = startPos; (i < startPos + count) & (i < array.length); i++) {
            System.out.printf("array[%d] = %8f\n", i, array[i]);
        }
    }

    public static void showArray(Double[] array, int startPos, int count) {
/*        if(startPos > array.length) {
            System.out.println("Неверно задана позиция начала показа");
            return;
        }*/
        for (int i = startPos; (i < startPos + count) & (i < array.length); i++) {
            System.out.printf("array[%d] = %8f\n", i, array[i]);
        }
    }
}
