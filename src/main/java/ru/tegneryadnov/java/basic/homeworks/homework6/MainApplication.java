package ru.tegneryadnov.java.basic.homeworks.homework6;

public class MainApplication {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Барсик", 80),
                new Cat("Пушок", 85),
                new Cat("Пулька", 90),
                new Cat("Васька", 65)
        };
        Plate plate = new Plate(300);
        System.out.println(plate);
        feedingСats(cats, plate);
        System.out.println("Подсыпем еды...");
        plate.addFood(400);
        System.out.println(plate);
        feedingСats(cats, plate);
    }

    /**
     * Кормление котиков
     *
     * @param cats  массив котов
     * @param plate миска с едой
     */
    private static void feedingСats(Cat[] cats, Plate plate) {
        System.out.println("Кис-кис-кис... :)");
        for (int i = 0; i < cats.length; i++) {
            plate.reduceFood(cats[i].eat(plate.getCurrAmountFood()));
            System.out.println(cats[i].getName() + (cats[i].isSatiety() ? " не голоден." : " голоден."));
        }
        System.out.println(plate);
    }
}
