package ru.tegneryadnov.java.basic.homeworks.homework14;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, для расчета и заливки данных в массив, в потоках
 */
public class ThreadsCalcArray {
    private List<Thread> thrds;

    /**
     * Порождает заданное количество потоков для расчета
     *
     * @param array        массив Double для хранения расчитанных данных
     * @param threadsCount количество потоков
     * @return возвращает список потоков, готовых к расчету
     */
    public List<Thread> getThreadsList(Double[] array, int threadsCount) {
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

    public ThreadsCalcArray(Double[] array, int threadsCount) {
        thrds = getThreadsList(array, threadsCount);
    }

    /**
     * Создает и запускает потоки на расчет
     *
     * @param array
     * @param threadsCount
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
            System.out.printf("array[%d] = %8f\n", i, array[i]);
        }
    }
}
