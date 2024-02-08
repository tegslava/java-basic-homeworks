package ru.tegneryadnov.java.basic.homeworks.homework5;

public class Animal {
    private final double redStamina = 10;
    private final String animalType;
    private String name;
    private final double runSpeed;
    private final double swimSpeed;
    /*Затраты выносливости на бег*/
    private final double runLostStamina = 1;
    /*Затраты выносливости на плаванье*/
    private double swimLostStamina;
    /*Остаток выносливости животного*/
    private double stamina;
    /*Оценка состояния животного*/
    private String status;


    public void setSwimLostStamina(double swimLostStamina) {
        if (swimSpeed > 0)
            this.swimLostStamina = swimLostStamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStamina() {
        return stamina;
    }

    public String getStatus() {
        return status;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Animal(String name, String animalType, double runSpeed, double swimSpeed, double stamina) {
        this.animalType = animalType;
        this.name = name;
        if (runSpeed <= 0) throw new IllegalArgumentException("Скорость бега должна быть больше 0");
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        refreshStatus();
    }

    private void refreshStatus() {
        status = stamina >= redStamina ? "бодроcть" : "усталость";
    }

    /**
     * Метод возвращает время в секундах, затраченное на преодоление дистанции бегом
     *
     * @param distance
     * @return
     */
    public double run(int distance) {
        System.out.print("Животное " + animalType + " " + name + " пробежало " + distance + " м");
        lossStamina(runLostStamina, distance);
        return distance / runSpeed;
    }

    /**
     * Метод возвращает время в секундах, затраченное на преодоление дистанции вплавь
     *
     * @param distance
     * @return
     */
    public double swim(int distance) {
        if (swimSpeed <= 0) {
            System.out.print("Животное " + animalType + " " + name + " не плавает.");
            return -1;
        }
        System.out.print("Животное " + animalType + " " + name + " проплыло " + distance + " м");
        lossStamina(swimLostStamina, distance);
        return distance / swimSpeed;
    }

    @Override
    public String toString() {
        return "Вид животного: " + animalType + ".\n" +
                "Имя: " + name + ".\n" +
                "Скорость бега: " + runSpeed + " м/c.\n" +
                "Скорость плавания: " + swimSpeed + " м/c.\n" +
                "Затраты выносливости на бег: " + runLostStamina + " ед/м.\n" +
                "Затраты выносливости на плаванье: " + swimLostStamina + " ед/м.\n" +
                "Остаток выносливости животного: " + stamina + " ед.\n" +
                "Оценка состояния животного: " + status + ".\n";
    }

    /**
     * Расчет потери выносливости
     *
     * @param lostStamina затраты выносливости
     * @param distance    расстояние
     */
    private void lossStamina(double lostStamina, int distance) {
        if (stamina == -1) return;
        stamina -= lostStamina * distance;
        if (stamina <= 0) stamina = -1;
        refreshStatus();
    }

    public void info() {
        System.out.println(this);
    }
}
