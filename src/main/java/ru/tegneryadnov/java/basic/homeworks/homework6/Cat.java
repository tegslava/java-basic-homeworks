package ru.tegneryadnov.java.basic.homeworks.homework6;

public class Cat {
    private final String name;
    /*Аппетит: количество поглощаемой еды за один подход к тарелке*/
    private final double appetite;
    /*Сытость*/
    private boolean satiety;

    /*Сыт ли котик?*/
    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public Cat(String name, double appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    /**
     * Подход к тарелке, поесть.
     * Возвращает количество съеденного, либо 0, если еда отвергнута
     *
     * @param amountFood количество еды в тарелке
     */
    public double eat(double amountFood) {
        if (satiety) {
            System.out.println(name + " есть не хочет.");
            return 0;
        }
        if (amountFood >= appetite) {
            System.out.println(name + " поел.");
            satiety = true;
            return appetite;
        } else {
            System.out.println(name + " не поел. Маловато будет.");
            satiety = false;
            return 0;
        }
    }

    /**
     * Кормление котика
     *
     * @param plate миска с едой
     */
    public void feedingСat(Plate plate) {
        plate.reduceFood(eat(plate.getCurrAmountFood()));
        System.out.println(name + (isSatiety() ? " не голоден." : " голоден."));
    }
}
