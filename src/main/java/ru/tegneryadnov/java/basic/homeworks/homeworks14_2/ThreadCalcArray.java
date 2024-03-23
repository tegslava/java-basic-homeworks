package ru.tegneryadnov.java.basic.homeworks.homeworks14_2;

/**
 * Класс, для расчета данных в потоке
 */
public class ThreadCalcArray implements Runnable {
    static CalcArray ca = new CalcArray();
    private final int startPos;
    private int count;
    public Thread thrd;
    private Double[] array;

    private ThreadCalcArray(String name, int startPos, int count, Double[] array) {
        this.count = count;
        this.array = array;
        this.startPos = startPos;
        thrd = new Thread(this, name);
    }

    public synchronized void calcElement(Double[] array, int i) {
        array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }

    public static ThreadCalcArray  startThreadCalcArray(String name, Double[] array, int startPos, int count) {
        ThreadCalcArray threadCA = new ThreadCalcArray(name, startPos, count, array);
        threadCA.thrd.start();
        return threadCA;
    }

    @Override
    public void run() {
        System.out.printf("Начал работу %s\n", thrd.getName());
        long timeStart = System.currentTimeMillis()/1000;
  /*      synchronized (ca) {
            ca.calcElement(array, startPos, count);
        }*/
        long timeStop = System.currentTimeMillis()/1000;
        System.out.printf("%s отработал за %d сек.\n", thrd.getName(), timeStop - timeStart);
    }

    public static  void showArray(Double[] array,int startPos, int count){
        if(startPos > array.length) {
            System.out.println("Неверно задана позиция начала показа");
            return;
        }
        for (int i = startPos; (i < startPos+count)&(i<array.length); i++) {
            System.out.printf("array[%d] = %8f\n", i, array[i]);
        }
    }
}
