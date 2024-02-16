package ru.tegneryadnov.java.basic.homeworks.homework7;

public enum TerrainType {
    FOREST("лесу"),
    PLAIN("равнине"),
    SWAMP("болоту");

    private final String name;

    TerrainType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
