package ru.tegneryadnov.java.basic.homeworks.homeworks14_2;

public class MainApplication {
    public static void main(String[] args) {
        boolean arraFree = true;
        int size = 100_000;
        int count = size/4;
        int startPos = 0;
        Double[] array = new Double[size];
        ThreadCalcArray threadCalcArray1 = ThreadCalcArray.startThreadCalcArray("Поток #1", array, startPos, count);
        ThreadCalcArray threadCalcArray2 = ThreadCalcArray.startThreadCalcArray("Поток #2", array, startPos+count, count);
        ThreadCalcArray threadCalcArray3 = ThreadCalcArray.startThreadCalcArray("Поток #3", array, startPos+2*count, count);
        ThreadCalcArray threadCalcArray4 = ThreadCalcArray.startThreadCalcArray("Поток #4", array, startPos+3*count, count);
        try {
            threadCalcArray3.thrd.join();
            threadCalcArray4.thrd.join();
            threadCalcArray1.thrd.join();
            threadCalcArray2.thrd.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //ThreadCalcArray.showArray(array, startPos, count);
        //ThreadCalcArray.showArray(array, startPos+count, count);
        //ThreadCalcArray.showArray(array, startPos+2*count, count);
        //ThreadCalcArray.showArray(array, startPos+3*count, count);
    }
}
