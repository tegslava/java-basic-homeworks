package ru.tegneryadnov.java.basic.homeworks.homework11;

import java.util.*;

/**
 * Класс база данных работников типа Person
 */
public class PersonDataBase {
    private static PersonDataBase instance;
    private static final Set<Position> managersPositions = new HashSet<>();
    private static final Set<Position> employeePosition = new HashSet<>();
    private static Map<Long, Person> persons = new HashMap<>();
    private static Long seqNumber;

    static {
        seqNumber = 0L;
        managersPositions.add(Position.MANAGER);
        managersPositions.add(Position.DIRECTOR);
        managersPositions.add(Position.BRANCH_DIRECTOR);
        managersPositions.add(Position.SENIOR_MANAGER);
        employeePosition.add(Position.DRIVER);
        employeePosition.add(Position.ENGINEER);
        employeePosition.add(Position.DEVELOPER);
        employeePosition.add(Position.QA);
        employeePosition.add(Position.JANITOR);
        employeePosition.add(Position.PLUMBER);
        employeePosition.add(Position.JUNIOR_DEVELOPER);
    }

    private PersonDataBase() {
    }

    /**
     * Возвращает инстанс базы
     *
     * @return инстанс базы
     */
    public static PersonDataBase getInstance() {
        if (instance == null) {
            instance = new PersonDataBase();
        }
        return instance;
    }

    /**
     * O(1)
     *
     * @param id
     * @return
     */
    public Person findById(Long id) {
        return persons.get(id);
    }

    /**
     * Добавить работника
     *
     * @param person объект типа Person
     */
    public void addPerson(Person person) {
        persons.put(person.getId(), person);
    }

    /**
     * Определяет относится ли должность работника к менеджерам
     *
     * @param person объект типа Person
     * @return возвращает истина/ложь
     */
    public static boolean isManager(Person person) {
        return managersPositions.contains(person.getPosition());
    }

    /**
     * Определяет относится ли должность работника к линейному персоналу
     *
     * @param person объект типа Person
     * @return возвращает истина/ложь
     */
    public static boolean isEmployee(Person person) {
        return employeePosition.contains(person.getPosition());
    }

    /**
     * Генерит новый id работника
     *
     * @return Long id
     */
    public static long getSeqNumber() {
        return ++seqNumber;
    }

    /**
     * Возвращает из базы первые сnt записей
     *
     * @param cnt количество возвращаемых записей
     * @return список записей о работнике
     */
    public static List<Person> firstFewEntries(int cnt) {
        if (persons.isEmpty()) {
            System.out.println("База пустая.");
            return Collections.emptyList();
        }
        List<Person> list = new ArrayList<>();
        for (long i = 1; i <= cnt; i++) {
            list.add(persons.get(i));
        }
        return list;
    }

    /**
     * Порождаем набор сотрудников, тестируем поиск по id м функцию определения типа должности
     *
     * @param personDataBase получам объект PersonDataBase
     */
    public static void testPersonDataBase(PersonDataBase personDataBase) {
        int personCount = 1000_000;
        for (int i = 0; i < personCount; i++) {
            personDataBase.addPerson(Person.generatePerson(personDataBase.getSeqNumber()));
        }
        long id = Person.rnd(1, personCount);
        System.out.printf("Работник с табельным номером %d:\n", id);
        System.out.println(personDataBase.findById(id));
        System.out.println();
        personDataBase.firstFewEntries(10).forEach(p ->
                System.out.printf("%s - %s\n", p,
                        (PersonDataBase.isManager(p) ? "Менеджер" : "Линейный персонал")));
    }
}
