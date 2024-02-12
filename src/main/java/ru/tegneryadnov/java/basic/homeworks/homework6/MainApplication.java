package ru.tegneryadnov.java.basic.homeworks.homework6;

public class MainApplication {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Барсик", 80),
                new Cat("Пушок", 85),
                new Cat("Пулька", 90),
                new Cat("Васька", 65)
        };
        Plate plate = new Plate(300);
        feeding(cats, plate);
        System.out.println("Подсыпем корма...");
        plate.addFood(400);
        feeding(cats, plate);
    }

    /**
     * Кормление котиков
     *
     * @param cats  массив котов
     * @param plate миска с едой
     */
    private static void feeding(Cat[] cats, Plate plate) {
        System.out.println(plate);
        System.out.println("Кис-кис-кис...");
        for (int i = 0; i < cats.length; i++) {
            cats[i].feedingСat(plate);
        }
        System.out.println(plate);
    }
}
