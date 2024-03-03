package ru.tegneryadnov.java.basic.homeworks.homework10;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    /**
     * По имени возвращает список телефонов контакта
     *
     * @param fullName имя контакта
     * @return HashSet<String> список телефонов
     */
    public HashSet<String> findPhones(String fullName) {
        if ((fullName == null) || (fullName.isEmpty())) {
            return null;
        }
        for (String name : phoneBook.keySet()) {
            if (name.equals(fullName)) {
                return phoneBook.get(fullName);
            }
        }
        return null;
    }

    /**
     * Выполняет поиск номер(-а, -ов) телефона по имени
     *
     * @param fullName
     */
    public void find(String fullName) {
        contactInfo(fullName);
    }

    /**
     * Добавляет запись имя - телефон
     *
     * @param fullName имя контакта
     * @param phone    телефон
     */
    public void add(String fullName, String phone) {
        HashSet<String> phones = findPhones(fullName);
        if (phones == null || phones.isEmpty()) {
            phones = new HashSet<>();
            phoneBook.put(fullName, phones);
        }
        if (phone != null) {
            phones.add(phone);
        }
    }

    /**
     * Добавляет запись имя без телефона
     *
     * @param fullName имя контакта
     */
    public void add(String fullName) {
        add(fullName, null);
    }

    /**
     * Выводит информацию о контакте
     *
     * @param fullName
     */
    public void contactInfo(String fullName) {
        if (!phoneBook.containsKey(fullName)) {
            System.out.println("Контакт не найден - " + fullName + "\n");
            return;
        }
        HashSet<String> phones = findPhones(fullName);
        if ((phones == null) || (phones.isEmpty())) {
            System.out.println("Имя: " + fullName + "\nТелефоны не заведены\n");
            return;
        }
        System.out.println(String.format("Имя: %s\nТелефоны:", fullName));
        for (String phone : phones) {
            System.out.println(phone + ";");
        }
        System.out.println();
    }

    /**
     * Проверяет наличие телефона в справочнике
     *
     * @param phone
     * @return
     */
    public boolean containsPhone(String phone) {
        Collection<HashSet<String>> phones = phoneBook.values();
        for (HashSet<String> s : phones) {
            if (s.contains(phone)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет наличие телефона в справочнике, выводит сообщение
     *
     * @param phone
     * @return
     */
    public void containsPhoneNumber(String phone) {
        System.out.println(
                containsPhone(phone) ? "Телефон " + phone + " содержится в справочнике" :
                        "Телефон " + phone + " не содержится в справочнике");
    }

    /**
     * Возвращает первый контакт с указанным номером телефона
     *
     * @param phone указанный номер телефона
     * @return
     */
    public void getFullNameByPhoneNumber(String phone) {
        if (!containsPhone(phone)) {
            System.out.println("Телефон в списке контактов не найден.");
            return;
        }
        for (Map.Entry<String, HashSet<String>> contact : phoneBook.entrySet()) {
            if (contact.getValue().contains(phone)) {
                System.out.println("Контакт "+contact.getKey()+" содержит телефон "+phone);
                return;
            }
        }
        System.out.println("Контакт не найден.");
    }
}
