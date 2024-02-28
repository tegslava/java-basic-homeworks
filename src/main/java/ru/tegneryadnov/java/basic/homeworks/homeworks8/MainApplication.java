package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class MainApplication {
    public static void main(String[] args) {
        String[][] arr;
        int requiredSize = 4;
        int size;
        try {
            size = 4;
            System.out.printf("На входе метода sumArrElements, массив c цифровыми литералами, размерностью [%d]x[%d]:\n", size, size);
            arr = get2DArrayDigitalLiterals(size);
            printArray(arr);
            System.out.printf("Сумма элементов массива: %d\n", sumArrElements(arr, requiredSize));
            System.out.printf("На входе метода sumArrElements, массив c литералами, размерностью [%d]x[%d]:\n", size, size);
            arr = get2DArrayLiterals(size);
            printArray(arr);
            System.out.printf("Сумма элементов массива: %d\n", sumArrElements(arr, requiredSize));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            size = 5;
            System.out.printf("На входе метода sumArrElements, массив c цифровыми литералами, размерностью [%d]x[%d]:\n", size, size);
            arr = get2DArrayDigitalLiterals(size);
            printArray(arr);
            System.out.printf("Сумма элементов массива: %d\n", sumArrElements(arr, requiredSize));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    /*Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
     Если передан массив другого размера необходимо бросить исключение AppArraySizeException.*/

    /**
     * Если размерность входящего двумерного массива на соответствует заданному значению,
     * бросает исключение AppArraySizeException
     *
     * @param sArr двумерный строковый массив
     * @param size заданное значение
     * @throws AppArraySizeException исключение
     */
    public static void checkArrSize(String[][] sArr, int size) throws AppArraySizeException {
        if (sArr == null) throw new IllegalArgumentException("На входе ожидался двумерный строковый массив ["
                + size + "]x[" + size + "]!");
        if (sArr.length != size) throw new AppArraySizeException(size);
        for (String[] strings : sArr)
            if (strings.length != size) throw new AppArraySizeException(size);
    }

    /**
     * Возвращает строковый квадратный двумерный массив, заполненный цифровыми литералами
     *
     * @param size размер массива
     * @return строковый массив с цифровыми литералами
     */
    public static String[][] get2DArrayDigitalLiterals(int size) {
        String[][] arr = new String[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                arr[i][j] = String.valueOf(i + j);
        return arr;
    }

    /**
     * Возвращает строковый квадратный двумерный массив, заполненный литералами
     *
     * @param size размер массива
     * @return строковый массив с литералами
     */
    public static String[][] get2DArrayLiterals(int size) {
        String[][] arr = new String[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                arr[i][j] = String.valueOf(i + j);
        int randomI = (int) (Math.random() * size);
        int randomJ = (int) (Math.random() * size);
        arr[randomI][randomJ] = "A";
        return arr;
    }

    /**
     * Выводит массив на экран
     *
     * @param arr массив
     */
    public static void printArray(String[][] arr) {
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.printf("%3s", string);
            }
            System.out.println();
        }
    }

    /*Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например,
    в ячейке лежит текст вместо числа), должно быть брошено исключение AppArrayDataException с детализацией,
    в какой именно ячейке лежат неверные данные.*/

    /**
     * Возвращает сумму элементов строкового массива, в случае ошибки размерности массива кидает AppArraySizeException,
     * если невозможно привести типа элемента массива к целому кидает AppArrayDataException
     *
     * @param sArr входящий строковый массив
     * @param size контролируемый размер массива
     * @return сумма элементов массива
     */
    public static long sumArrElements(String[][] sArr, int size) throws AppArraySizeException {
        checkArrSize(sArr, size);
        long sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    sum += Integer.parseInt(sArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j, sArr[i][j]);
                }
            }
        }
        return sum;
    }
}