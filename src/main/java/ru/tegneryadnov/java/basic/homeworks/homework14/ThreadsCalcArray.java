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
     * @param array        массив Double для хранения расчитанных данных
     * @param threadsCount количество потоков
     * @return возвращает список потоков, готовых к расчету
     */
    private List<Thread> getThreadsList(Double[] array, int threadsCount) {
        List<Thread> thrds = new ArrayList<>();
        int count = array.length / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            int startPos = count * i;
            String defaultName = "Поток #";
            thrds.add(
                    new Thread(() -> {
                        System.out.printf("Начал работу %s\n", Thread.currentThread().getName());
                        long timeStart = System.currentTimeMillis() / 1000;
                        for (int j = startPos; j < startPos + count; j++) {
                            synchronized (ThreadsCalcArray.class) {
                                array[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
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
     * @param array  массив Double
     * @param threadsCount количество запускаемых потоков
     */
    public static void createAndStartThreadsCalc(Double[] array, int threadsCount) {
        ThreadsCalcArray threadCA = new ThreadsCalcArray(array, threadsCount);
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
     * @param array    массив Double
     * @param startPos позиция начала показа
     * @param count    количество отображаемых документов
     */
    public static void showArray(Double[] array, int startPos, int count) {
        for (int i = startPos; (i < startPos + count) & (i < array.length); i++) {
            System.out.printf("array[%d] = %9.6f\n", i, array[i]);
        }
    }

    /**
     * Для теста посчитаем массив в 1-м потоке, выведем первые 50 и последние 50
     * рассчитанных элемента;
     * Для теста посчитаем массив в maxThreadsCount потоках, выведем первые 50 и последние 50
     * рассчитанных элемента
     * @param internalArray входящий массив Double
     * @param maxThreadsCount количество потоков для второго теста
     */
    public static void test(Double[] internalArray, int maxThreadsCount){
        ThreadsCalcArray.createAndStartThreadsCalc(internalArray, maxThreadsCount);
        System.out.println();
        System.out.println("Для контроля, первые 50 элементов массива:");
        ThreadsCalcArray.showArray(internalArray, 0, 50);
        System.out.println();
        System.out.println("Для контроля, последние 50 элементов массива:");
        ThreadsCalcArray.showArray(internalArray, internalArray.length - 50, 50);
    }
}
