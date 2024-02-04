package ru.tegneryadnov.java.basic.homeworks.homework4;
/*
 * Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
 * Коробку можно открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после
 * создания нельзя. У коробки должен быть метод, печатающий информацию о ней в консоль. В коробку
 * можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда
 * (только если предмет в ней есть), только при условии что коробка открыта (предметом читаем
 * просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */
public class Box {
    private String status;
    private String color;
    private final int length;
    private final int height;
    private final int depth;
    private String subj;

    public void info() {
        System.out.println("Размеры коробки: " + length + "x" + height + "x" + depth + ".\n" +
                "Коробка " + status + ".\n" +
                "Цвет коробки: " + (color == null ? "не определен" : color) + ".\n" +
                "Внутри коробки " + (subj == null ? "пусто" : subj) + ".\n");
    }

    public void put(String subj) {
        if (this.subj != null) {
            System.out.println("Сначала выньте предмет из коробки.");
            return;
        }
        if (status.equals("закрыта")) {
            System.out.println("Сначала откройте коробку.");
            return;
        }
        if (subj.length() == 0) {
            System.out.println("Укажите название предмета.");
            return;
        }
        this.subj = subj;
        System.out.println("В коробку положили " + subj + ".");
    }

    public String get() {
        if (status.equals("закрыта")) {
            System.out.println("Сначала откройте коробку.");
            return null;
        }
        String subj = this.subj;
        this.subj = null;
        if (subj == null) {
            System.out.println("Коробка пустая");
        } else {
            System.out.println("Из коробки вынули " + subj);
        }
        return subj;
    }

    public void open() {
        this.status = "открыта";
        System.out.println("Коробка открыта.");
    }

    public void close() {
        this.status = "закрыта";
        System.out.println("Коробка закрыта.");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("Цвет коробки " + color + ".");
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public Box(int length, int height, int depth, String color) {
        this.status = "открыта";
        this.color = color;
        this.length = length;
        this.height = height;
        this.depth = depth;
    }
}
