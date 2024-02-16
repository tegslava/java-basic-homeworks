package ru.tegneryadnov.java.basic.homeworks.homework7;

public class Man extends MoveObject {
    private String name;
    private Movable currentTransport;

    public String getName() {
        return name;
    }

    /**
     * Класс - человек
     *
     * @param name              имя
     * @param energy            запас энергии кКал
     * @param energyConsumption расход энергии на 100 км
     * @param currentTransport  выбран транспорт
     */
    public Man(String name, double energy, double energyConsumption, Movable currentTransport) {
        super(energy, energyConsumption);
        this.name = name;
        this.currentTransport = currentTransport;
    }

    /**
     * Класс - человек, без сил и транспорта
     *
     * @param name имя
     */
    public Man(String name) {
        super(0, 0);
        this.name = name;
    }

    /**
     * Класс - человек без транспорта
     *
     * @param name              имя
     * @param energy            запас энергии кКал
     * @param energyConsumption расход энергии на 100 км
     */
    public Man(String name, double energy, double energyConsumption) {
        super(energy, energyConsumption);
        this.name = name;
    }

    /**
     * Сесть на транспорт
     */
    public void getOn(Movable vehicle) {
        currentTransport = vehicle;
        System.out.println(name + " выбрал " +
                Utils.firstCharToLowerCase(currentTransport.toString()));
    }

    /**
     * Сойти с транспорта
     */
    public void getOff() {
        if (currentTransport != null)
            System.out.println(name + " бросил " +
                    Utils.firstCharToLowerCase(currentTransport.toString()));
        currentTransport = null;
    }

    /**
     * Переместиться по указанной местности, на заданное расстояние
     *
     * @param terrain  тип местности
     * @param distance расстояние
     * @return true удалось переместиться/ false не удалось переместиться
     */
    private boolean moveOnFoot(TerrainType terrain, double distance) {
        switch (terrain) {
            case SWAMP:
            case FOREST:
            case PLAIN: {
                if (getResource() > 0) {
                    System.out.println(name + " прошел пешком по " + terrain.getName() + " " +
                            getTraveledDistance(distance) + " км");
                    if (getResource() == 0)
                        System.out.println("Силы закончилось!");
                    return true;
                } else {
                    System.out.println(name + " не может идти. Нет сил!");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean move(TerrainType terrain, double distance) {
        if (currentTransport == null) {
            System.out.println(name + " без транспорта.");
            return moveOnFoot(terrain, distance);
        }
        return currentTransport.move(terrain, distance);
    }

    @Override
    public String toString() {
        return "Человек " + name +
                "\nРасход энергии (кКал/100 км): " + getResourceConsumption() +
                "\nОстаток энергии (кКал):       " + getResource() +
                "\nЗапас пешего хода (км):       " + getDistanceByReserve() + "\n" +
                (currentTransport == null ? "Транспорт не выбран" : "Выбран " + currentTransport);
    }
}

