package ru.tegneryadnov.java.basic.homeworks.homework7;

public class Utils {
    public static String firstCharToLowerCase(String str) {
        if (str == null) return null;
        if (str.isEmpty()) return "";
        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length() - 1);
    }
}
