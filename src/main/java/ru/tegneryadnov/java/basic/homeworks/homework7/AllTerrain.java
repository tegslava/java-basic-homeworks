package ru.tegneryadnov.java.basic.homeworks.homework7;

public class AllTerrain extends MoveObject {

    public AllTerrain(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    public boolean move(TerrainType terrain, double distance) {
        switch (terrain) {
            case SWAMP:
            case FOREST:
            case PLAIN: {
                if (getResource() > 0) {
                    System.out.println("Вездеход проехал по " + terrain.getName() + " " +
                            getTraveledDistance(distance) + " км");
                    if (getResource() == 0)
                        System.out.println("Топливо закончилось!");
                    return true;
                } else {
                    System.out.println("Вездеход не едет. Сухой бак!");
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Транспорт вездеход" +
                "\nРасход топлива (л/100 км): " + getResourceConsumption() +
                "\nОcтаток топлива (л):       " + getResource() +
                "\nЗапас хода (км):           " + getDistanceByReserve() + "\n";
    }
}