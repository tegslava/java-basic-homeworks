import ru.tegneryadnov.java.basic.homeworks.homework11.PersonDataBase;
import ru.tegneryadnov.java.basic.homeworks.homework11.SortArray;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        PersonDataBase personDataBase = PersonDataBase.getInstance();
        PersonDataBase.testPersonDataBase(personDataBase);
        System.out.println();
        System.out.println("Тест сортировки методом пузырька:");
        int[] intArray = {1, 20, 149, 0, 3, 567, 34, 2, 15, -999};
        System.out.printf("Массив на входе:  %s", Arrays.toString(intArray));
        SortArray.bubbleSort(intArray);
        System.out.println();
        System.out.printf("После сортировки: %s", Arrays.toString(intArray));
    }
}
