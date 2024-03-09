package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс для утилит информирования о структуре каталога
 */
public class CatalogInfo {
    private static List<FileInform> getFileInforms(File currentDir) {
        if (currentDir == null) {
            throw new IllegalArgumentException("currentDir must not be null!");
        }
        List<FileInform> fileInforms = new ArrayList<>();
        for (File file : currentDir.listFiles()) {
            fileInforms.add(new FileInform(file));
        }
        return fileInforms;
    }

    /**
     * Отображает структуру каталога currentDir
     *
     * @param currentDir объект типа File
     */
    public static void show(File currentDir) {
        if (currentDir == null) {
            throw new IllegalArgumentException("currentDir must not be null!");
        }
        List<FileInform> fileInforms = getFileInforms(currentDir);
        fileInforms.sort(new Comparator<FileInform>() {
            @Override
            public int compare(FileInform o1, FileInform o2) {
                return o1.fileType.compareTo(o2.fileType);
            }
        });
        System.out.println("Структура каталога:");
        for (FileInform fileInform : fileInforms) {
            System.out.println(fileInform);
        }
    }

    /**
     * Возвращает список полных имен файлов в каталоге currentDir, с раширением fileExt
     *
     * @param currentDir объект типа File
     * @param fileExt    расширение файла, строковое значение
     * @return List<String>
     */
    public static List<String> getFileNamesWithExt(File currentDir, String fileExt) {
        if (currentDir == null) {
            throw new IllegalArgumentException("currentDir must not be null!");
        }
        if ((fileExt == null) || fileExt.isEmpty()) {
            throw new IllegalArgumentException("fileExt must not be null or empty!");
        }
        List<FileInform> fileInforms = getFileInforms(currentDir);
        List<String> files = new ArrayList<>();
        String fExt = fileExt.toUpperCase();
        for (FileInform fileInform : fileInforms) {
            if (getFileExtension(fileInform.file).toUpperCase().equals(fExt)) {
                files.add(fileInform.file.getName());
            }
        }
        return files;
    }

    /**
     * Возвращает расширение файла file
     *
     * @param file
     * @return раширения файла, строка
     */
    private static String getFileExtension(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file must not be null!");
        }
        String extension = "";
        String name = file.getName();
        int startIndex = name.lastIndexOf(".");
        if (startIndex < 0)
            return extension;
        extension = name.substring(startIndex + 1, name.length());
        return extension;
    }
}
