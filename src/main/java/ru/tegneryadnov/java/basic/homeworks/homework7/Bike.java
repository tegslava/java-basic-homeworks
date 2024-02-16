package ru.tegneryadnov.java.basic.homeworks.homework7;

public class Bike extends MoveObject {
    private final Man driver;

    /**
     * Класс велосипед
     *
     * @param driver            велосипедист
     * @param energyConsumption расход энергии
     */
    public Bike(Man driver, double energyConsumption) {
        super(driver.getResource(), energyConsumption);
        this.driver = driver;
    }

    @Override
    public boolean move(TerrainType terrain, double distance) {
        switch (terrain) {
            case FOREST:
            case PLAIN: {
                if (getResource() > 0) {
                    System.out.println("Велосипед проехал по " + terrain.getName() + " " +
                            getTraveledDistance(distance) + " км");
                    double bikeResource = getResource();
                    if (bikeResource == 0)
                        System.out.println("Силы закончилось!");
                    driver.setResource(bikeResource);
                    return true;
                } else {
                    System.out.println("Велосипед не едет. Нет сил!");
                    return false;
                }
            }
            case SWAMP: {
                System.out.printf("Велосипед не едет по %s!\n", terrain.getName());
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Транспорт велосипед" +
                "\nРасход энергии  (кКал/100 км): " + getResourceConsumption() +
                "\nОcтаток энергии (кКал):        " + getResource() +
                "\nЗапас хода (км):               " + getDistanceByReserve() + "\n";
    }
}
