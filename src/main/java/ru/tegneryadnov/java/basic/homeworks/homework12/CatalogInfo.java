package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatalogInfo {

    public final static File currentDir = new File(System.getProperty("user.dir"));

    public static List<String> getAllFilesDirectories() {
        List<String> currentDirFiles = new ArrayList<>();
        try {
            File[] files = currentDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    currentDirFiles.add("directory: " + file.getCanonicalPath());
                } else {
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
        for (String el : CatalogInfo.getAllFilesDirectories()) {
            System.out.println(el);
        }
    }

    public static List<FileInform> getAllFilesDirectories_() {
        List<FileInform> currentDirFiles = new ArrayList<>();
        currentDirFiles.add(new FileInform("..", FileType.DIRECTORY));
        File[] files = currentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                currentDirFiles.add(new FileInform(/*file.getCanonicalPath()*/file.getName(), FileType.DIRECTORY));
            } else {
                currentDirFiles.add(new FileInform(file.getName(), FileType.FILE));
            }
        }
        currentDirFiles.sort(new Comparator<FileInform>() {
            public int compare(FileInform o1, FileInform o2) {
                return o1.fileType.compareTo(o2.fileType);
            }
        });
        return currentDirFiles;
    }

    public static void displayAllFilesDirectories_() {
        for (FileInform el : CatalogInfo.getAllFilesDirectories_()) {
            System.out.println(el);
        }
    }

    public static List<FileInform> getFilesWithExt(String ext) {
        List<FileInform> currentDirFiles = new ArrayList<>();
        return null;
    }
}
