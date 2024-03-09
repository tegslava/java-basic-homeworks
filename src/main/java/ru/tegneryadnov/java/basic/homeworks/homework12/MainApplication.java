package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Каталог проекта: " + CurrentCatalogInfo.currentDir);
        System.out.println("Структура каталога:");
        CurrentCatalogInfo.displayAllFilesDirectories();
    }

}
