package ru.tegneryadnov.java.basic.homeworks.homework10;

public class MainApplication {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров И.В.", "+7(555) 985-345-19-35");
        phoneBook.add("Петров И.В.", "+7(777) 985-345-19-37");
        phoneBook.add("Иванов П.С.", "+7(111) 985-345-19-31");
        phoneBook.add("Иванов П.С.", "+7(222) 985-345-19-32");
        phoneBook.add("Иванов П.С.", "+7(333) 985-345-19-33");
        phoneBook.add("Степанов М.К.", "+7(44) 985-345-19-34");
        phoneBook.add("Васильев К.Л.");
        phoneBook.contactInfo("Петров И.В.");
        phoneBook.contactInfo("Иванов П.С.");
        phoneBook.contactInfo("Степанов М.К.");
        phoneBook.contactInfo("Васильев К.Л.");
        phoneBook.contactInfo("Неизвестный Э.K.");
        phoneBook.find("Иванов П.С.");
        phoneBook.containsPhoneNumber("+7(222) 985-345-19-32");
        phoneBook.containsPhoneNumber("+7(888) 985-345-19-38");
        phoneBook.getFullNameByPhoneNumber("+7(222) 985-345-19-32");
    }
}
