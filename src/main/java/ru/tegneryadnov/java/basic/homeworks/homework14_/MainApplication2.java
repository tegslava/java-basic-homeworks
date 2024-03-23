package ru.tegneryadnov.java.basic.homeworks.homework14_;

public class MainApplication2 {
    private static Double[] array;
    private static int startPos;
    private static int count;
    private static final Object m = new Object();

    public static void main(String[] args) {
/*        FillArrayByFormula.createAndStart(1000, 2);
        FillArrayByFormula.showArray(500,999);*/
        Double[] array = new Double[60_000_000];
        startPos = 0;
        count = array.length / 2;

        var t1 = new Thread(() -> {
            System.out.println("Поток 1 стартовал...");
            long timeStart = System.currentTimeMillis() / 1000;
            for (int i = 0; i < 15_000_000; i++) {
                synchronized (CalcElement.class) {
                    CalcElement.calcNS(array, i);
                }
            }
            long timeStop = System.currentTimeMillis() / 1000;
            System.out.printf("Поток 1 отработал за %d сек\n", (timeStop - timeStart));
        });

        startPos = count;
        //count = 50;
        var t2 = new Thread(() -> {
            System.out.println("Поток 2 стартовал...");
            long timeStart = System.currentTimeMillis() / 1000;
            for (int i = 15_000_000; i < 30_000_000; i++) {
                synchronized (CalcElement.class) {
                    CalcElement.calcNS(array, i);
                }
            }
            long timeStop = System.currentTimeMillis() / 1000;
            System.out.printf("Поток 2 отработал за %d сек\n", (timeStop - timeStart));
        });

        var t3 = new Thread(() -> {
            System.out.println("Поток 3 стартовал...");
            long timeStart = System.currentTimeMillis() / 1000;
            for (int i = 30_000_000; i < 40_000_000; i++) {
                synchronized (CalcElement.class) {
                    CalcElement.calcNS(array, i);
                }
            }
            long timeStop = System.currentTimeMillis() / 1000;
            System.out.printf("Поток 3 отработал за %d сек\n", (timeStop - timeStart));
        });

        var t4 = new Thread(() -> {
            System.out.println("Поток 4 стартовал...");
            long timeStart = System.currentTimeMillis() / 1000;
            for (int i = 45_000_000; i < 60_000_000; i++) {
                synchronized (CalcElement.class) {
                    CalcElement.calcNS(array, i);
                }
            }
            long timeStop = System.currentTimeMillis() / 1000;
            System.out.printf("Поток 4 отработал за %d сек\n", (timeStop - timeStart));
        });

        try {
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        FillArrayByFormula.showArray(array, 0,50);
        FillArrayByFormula.showArray(array, array.length -50,50);
    }
}
