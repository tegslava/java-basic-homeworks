package ru.tegneryadnov.java.basic.homeworks.homework11;

public enum Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;

    /**
     * Поиск элемента enum по индексу
     * @param i индекс
     * @return возвращает элемент перечисления
     */
    public static Position getByOrdinal(int i) {
        for (Position v : Position.values()) {
            if (v.ordinal() == i) return v;
        }
        return null;
    }
};