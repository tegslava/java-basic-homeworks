package ru.tegneryadnov.java.basic.homeworks.homework3;

public class MainApplication {
    public static void main(String[] args) {
        /*
         * Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный
         * двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
         */
        int[][] array = {{-1, 2, -3}, {2, -3}, {-1, 0, -2, 2}};
        System.out.println("Массив на входе: ");
        printArrToLine(array);
        System.out.println("Сумма элементов больше 0: " + sumOfPositiveElements(array));
        System.out.println();
        /*
         *Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат
         * из символов * со сторонами соответствующей длины;
         */
        int size = 4;
        char s = '*';
        System.out.printf("Размер квадрата: %d, символ заливки %c:\n", size, s);
        printSqrt(size, s);
        System.out.println();
        /*
         *Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
         *и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
         */
        System.out.println("Зануляем диагональ двумерного массива, слева направо:");
        array = getSqrtMatrix(7, 10);
        print2DMatrix(fillDiagonalLTRB(array, 0));
        System.out.println("Зануляем диагональ двумерного массива, справа налево:");
        array = getSqrtMatrix(7, 10);
        print2DMatrix(fillDiagonalRTLB(array, 0));
        System.out.println("Зануляем обе диагонали двумерного массива:");
        array = getSqrtMatrix(7, 10);
        print2DMatrix(fillTwoDiagonals(array, 0));
        System.out.println();
        /*
         *Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
         */
        System.out.println("Массив на входе: ");
        array = new int[][]{{1, 2, 3}, {10, 0, -30, 120}, {1024, 77, -20}, {1, 0, 1000, 21, -100}};
        printArrToLine(array);
        System.out.println("Максимальное значение массива: " + findMax(array));
        System.out.println();
        /*
         *Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
         * если второй строки не существует, то в качестве результата необходимо вернуть -1
         * */
        System.out.println("Массив на входе: ");
        printArrToLine(array);
        System.out.println("Сумма элементов второй строки массива: " + sumOfLineElements(array, 1));
        System.out.println("Массив на входе: ");
        array = new int[][]{{1, 2, 3}, null, {1024, 77, -20}, {1, 0, 1000, 21, -100}};
        printArrToLine(array);
        System.out.println("Сумма элементов второй строки массива: " + sumOfLineElements(array, 1));

        print2DMatrix(generateDiagonalNumberMatrix(4, 4));
    }

    /**
     * Печать двумерного целочисленного массива "в строку"
     *
     * @param arr двумерный целочисленный массив
     */
    private static void printArrToLine(int[][] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.print("null, ");
                continue;
            }
            System.out.print("{");
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.print(arr[i][arr[i].length - 1]);
            System.out.print(i != arr.length - 1 ? "}, " : "}}\n");
        }
    }

    /**
     * Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный
     * двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
     */
    private static long sumOfPositiveElements(int[][] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    /**
     * Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль
     * квадрат из символов * со сторонами соответствующей длины;
     */
    public static void printSqrt(int size, char smb) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                System.out.printf("%3c", smb);
            }
            System.out.println();
        }
    }

    /**
     * Генератор двумерного целочисленного массива c положительными значениями
     *
     * @param size   количество столбцов
     * @param maxVal максимальное случайное целое в массиве
     * @return возвращает двумерный целочисленный массив
     */
    public static int[][] getSqrtMatrix(int size, int maxVal) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * (maxVal + 1));
            }
        }
        return matrix;
    }

    /**
     * Заполняет диагональ двумерного массива заданным целым числом, слева направо
     *
     * @param arr     двумерный целочисленный массив
     * @param fillNum целое число для заполнения
     * @return возвращает преобразованный массив
     */
    public static int[][] fillDiagonalLTRB(int[][] arr, int fillNum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = fillNum;
                }
            }
        }
        return arr;
    }

    /**
     * Заполняет диагональ двумерного массива заданным целым числом, справа налево
     *
     * @param arr     двумерный целочисленный массив
     * @param fillNum целое число для заполнения
     * @return возвращает преобразованный массив
     */
    public static int[][] fillDiagonalRTLB(int[][] arr, int fillNum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i + j == arr.length - 1) {
                    arr[i][j] = fillNum;
                }
            }
        }
        return arr;
    }

    /**
     * Заполняет диагонали двумерного массива заданным целым числом
     *
     * @param arr     двумерный целочисленный массив
     * @param fillNum целое число для заполнения
     * @return возвращает преобразованный массив
     */
    public static int[][] fillTwoDiagonals(int[][] arr, int fillNum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i + j == arr.length - 1) || (i == j)) {
                    arr[i][j] = fillNum;
                }
            }
        }
        return arr;
    }

    /**
     * Печатает двумерный целочисленный массив в виде матрицы
     *
     * @param arr двумерный целочисленный массив
     */
    public static void print2DMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /*
        Реализовать метод findMax(int[][] array) который должен найти и
        вернуть максимальный элемент массива;
    */

    /**
     * Поиск максимального элемента двумерного целочисленного массива
     *
     * @param arr двумерный целочисленны массив
     * @return максимальное значение массива
     */
    public static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    /*
     * Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
     * если второй строки не существует, то в качестве результата необходимо вернуть -1
     * }
     */

    /**
     * Подсчет суммы элементов строки двумерного целочисленного массива
     *
     * @param arr  двумерный целочисленный массив
     * @param lineIndex индекс строки массива
     * @return возвращает сумму элементов строки с индексом lineIndex
     */
    public static long sumOfLineElements(int[][] arr, int lineIndex) {
        if ((arr[lineIndex] == null) || (arr.length < lineIndex + 1)) return -1L;
        long sum = 0;
        for (int i = 0; i < arr[lineIndex].length; i++) {
            sum += arr[lineIndex][i];
        }
        return sum;
    }

    public static int[][] generateDiagonalNumberMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int currentNumber = 1;

        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int x = j;
                int y = i - j;
                if (x < m && y < n) {
                    matrix[x][y] = currentNumber;
                    currentNumber++;
                }
            }
        }

        return matrix;
    }
}
