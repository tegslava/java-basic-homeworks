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
        List<Integer> testList = new ArrayList<>();
        testList.add(-1);
        testList.add(1);
        testList.add(6);
        testList.add(10);
        testList.add(null);
        testList.add(4);
        System.out.print("На вход подан список: " + testList);
        int trashHold = 5;
        System.out.printf(". Сумма элементов, больше %d, равна %d\n", trashHold,
                getSumOfListItems(testList, trashHold));
        int replNumber = 1;
        System.out.printf("На вход подан список %s, число для заполнения непустых элементов: %d.\n", testList,
                replNumber);
        fillListWithNumber(replNumber, testList);
        System.out.printf("Измененный список: %s\n", testList);
        System.out.printf("На вход подан список %s, число для увеличения непустых элементов: %d.\n", testList,
                replNumber);
        incrementListItemsByNumber(replNumber, testList);
        System.out.printf("Измененный список: %s\n", testList);
        System.out.println();
        List<Employee> listOfEmployees = getListOfEmployees(10);
        System.out.println("Сгенерировали список сотрудников: ");
        printList(listOfEmployees);
        System.out.println();
        System.out.println("Список имен сотрудников:");
        printList(getListOfEmployeesNames(listOfEmployees));
        System.out.println();
        trashHold = 40;
        System.out.println("Список сотрудников старше 40:");
        printList(getListOfEmployeesOverAge(listOfEmployees, trashHold));
        System.out.println();
        System.out.println(
                averageAgeIsOlder(listOfEmployees, trashHold) ? "Средний возраст сотрудников превышает " + trashHold :
                        "Средний возраст сотрудников не превышает " + trashHold);
        System.out.println();
        System.out.println("Самый молодой сотрудник: " + youngestEmployee(listOfEmployees));
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов числа min и max, и
     * возвращающий ArrayList с набором последовательных значений в указанном
     * диапазоне (min и max включительно, шаг - 1);
     */

    /**
     * Возвращает ArrayList с набором последовательных значений в заданном диапазоне
     *
     * @param min  минимальное целое число;
     * @param max  максимальное целое число;
     * @param step шаг
     * @return возвращает ArrayList c набором последовательных значений
     */

    public static List<Integer> getSequenceList(int min, int max, int step) {
        List<Integer> list = new ArrayList<>();
        for (int i = max; i >= min; i += step) {
            list.add(i);
        }
        return list;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента список целых чисел,
     * суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
     */

    /**
     * Возвращает сумму элементов списка, больше значения trashHold;
     *
     * @param inputList список целых чисел;
     * @param trashHold пороговое значение суммируемых элементов списка;
     * @return сумма элементов;
     */
    public static long getSumOfListItems(List<Integer> inputList, int trashHold) {
        if (inputList == null)
            throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        long sum = 0;
        for (Integer i : inputList)
            if ((i != null) && (i > trashHold))
                sum += i;
        return sum;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на
     * список, метод должен переписать каждую заполненную ячейку списка указанным
     * числом;
     */

    /**
     * Заменяет указанным числом каждую заполненную ячейку переданного списка
     *
     * @param replNumber  заданное число
     * @param fillingList список
     */
    public static void fillListWithNumber(int replNumber, List<Integer> fillingList) {
        if (fillingList == null)
            throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        for (int i = 0; i < fillingList.size(); i++)
            if (fillingList.get(i) != null) {
                fillingList.set(i, replNumber);
            }
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на
     * список, увеличивающий каждый элемент списка на указанное число;
     */

    /**
     * Увеличивает каждый элемент списка на заданное число
     *
     * @param increment  заданное число
     * @param fillingList список
     */
    public static void incrementListItemsByNumber(int increment, List<Integer> fillingList) {
        if (fillingList == null)
            throw new IllegalArgumentException("На входе ожидался список целых чисел!");
        for (int i = 0; i < fillingList.size(); i++)
            if (fillingList.get(i) != null) {
                fillingList.set(i, fillingList.get(i) + increment);
            }
    }

    /**
     * Возвращает список объектов Employee
     *
     * @param cnt количество элементов списка
     * @return список объектов Employee
     */
    public static List<Employee> getListOfEmployees(int cnt) {
        List<Employee> listOfEmployees = new ArrayList<>();
        String[] firstNames = {"Алексей", "Петр", "Василий", "Иван"};
        String[] surNames = {"Алибабаевич", "Георгиевич", "Константинович", "Михайлович"};
        String[] lastNames = {"Чайковский", "Суриков", "Айвазовский", "Шишкин"};
        for (int i = 0; i < cnt; i++) {
            int j = rnd(0, firstNames.length - 1);
            int k = rnd(0, lastNames.length - 1);
            int l = rnd(0, surNames.length - 1);
            Employee employee = new Employee(firstNames[j] + " " + surNames[l] + " " + lastNames[k],
                    rnd(23, 53));
            listOfEmployees.add(employee);
        }
        return listOfEmployees;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и
     * возвращающий список их имен;
     */

    /**
     * По списку сотрудников формирует список имен сотрудников
     *
     * @param listOfEmployees список сотрудников
     * @return список имен сотрудников
     */
    public static List<String> getListOfEmployeesNames(List<Employee> listOfEmployees) {
        verifiedList(listOfEmployees);
        List<String> listOfEmployeeNames = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            listOfEmployeeNames.add(employee.getName());
        }
        return listOfEmployeeNames;
    }

    /**
     * Возвращает псевдослучайное целое из диапазона
     *
     * @param min начало диапазона
     * @param max конец диапазона
     * @return псевдослучайное целое из диапазона
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников и
     * минимальный возраст, и возвращающий список сотрудников, возраст которых
     * больше либо равен указанному аргументу;
     */

    /**
     * Из полученного списка сотрудников, формирует список сотрудников, возраст
     * которых больше, либо равен пороговому
     *
     * @param listOfEmployees входящий список сотрудников
     * @param trashHold       пороговый возраст
     * @return список сотрудников, отвечающих условию отбора
     */
    public static List<Employee> getListOfEmployeesOverAge(List<Employee> listOfEmployees, int trashHold) {
        verifiedList(listOfEmployees);
        List<Employee> selectedList = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            if (employee.getAge() >= trashHold)
                selectedList.add(employee);
        }
        return selectedList;
    }

    /**
     * Отображает список элементов в столбик
     *
     * @param list список элементов
     */
    public static void printList(List list) {
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников и
     * минимальный средний возраст, и проверяющий, что средний возраст сотрудников
     * превышает указанный аргумент;
     */

    /**
     * Проверяет, превышает ли средний возраст сотрудников из списка заданный
     *
     * @param listOfEmployees список сотрудников
     * @param avrAge          заданный граничный возраст
     * @return истина, если средний возраст больше заданного
     */
    public static boolean averageAgeIsOlder(List<Employee> listOfEmployees, int avrAge) {
        verifiedList(listOfEmployees);
        double sum = 0;
        for (Employee employee : listOfEmployees) {
            sum += employee.getAge();
        }
        double calcAvrAge = sum / listOfEmployees.size();
        System.out.println("Средний возраст сотрудников: " + calcAvrAge);
        return calcAvrAge > avrAge;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и
     * возвращающий ссылку на самого молодого сотрудника.
     */

    /**
     * Возвращает самого молодого сотрудника из списка
     *
     * @param listOfEmployees список сотрудников
     * @return самый молодой сотрудник
     */
    public static Employee youngestEmployee(List<Employee> listOfEmployees) {
        verifiedList(listOfEmployees);
        Employee youngest = listOfEmployees.get(0);
        for (int i = 1; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).getAge() < youngest.getAge())
                youngest = listOfEmployees.get(i);
        }
        return youngest;
    }

    /**
     * Проверяет корректность заполнения списка, в случае проблем генерит исключение
     *
     * @param listOfEmployees список сотрудников
     */
    public static void verifiedList(List<Employee> listOfEmployees) {
        if ((listOfEmployees == null) || (listOfEmployees.isEmpty()))
            throw new IllegalArgumentException("На входе ожидался заполненный список сотрудников!");
        for (Employee employee : listOfEmployees) {
            if (employee == null)
                throw new IllegalArgumentException("В списке сотрудников не может быть null объектов!");
        }
    }
}

