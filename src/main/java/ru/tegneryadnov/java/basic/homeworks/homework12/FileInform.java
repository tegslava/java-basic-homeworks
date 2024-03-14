package ru.tegneryadnov.java.basic.homeworks.homework12;

import java.io.File;

/**
 * Класс для хранения доп. информации о файле, используется для последующей сортировки файлов и папок
 * fileType типа FileType используется для сортировки
 * Папки отображаются в угловых скобках
 */
public class FileInform {
    public final File file;
    public final FileType fileType;

    public FileInform(File file) {
        this.file = file;
        this.fileType = file.isDirectory() ? FileType.DIRECTORY : FileType.FILE;
    }

    @Override
    public String toString() {
        return fileType.equals(FileType.DIRECTORY) ? String.format("<%s>", file.getName()) : file.getName();
    }
}