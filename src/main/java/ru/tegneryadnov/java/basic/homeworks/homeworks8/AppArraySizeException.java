package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class AppArraySizeException extends Exception {

    /*    public AppArraySizeException(int size) {
            super();
            //super(String.format("Неправильный размер массива. Ожидался двумерный строковый массив [%d][%d]", size, size));
        }*/
    private int size;

    public AppArraySizeException(int size) {
        super();
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Ошибка задания размерности массива. Массив должен иметь размерность [%d][%d]", size, size);
    }
}
