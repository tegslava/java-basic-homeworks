package ru.tegneryadnov.java.basic.homeworks.homework4;
/*
* Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
ФИО: фамилия имя отчество
Год рождения: год рождения
e-mail: email
*/

import static java.time.Year.*;

public class User {
    private String lastName;
    private String firstName;
    private String fathersName;
    private int yearBirth;
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return (now().getValue() - yearBirth);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String lastName, String firstName, String fathersName, int yearBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("ФИО:          %s %s %s\n" +
                        "Год рождения: %s\n" +
                        "e-mail:       %s\n",
                getLastName(), getFirstName(), getFathersName(),
                Integer.toString(getYearBirth()), getEmail());
    }

/*
    Cравнение объектов, мы еще не проходили :)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return yearBirth == user.yearBirth && Objects.equals(lastName, user.lastName)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(fathersName, user.fathersName)
                && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, fathersName, yearBirth, email);
    }*/
}
