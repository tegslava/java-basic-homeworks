package ru.tegneryadnov.java.basic.homeworks.homework5;

public class MainApplication {
    public static void main(String[] args) {
        Animal animal = new Animal("Сферический конь", "химера", 10, 10, 100);
        animal.setSwimLostStamina(5);
        test(animal, 100, 500);
        Animal horse = new Horse("Зорька", "лошадь", 5, 3, 1000);
        test(horse, 100, 500);
        Animal dog = new Dog("Ролик", "собака", 2, 1, 200);
        test(dog, 50, 500);
        Animal cat = new Cat("Барсик", "кот", 2, 150);
        test(cat, 50, 500);
    }

    private static void test(Animal testClass, int swimDistance, int runDistance) {
        double time;
        testClass.info();
        time = testClass.swim(50);
        System.out.print(time > 0 ? String.format(" за %2.2f c\n", +time) : "\n");
        time = testClass.run(500);
        System.out.printf(" за %2.2f c\n\n", +time);
        testClass.info();
    }
}
