package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class AppArraySizeException extends Exception {
    public AppArraySizeException(int size) {
        super(String.format("Ошибка размерности массива. Ожидалась размерность [%d][%d]", size, size));
    }
}
