package ru.tegneryadnov.java.basic.homeworks.homework7;

public class Horse extends MoveObject {
    public Horse(double energy, double energyConsumption) {
        super(energy, energyConsumption);
    }

    @Override
    public boolean move(TerrainType terrain, double distance) {
        switch (terrain) {
            case FOREST:
            case PLAIN: {
                if (getResource() > 0) {
                    System.out.println("Лошадь проехала по " + terrain.getName() + " " +
                            getTraveledDistance(distance) + " км");
                    if (getResource() == 0)
                        System.out.println("Лошадь устала!");
                    return true;
                } else {
                    System.out.println("Лошадь не идет. Требуется отдых!");
                }
            }
            case SWAMP: {
                System.out.printf("Лошадь не идет по %s!\n", terrain.getName());
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Транспорт лошадь" +
                "\nРасход энергии (кДж/100 км): " + getResourceConsumption() +
                "\nОcтаток энергии (кДж):       " + getResource() +
                "\nЗапас хода (км):             " + getDistanceByReserve() + "\n";
    }
}
