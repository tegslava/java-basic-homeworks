package ru.tegneryadnov.java.basic.homeworks.homework7;

public class Machine extends MoveObject {
    public Machine(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    public boolean move(TerrainType terrain, double distance) {
        switch (terrain) {
            case PLAIN: {
                if (getResource() > 0) {
                    System.out.println("Машина проехала по " + terrain.getName() + " " +
                            getTraveledDistance(distance) + " км");
                    if (getResource() == 0)
                        System.out.println("Топливо закончилось!");
                    return true;
                } else {
                    System.out.println("Машина не едет. Сухой бак!");
                }
            }
            case FOREST:
            case SWAMP: {
                System.out.printf("Машина не едет по %s!\n", terrain.getName());
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Транспорт машина" +
                "\nРасход топлива (л/100 км): " + getResourceConsumption() +
                "\nОcтаток топлива (л):       " + getResource() +
                "\nЗапас хода (км):           " + getDistanceByReserve() + "\n";
    }
}
