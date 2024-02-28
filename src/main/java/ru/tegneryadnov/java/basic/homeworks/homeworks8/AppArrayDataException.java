package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class AppArrayDataException extends NumberFormatException {
    public AppArrayDataException(int i, int j, String arItem) {
        super(String.format("Ошибка приведения типа элемента массива [%d][%d]: %s", i, j, arItem));
    }
}
