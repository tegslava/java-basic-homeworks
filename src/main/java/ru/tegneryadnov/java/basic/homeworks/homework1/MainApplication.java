package ru.tegneryadnov.java.basic.homeworks.homework1;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        while (true) {
            System.out.println("Введите цифру от 1 до 5. (6 - выход):");
            int slc = scanner.nextInt();
            a = (int) (Math.random() * 100);
            b = (int) (Math.random() * 100);
            c = (int) (Math.random() * 100);

            if (slc == 1) {
                greetings();
            } else if (slc == 2) {
                checkSign(a, b, c);
            } else if (slc == 3) {
                selectColor(a);
            } else if (slc == 4) {
                compareNumbers(a, b);
            } else if (slc == 5) {
                addOrSubtractAndPrint(a, b, true);
                System.out.println();
                addOrSubtractAndPrint(a, b, false);
            } else if (slc == 6) {
                System.out.println("Конец работы");
                break;
            } else System.out.println("Я Вас не понимаю...");
        }
    }

    private static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    private static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println(a + "+" + b + "+" + c + "=" + (a + b + c));

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void selectColor(int data) {
        System.out.println("data=" + data);
        if (data >= 0 && data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers(int a, int b) {
        System.out.println("a=" + a + "\nb=" + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("initValue=" + initValue + "\ndelta=" + delta + "\nincrement=" + increment);
        System.out.println("Результат: " + (increment ? initValue + delta : initValue - delta));
    }

}
