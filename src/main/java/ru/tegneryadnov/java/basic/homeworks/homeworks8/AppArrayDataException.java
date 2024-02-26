package ru.tegneryadnov.java.basic.homeworks.homeworks8;

public class AppArrayDataException extends NumberFormatException {
/*    private int i, j;
    private final String arItem;*/

    public AppArrayDataException(int i, int j, String arItem) {
        //super();
        super(String.format("Ошибка приведения типа элемента массива [%d][%d]: %s", i, j, arItem));
/*        this.i = i;
        this.j = j;
        this.arItem = arItem;*/
    }

/*    @Override
    public String toString() {
        return String.format("Ошибка приведения типа элемента массива [%d][%d]: %s", i, j, arItem);
    }*/

/*    @Override
    public String getMessage(){
        return super.getMessage()+String.format("Ошибка приведения типа элемента массива [%d][%d]: %s", i, j, arItem);
    }*/
}
