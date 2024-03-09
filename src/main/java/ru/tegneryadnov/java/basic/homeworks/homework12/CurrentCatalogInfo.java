package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CurrentCatalogInfo {
    enum fileType = {DIRECTORY, FILE}
    public final static File currentDir = new File(System.getProperty("user.dir"));

    public static List<String> getAllFilesDirectories() {
        List<String> currentDirFiles = new ArrayList<>();
        try {
            File[] files = currentDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    currentDirFiles.add("directory: " + file.getCanonicalPath());
                    //System.out.println("directory: " + file.getCanonicalPath());
                    // Вывести файлы подкаталогов, ежели нужно: displayAllFilesDirectories(file);
                } else {

/*                    // Форматирование даты изменения файла с миллисекунд на адекватную
                    long lastModified = file.lastModified();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");*/

                    /*System.out.println("     file: " + file.getCanonicalPath() + ", размер файла: "
                            + file.length() + " byte, дата изменения: " + sdf.format(new Date(lastModified)));*/

/*                    System.out.println("     file: " + file.getCanonicalPath() + ", размер файла: "
                            + file.length() + " byte");*/

                    //System.out.println("     file: " + file.getCanonicalPath());
                    currentDirFiles.add("     file: " + file.getCanonicalPath());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        currentDirFiles.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.toString().compareTo(o1.toString());
            }
        });
        return currentDirFiles;
    }

    public static void displayAllFilesDirectories() {
        for (String el : CurrentCatalogInfo.getAllFilesDirectories()) {
            System.out.println(el);
        }
    }

    public static List<FileType> getAllFilesDirectories() {
        List<FileType> currentDirFiles = new ArrayList<>();
        try {
            File[] files = currentDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    currentDirFiles.add(new FileType(file.getCanonicalPath(),);
                    currentDirFiles.add("directory: " + file.getCanonicalPath());
                    //System.out.println("directory: " + file.getCanonicalPath());
                    // Вывести файлы подкаталогов, ежели нужно: displayAllFilesDirectories(file);
                } else {

/*                    // Форматирование даты изменения файла с миллисекунд на адекватную
                    long lastModified = file.lastModified();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");*/

                    /*System.out.println("     file: " + file.getCanonicalPath() + ", размер файла: "
                            + file.length() + " byte, дата изменения: " + sdf.format(new Date(lastModified)));*/

/*                    System.out.println("     file: " + file.getCanonicalPath() + ", размер файла: "
                            + file.length() + " byte");*/

                    //System.out.println("     file: " + file.getCanonicalPath());
                    currentDirFiles.add("     file: " + file.getCanonicalPath());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        currentDirFiles.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.toString().compareTo(o1.toString());
            }
        });
        return currentDirFiles;
    }

    public static List<File> getFilesWithExt() {
        return null;
    }
}
