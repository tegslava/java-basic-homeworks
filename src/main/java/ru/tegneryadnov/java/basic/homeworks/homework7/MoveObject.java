package ru.tegneryadnov.java.basic.homeworks.homework7;

public abstract class MoveObject implements Movable {
    /*Ресурс*/
    private double resource;
    /*Расход ресурса на 100 км*/
    private final double resourceConsumption;

    public double getResource() {
        return resource;
    }

    public void setResource(double resource) {
        this.resource = resource;
    }

    public double getResourceConsumption() {
        return resourceConsumption;
    }

    /*Максимальная дистанция на остатках ресурса*/
    public double getDistanceByReserve() {
        return (resource > 0 ? resource / resourceConsumption * 100 : 0);
    }

    /*Пройденное расстояние, в зависимости от заданной дистанции и остатка ресурсов*/
    public double getTraveledDistance(double distance) {
        double distanceByReserve = getDistanceByReserve();
        double traveledDistance = 0;
        if (distanceByReserve >= distance) {
            resource -= resourceConsumption / 100 * distance;
            traveledDistance = distance;
        } else {
            resource -= resourceConsumption / 100 * distanceByReserve;
            traveledDistance = distanceByReserve;
        }
        if (resource < 0) resource = 0;
        return traveledDistance;
    }

    @Override
    public abstract boolean move(TerrainType terrain, double distance);

    public MoveObject(double resource, double resourceConsumption) {
        this.resource = resource;
        this.resourceConsumption = resourceConsumption;
    }
}
