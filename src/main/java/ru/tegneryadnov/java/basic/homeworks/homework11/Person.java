package ru.tegneryadnov.java.basic.homeworks.homework11;

import java.util.Objects;

/**
 * Класс работника
 */
public class Person {
    private final String name;
    private Position position;
    private final Long id;

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && position == person.position && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", id=" + id +
                '}';
    }

    /**
     * Генерирует тестового работника
     *
     * @param ID идентификатор работника
     * @return объект типа Person
     */
    public static Person generatePerson(Long ID) {
        String[] firstNames = {"Алексей", "Петр", "Василий", "Иван", "Роман", "Андрей", "Вячеслав"};
        String[] surNames = {"Алибабаевич", "Георгиевич", "Константинович", "Михайлович", "Иванович"};
        String[] lastNames = {"Чайковский", "Суриков", "Айвазовский", "Шишкин", "Пушкин", "Лермонтов"};
        int j = rnd(0, firstNames.length - 1);
        int k = rnd(0, lastNames.length - 1);
        int l = rnd(0, surNames.length - 1);
        String personName = firstNames[j] + " " + surNames[l] + " " + lastNames[k];
        int m = rnd(0, Position.values().length - 1);
        Position personPosition = Position.getByOrdinal(m);
        return new Person(personName, personPosition, ID);
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
}
