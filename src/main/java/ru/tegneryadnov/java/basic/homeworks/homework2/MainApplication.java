package ru.tegneryadnov.java.basic.homeworks.homework2;

public class MainApplication {
    public static void main(String[] args) {
        multiPrint(3, "Строка для размножения");
        System.out.println();
        int[] iArr = {1, 4, 6, 5, 9, 0};
        //new int[]{1, 4, 6, 5, 9, 0}
        arrayItemsSum(iArr);
        System.out.println();
        fillArray(5, iArr);
        System.out.println();
        arrayItemsAdder(10, iArr);
        System.out.println();
        comparingHalfArray(new int[]{1, 4, 6, 5, 9, 0, 2});
    }

    private static void multiPrint(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
     * значение которых больше 5, и печатающий полученную сумму в консоль.
     * */
    private static void arrayItemsSum(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Проверьте параметры для arrayItemsSum(int[] iArr)!");
            return;
        }
        int sum = 0;
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] > 5) {
                sum += iArr[i];
            }
        }
        System.out.println("Получен массив:");
        intArrayPrint(iArr);
        System.out.println("Сумма элементов больше 5: " + sum);
    }

    private static void intArrayPrint(int[] iArr) {
        if (iArr != null) {
            System.out.print("{");
            for (int i = 0; i < iArr.length - 1; i++) {
                System.out.print(iArr[i] + ",");
            }
            System.out.println(iArr[iArr.length - 1] + "}");
        }
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
     * метод должен заполниться каждую ячейку массива указанным числом.*/
    private static void fillArray(int trgNum, int[] iArr) {
        System.out.println("Получено число: " + trgNum);
        System.out.println("Получен массив:");
        intArrayPrint(iArr);

        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = trgNum;
        }

        System.out.println("Преобразованный массив:");
        intArrayPrint(iArr);
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
     * увеличивающий каждый элемент которого на указанное число.*/
    private static void arrayItemsAdder(int trgNum, int[] iArr) {
        System.out.println("Получено число: " + trgNum);
        System.out.println("Получен массив:");
        intArrayPrint(iArr);

        for (int i = 0; i < iArr.length; i++) {
            iArr[i] += trgNum;
        }

        System.out.println("Преобразованный массив:");
        intArrayPrint(iArr);
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
     * и печатающий в консоль сумма элементов какой из половин массива больше.
     * */
    private static void comparingHalfArray(int[] iArr) {
        System.out.println("Получен массив:");
        intArrayPrint(iArr);

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < iArr.length / 2; i++) {
            sum1 += iArr[i];
        }

        for (int i = iArr.length / 2; i < iArr.length; i++) {
            sum2 += iArr[i];
        }

        System.out.println("Сумма первой половины массива: " + sum1);
        System.out.println("Сумма второй половины массива: " + sum2);

        if (sum1 == sum2) {
            System.out.println("Суммы половин массива равны");
        } else {
            System.out.println(
                    sum1 > sum2 ? "Сумма первой половины массива больше" :
                            "Сумма второй половины массива больше");
        }
    }
}
