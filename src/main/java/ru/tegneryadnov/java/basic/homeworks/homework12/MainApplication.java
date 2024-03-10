package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.File;

public class MainApplication {
    public static void main(String[] args) {
        File currentDir = new File(System.getProperty("user.dir"));
        System.out.println("Каталог проекта: " + currentDir);
        CatalogInfo.initTest(currentDir);
        CatalogInfo.show(currentDir);
        System.out.printf("В каталоге %s найдены текстовые файлы:\n", currentDir);
        CatalogInfo.getFileNamesWithExt(currentDir, "txt").forEach(System.out::println);
        ReadWriteTextFiles.fileEdit();
        System.out.println();
        System.out.println("Программа завершена.");
    }
}
