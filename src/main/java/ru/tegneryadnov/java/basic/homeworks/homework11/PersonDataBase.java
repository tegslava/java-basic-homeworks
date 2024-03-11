package ru.tegneryadnov.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    private final Set<Person> managersPositions = new HashSet<>();
    private final Set<Person> employeePosition = new HashSet<>();
    private Map<Long, Person> persons = new HashMap<>();
    private static Long seqNumber;

    static {
        seqNumber = 1L;
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
     * O(1)
     *
     * @param person
     */
    public void addPerson(Person person) {
        persons.put(person.getId(), person);
    }

    /**
     * O(1)
     * MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER
     *
     * @param person
     * @return
     */
    public boolean isManager(Person person) {
        if (managersPositions.contains(person.getPosition())) {
            return true;
        }
        return false;
    }

    /**
     * O(1)
     * DRIVER, ENGINEER, DEVELOPER, QA,
     * JANITOR, PLUMBER, JUNIOR_DEVELOPER
     *
     * @param person
     * @return
     */
    public boolean isEmployee(Person person) {
        if (employeePosition.contains(person.getPosition())) {
            return true;
        }
        return false;
    }

    public PersonDataBase() {
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

    public Long getSeqNumber() {
        return ++seqNumber;
    }
}
