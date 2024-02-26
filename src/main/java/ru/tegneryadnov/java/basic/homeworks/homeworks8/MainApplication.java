package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class MainApplication {
    private static int size = 4;

    public static void main(String[] args) throws AppArraySizeException{
        String[][] tesArr1 = {{"0", "1", "2", "3", "4"}, {"5", "6", "7", "8"}};
        String[][] tesArr2 = {{"0", "1", "err", "3"}, {"4", "5", "6", "7"}};
        String[][] tesArr3 = {{"0", "1", "2", "3"}, {"4", "5", "6", "7"}};
        try {
            System.out.println(sumArrElements(tesArr1));
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sumArrElements(tesArr2));
        } catch (
                AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long sumArrElements(String[][] sArr) throws AppArraySizeException{
        if (sArr == null) throw new IllegalArgumentException("На входе ожидался двумерный строковый массив!");
        if ((sArr.length != 2) || (sArr[0].length != size) || (sArr[1].length != size))
                throw new AppArraySizeException(size);
        long sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    sum += Integer.valueOf(sArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j, sArr[i][j]);
                }
            }
        }
        return sum;
    }
}
