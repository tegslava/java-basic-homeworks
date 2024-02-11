package ru.tegneryadnov.java.basic.homeworks.homework6;

public class Plate {
    private double currAmountFood;
    private final double volume;

    public double getCurrAmountFood() {
        return currAmountFood;
    }

    public double getVolume() {
        return volume;
    }

    public Plate(double volume) {
        this.currAmountFood = volume;
        this.volume = volume;
    }

    public void addFood(double amountFood) {
        currAmountFood += amountFood;
        if (currAmountFood > volume) {
            currAmountFood = volume;
        }
    }

    public boolean reduceFood(double amountFood) {
        currAmountFood -= amountFood;
        if (currAmountFood >= 0) {
            return true;
        } else {
            currAmountFood = 0;
            return false;
        }
    }

    @Override
    public String toString() {
        return "В миске объемом: " + volume + " ед насывано еды: " + currAmountFood+ " ед";
    }
}

