package ru.tegneryadnov.java.basic.homeworks.homework7;

public class MainApplication {
    public static void main(String[] args) {
        Man man = new Man("Володя");
        Machine machine = new Machine(10, 5);
        man.getOn(machine);
        man.move(TerrainType.PLAIN, 20);
        man.move(TerrainType.FOREST, 20);
        man.move(TerrainType.SWAMP, 20);
        man.getOff();
        System.out.println();
        Horse horse = new Horse(1000, 500);
        man.getOn(horse);
        System.out.println();
        man.move(TerrainType.PLAIN, 150);
        man.move(TerrainType.FOREST, 70);
        man.move(TerrainType.FOREST, 70);
        man.move(TerrainType.SWAMP, 20);
        man.getOff();
        System.out.println();
        AllTerrain allTerrain = new AllTerrain(100, 20);
        man.getOn(allTerrain);
        System.out.println();
        man.move(TerrainType.PLAIN, 200);
        man.move(TerrainType.FOREST, 100);
        man.move(TerrainType.SWAMP, 200);
        man.move(TerrainType.PLAIN, 20);
        man.getOff();
        System.out.println();
        Man man2 = new Man("Петр", 2000, 4000);
        man2.move(TerrainType.SWAMP, 45);
        System.out.println(man2);
        Bike bike = new Bike(man2, 400);
        man2.getOn(bike);
        man2.move(TerrainType.PLAIN, 20);
        man2.move(TerrainType.SWAMP, 20);
        man2.getOff();
        System.out.println(man2);
    }
}
