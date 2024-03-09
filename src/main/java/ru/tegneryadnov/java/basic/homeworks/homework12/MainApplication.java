package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Каталог проекта: " + CatalogInfo.currentDir);
        System.out.println("Структура каталога:");
        CatalogInfo.displayAllFilesDirectories_();
    }

}
