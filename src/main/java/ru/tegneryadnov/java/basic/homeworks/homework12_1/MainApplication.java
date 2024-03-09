package ru.tegneryadnov.java.basic.homeworks.homework12_1;

import java.io.File;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        File currentDir = new File(System.getProperty("user.dir"));
        System.out.println("Каталог проекта: " + currentDir);
        initTest(currentDir);
        CatalogInfo.show(currentDir);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.printf("В каталоге %s найдены текстовые файлы:\n", currentDir);
            CatalogInfo.getFileNamesWithExt(currentDir, "txt").forEach(System.out::println);
            while (true) {
                System.out.print("Введите имя файла для редактирования, (для выхода из программы введите \"end\"): ");
                String inputFileName = scanner.nextLine();
                if (inputFileName.trim().equals("end")) {
                    break;
                }
                if (!(new File(inputFileName)).exists()) {
                    System.out.printf("Файл %s не найден.\n", inputFileName);
                } else {
                    System.out.printf("Распечатка файла %s:\n", inputFileName);
                    ReadWriteTextFiles.bufferedInputStreamReader(inputFileName);
                    System.out.println();
                    do {
                        System.out.printf("Введите новую строку для добавления в файл %s. \"end\" - выход)\n", inputFileName);
                        System.out.print(">");
                        String inputLine = scanner.nextLine();
                        if (inputLine.trim().equals("end")) {
                            break;
                        }
                        ReadWriteTextFiles.bufferedOutputStreamLineWriter(inputFileName, inputLine, true);
                    }
                    while (true);
                }
            }
        } finally {
            scanner.close();
            System.out.println();
            System.out.println("Программа завершена.");
        }
    }

    private static void initTest(File currentDir) {
        String[] sArr1 = {"Тестовые записи", "для file1.txt "};
        String[] sArr2 = {"Тестовые записи", "для file2.txt "};
        String[] sArr3 = {"Тестовые записи", "для file3.txt "};
        ReadWriteTextFiles.bufferedOutputStreamArrWriter("file1.txt", sArr1, false);
        ReadWriteTextFiles.bufferedOutputStreamArrWriter("file2.txt", sArr2, false);
        ReadWriteTextFiles.bufferedOutputStreamArrWriter("file3.txt", sArr3, false);
    }
}
