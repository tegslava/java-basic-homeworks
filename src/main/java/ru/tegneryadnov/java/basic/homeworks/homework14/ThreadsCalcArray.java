package ru.tegneryadnov.java.basic.homeworks.homework14;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, для расчета и заливки данных в массив, в потоках
 */
public class ThreadsCalcArray {
    private final List<Thread> thrds;

    /**
     * Порождает заданное количество потоков для расчета
     *
     * @param dArray        массив Double для хранения расчитанных данных
     * @param threadsCount количество потоков
     * @return возвращает список потоков, готовых к расчету
     */
    private List<Thread> getThreadsList(Double[] dArray, int threadsCount) {
        List<Thread> thrds = new ArrayList<>();
        int count = dArray.length / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            int startPos = count * i;
            String defaultName = "Поток #";
            thrds.add(
                    new Thread(() -> {
                        System.out.printf("Начал работу %s\n", Thread.currentThread().getName());
                        long timeStart = System.currentTimeMillis() / 1000;
                        for (int j = startPos; j < startPos + count; j++) {
                            synchronized (ThreadsCalcArray.class) {
                                dArray[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                            }
                        }
                        long timeStop = System.currentTimeMillis() / 1000;
                        System.out.printf("%s отработал за %d сек.\n", Thread.currentThread().getName(), timeStop - timeStart);
                    }, defaultName + (i + 1))
            );
        }
        return thrds;
    }

    private ThreadsCalcArray(Double[] array, int threadsCount) {
        thrds = getThreadsList(array, threadsCount);
    }

    /**
     * Создает и запускает потоки на расчет
     *
     * @param dArray        массив Double
     * @param threadsCount количество запускаемых потоков
     */
    public static void createAndStartThreadsCalc(Double[] dArray, int threadsCount) {
        ThreadsCalcArray threadCA = new ThreadsCalcArray(dArray, threadsCount);
        threadCA.thrds.forEach(Thread::start);
        threadCA.thrds.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Показывает содержимое массива
     *
     * @param dArray    массив Double
     * @param startPos позиция начала показа
     * @param count    количество отображаемых документов
     */
    public static void showArray(Double[] dArray, int startPos, int count) {
        for (int i = startPos; (i < startPos + count) && (i < dArray.length); i++) {
            System.out.printf("array[%d] = %9.6f\n", i, dArray[i]);
        }
    }

    /**
     * Для теста посчитаем массив в maxThreadsCount потоках, выведем первые 50 и последние 50
     * рассчитанных элемента
     *
     * @param dArray   входящий массив Double
     * @param maxThreadsCount количество потоков для теста
     */
    public static void test(Double[] dArray, int maxThreadsCount) {
        ThreadsCalcArray.createAndStartThreadsCalc(dArray, maxThreadsCount);
        System.out.println();
        System.out.println("Для контроля, первые 50 элементов массива:");
        ThreadsCalcArray.showArray(dArray, 0, 50);
        System.out.println();
        System.out.println("Для контроля, последние 50 элементов массива:");
        ThreadsCalcArray.showArray(dArray, dArray.length - 50, 50);
    }
}
