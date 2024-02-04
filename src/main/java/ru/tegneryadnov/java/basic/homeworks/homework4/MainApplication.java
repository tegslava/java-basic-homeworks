package ru.tegneryadnov.java.basic.homeworks.homework4;

import java.time.Year;

import static java.time.Year.now;

public class MainApplication {
    public static void main(String[] args) {
        /*
         * В методе main() MainApplication класса создайте массив из 10 пользователей и заполните
         * его объектами и с помощью цикла выведите информацию только о пользователях старше 40 лет.
         */
        User[] users = new User[10];
        initUsersArray(users);
        for (int i = 0; i < users.length; i++) {
            if ((users[i] != null) && (users[i].getAge() > 40)) users[i].info();
        }
        /*
        Объекты класса Коробка должны иметь размеры и цвет.
        Коробку можно открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после
        создания нельзя. У коробки должен быть метод, печатающий информацию о ней в консоль. В коробку
        можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда
        (только если предмет в ней есть), только при условии что коробка открыта (предметом читаем
        просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
        */
        Box box = new Box(10, 20, 30, "красный");
        box.info();
        box.close();
        box.setColor("черный");
        box.put("кролик");
        box.open();
        box.put("кролик");
        box.put("книга");
        box.close();
        box.get();
        box.open();
        box.get();
        box.put("книга");
        box.info();
    }

    /**
     * Инициализирует массив объектов User псевдослучайными значениями полей
     *
     * @param arrUsers массив объектов
     */
    private static void initUsersArray(User[] arrUsers) {
        String[][] aPersonsDict = {{"Иванов", "Петров", "Сидоров", "Васильев", "Мандельштам"},
                {"Иван", "Петр", "Сидор", "Василий", "Осип"},
                {"Иванович", "Петрович", "Васильвич", "Алибабаевич", "Эмильевич"},
                {"man%02d@mail.ru", "man%02d@yandex.ru", "man%02d@google.com", "man%02d@bk.ru", "man%02d@ya.ru"}};
        int age = 0;
        int cntUsers = 0;
        int maxIteration = 100;
        int iteration = 0;
        int year = now().getValue();
        int cntElements = aPersonsDict[0].length;
        boolean quit = false;
        while (!quit) {
            do {
                age = (int) (Math.random() * 90);
            } while (age == 0);
            String lastName = aPersonsDict[0][(int) (Math.random() * cntElements)];
            String firstName = aPersonsDict[1][(int) (Math.random() * cntElements)];
            String fathersName = aPersonsDict[2][(int) (Math.random() * cntElements)];
            String email = String.format(aPersonsDict[3][(int) (Math.random() * cntElements)], age);
            User user = new User(lastName, firstName, fathersName, (year - age), email);
            if (!elementExists(arrUsers, user)) {
                arrUsers[cntUsers] = user;
                cntUsers++;
            }
            iteration++;
            if ((cntUsers == arrUsers.length) || (iteration == maxIteration)) {
                quit = true;
            }
        }
    }

    /*
    Cравнение объектов, мы еще не проходили :)

    private static boolean elementExists_(User[] arrUsers, User user) {
        for (int i = 0; i < arrUsers.length; i++) {
            if ((arrUsers[i] != null) && arrUsers[i].equals(user)) {
                return true;
            }
        }
        return false;
    }
    */

    /**
     * Проверяет наличие объекта user в массиве объектов класса User
     *
     * @param arrUsers массив объектов класса User
     * @param user     проверяемый объект
     * @return в случае присутствия объекта user в массиве arrUsers, возвращает true
     */
    private static boolean elementExists(User[] arrUsers, User user) {
        for (int i = 0; i < arrUsers.length; i++) {
            if ((arrUsers[i] != null) &&
                    ((arrUsers[i].getLastName().equals(user.getLastName())) &&
                            (arrUsers[i].getFirstName().equals(user.getFirstName())) &&
                            (arrUsers[i].getFathersName().equals(user.getFathersName())) &&
                            (arrUsers[i].getYearBirth() == user.getYearBirth()) &&
                            (arrUsers[i].getEmail().equals(user.getEmail())))) {
                return true;
            }
        }
        return false;
    }
}
