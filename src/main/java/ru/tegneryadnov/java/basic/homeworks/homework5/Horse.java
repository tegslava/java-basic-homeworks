package ru.tegneryadnov.java.basic.homeworks.homework5;

public class Horse extends Animal {
    public Horse(String name, String animalType, double runSpeed, double swimSpeed, double stamina) {
        super(name, animalType, runSpeed, swimSpeed, stamina);
        super.setSwimLostStamina(4);
    }
}
