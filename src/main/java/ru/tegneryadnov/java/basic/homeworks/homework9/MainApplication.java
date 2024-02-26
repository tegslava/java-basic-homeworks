package ru.tegneryadnov.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int min = 1;
        int max = 10;
        int step = -1;
        System.out.printf("На вход поданы min = %d, max = %d, step = %d, возвращается список: %s\n",
                min, max, step, getSequenceList(min, max, step));
        List<Integer> testList = new ArrayList<Integer>();
        testList.add(-1);
        testList.add(1);
        testList.add(6);
        testList.add(10);
        testList.add(null);
        testList.add(4);
        System.out.print("На вход подан список: " + testList);
        int trashHold = 5;
        System.out.printf(". Сумма элементов, больше %d, равна %d\n", trashHold, getSumOfListItems(testList, trashHold));
        int replNumber = 1;
        System.out.printf("На вход подан список %s, число для заполнения непустых элементов: %d.\n", testList, replNumber);
        fillListWithNumber(replNumber, testList);
        System.out.printf("Измененный список: %s\n", testList);
        System.out.printf("На вход подан список %s, число для увеличения непустых элементов: %d.\n", testList, replNumber);
        incrementListItemsByNumber(replNumber, testList);
        System.out.printf("Измененный список: %s", testList);


    }

    /*Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий
    ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);*/

    /**
     * Возвращает ArrayList с набором последовательных значений в заданном диапазоне
     *
     * @param min  минимальное целое число;
     * @param max  максимальное целое число;
     * @param step шаг
     * @return возвращает ArrayLis c набором последовательных значений
     */
    public static ArrayList getSequenceList(int min, int max, int step) {
        ArrayList list = new ArrayList<Integer>();
        for (int i = max; i >= min; i += step) {
            list.add(i);
        }
        return list;
    }

    /*Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
    значение которых больше 5, и возвращающий сумму;*/

    /**
     * Возвращает сумму элементов списка, больше значения trashHold;
     *
     * @param inputList список целых чисел;
     * @param trashHold пороговое значение суммируемых элементов списка;
     * @return сумма элементов;
     */
    public static long getSumOfListItems(List<Integer> inputList, int trashHold) {
        if (inputList == null) throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        long sum = 0;
        for (Integer i : inputList) if ((i != null) && (i > trashHold)) sum += i;
        return sum;
    }

    /*Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
    метод должен переписать каждую заполненную ячейку списка указанным числом;*/

    /**
     * Заменяет указанным числом каждую заполненную ячейку переданного списка
     *
     * @param replNumber  заданное число
     * @param fillingList список
     */
    public static void fillListWithNumber(int replNumber, List<Integer> fillingList) {
        if (fillingList == null) throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        for (int i = 0; i < fillingList.size(); i++)
            if (fillingList.get(i) != null) {
                fillingList.set(i, replNumber);
            }
    }

    /*Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
    увеличивающий каждый элемент списка на указанное число;*/

    /**
     * Увеличивает каждый элемент списка на заданное число
     *
     * @param incrNumber  заданное число
     * @param fillingList список
     */
    public static void incrementListItemsByNumber(int incrNumber, List<Integer> fillingList) {
        if (fillingList == null) throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        for (int i = 0; i < fillingList.size(); i++)
            if (fillingList.get(i) != null) {
                fillingList.set(i, fillingList.get(i) + incrNumber);
            }
    }

    /*Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;*/

    /**
     * По списку сотрудников формирует список имен сотрудников
     *
     * @param listOfEmployees список сотрудников
     * @return список имен сотрудников
     */
    public static List<String> getListOfEmployeeNames(List<Employee> listOfEmployees) {
        if (listOfEmployees == null) throw new IllegalArgumentException("На входе ожидался список сотрудников!");
        List<String> listOfEmployeeNames = new ArrayList<String>();
        for (Employee employee : listOfEmployees) {
            listOfEmployeeNames.add(employee.getName());
        }
    }
}

